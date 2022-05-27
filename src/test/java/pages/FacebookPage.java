package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="(//*[@class='inputtext _55r1 _6luy'])[1]")
    public WebElement mailKutusu;

    @FindBy(id = "pass")
    public WebElement sifreKutusu;

    @FindBy(name = "login")
    public WebElement loginTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;
}
