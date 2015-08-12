package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Melby Arguedas on 8/10/2015.
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/home/home.jsp']")
    @CacheLookup
    private WebElement menuTab;

   @FindBy(id = "createNewButton")
    @CacheLookup
    private WebElement menuHome;

    @FindBy (xpath = "//a[@class='menuButtonMenuLink accountMru']")
    @CacheLookup
    private WebElement accountLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    public HomePage goToHomeTab(){
        menuTab.click();
        return new HomePage(driver);
    }

    public HomePage openMenu(){
        menuHome.click();
        accountLink.click();
        return this;
    }
}



