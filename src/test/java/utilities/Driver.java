package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM'de Driver icin TestBase class'ina extends etmek yerine
    Driver class'indan static meyhod'lar kullanarak
    driver olusturup' ilgili ayarlarin yapilmasi
    ve en sonda driver'in kapatilmasi tercih edilmistir

    POM'de Driver class'indaki getDriver() methodu'nun obje olusturarak kullanilmasini engellemek icin
    Singleton pattern kullanimi benimsenmistir

    Singleton Pattern: tekli kullanim, bir class'in farkli claslardan
    obje olusturularak kullanimini engellemek icin kullanilir

    Bunu saglamak icin yapmamiz gereken sey oldukca basit
    obje olusturmak icin kullailan constructor'i private yaptiginizda
    baska class'larda Driver class'indan obje olusturulmasi mumkun OLMAZ
     */

    public Driver(){

    }

    public static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver(); // opera destegi yakinda kalkacagi icin uzeri cizilmis
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){

        if (driver!=null) { // driver'a deger atanmissa
            driver.close();
            driver=null;
        }
    }

}
