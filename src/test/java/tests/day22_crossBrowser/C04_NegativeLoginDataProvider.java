package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {
    BrcPage brcPage;

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri={{"fiuze@nehaber.com","54321"},
                                        {"kasgd@jah.com","8465"},
                                        {"hıyar@cucu.mbr","slnim"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userMail, String password) {
        brcPage= new BrcPage();
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();

        //test data user email: dataprovider'dan alalım,
        brcPage.emailTextBox.sendKeys(userMail);

        //test data password : dataprovider'dan alalım
        brcPage.passwordTextBox.sendKeys(password);

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }
}
