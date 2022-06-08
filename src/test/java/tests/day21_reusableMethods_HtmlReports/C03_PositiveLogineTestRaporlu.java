package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLogineTestRaporlu extends TestBaseRapor {
    BrcPage brcPage= new BrcPage();

    @Test
    public void tese01() {
        extentTest = extentReports.createTest("Positive Login", "Geçerli username ve şifre ile geçiş yapılabilmeli");
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tıklandı");

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Geçerli e-mail yazıldı");

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        extentTest.info("Geçerli şifre yazıldı");

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        extentTest.info("login butonuna basıldı");

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUsername= brcPage.kullaniciProfilIsmi.getText();
        String expextedUsername= ConfigReader.getProperty("brcValidUsername");

        Assert.assertEquals(actualUsername, expextedUsername);
        extentTest.pass("kullanıcı başarılı şekilde giriş yaptı");

        Driver.closeDriver();
    }
}
