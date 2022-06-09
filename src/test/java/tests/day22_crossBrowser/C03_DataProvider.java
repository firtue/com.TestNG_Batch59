package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01() {

        AmazonPage amazonPage= new AmazonPage();

        // amazon anasayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella'yı aratalım
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuçların Nutella içerdiğini kontrol edelim
        String expectedKelime = "Nutella";
        String actualSonucYazısı= amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazısı.contains(expectedKelime));

        // sayfayı kapatalım
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object [][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"çiğdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }


    @Test(dataProvider = "AranacakKelimeler")
    // arayacağımız kelimeleri bir liste gibi tutup
    // bana yollayacak bir veri sağlayıcı oluşturacağız
    public void dataProviderTes(String arananKelime) {
        AmazonPage amazonPage= new AmazonPage();

        // amazon anasayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, çiğdem, Netherlands kelieleri aratalım
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        // sonuçların kelimeleri içerdiğini kontrol edelim
        String expectedKelime = arananKelime;
        String actualSonucYazısı= amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazısı.contains(expectedKelime));

        // sayfayı kapatalım
        Driver.closeDriver();
    }
}
