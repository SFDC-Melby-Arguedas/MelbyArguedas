package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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

public class LoginPage {
    @FindBy (id = "username")
    @CacheLookup
    private WebElement username;

    @FindBy (id = "password")
    @CacheLookup
    private WebElement password;

    @FindBy (id = "Login")
    @CacheLookup
    private WebElement loginBtn;

    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;

    public LoginPage () {
        driver = new FirefoxDriver();
        baseUrl = "https://login.salesforce.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUsername(String usernameText){
        username.sendKeys(usernameText);
        return this;
    }

    public LoginPage setPassword(String passwordText){
        password.sendKeys(passwordText);
        return this;
    }

    public MainApp clickLoginSalesForce() {
        wait.until(ExpectedConditions
                .elementToBeClickable(loginBtn));
        loginBtn.click();
        return new MainApp(driver);
    }

    public MainApp sendDriver(){
        return  new MainApp(driver);
    }
}
