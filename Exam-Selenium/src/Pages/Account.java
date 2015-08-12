package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Melby Arguedas on 8/10/2015.
 */
public class Account {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (id="acc2")
    @CacheLookup
    private WebElement accountName;

    @FindBy (name = "save")
    @CacheLookup
    private WebElement saveAccount;

    private String accountNameText;

    public Account (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

     public Account setAccountName(String accountNameText){
        accountName.sendKeys(accountNameText);
        return this;
    }

    public Account clickSaveAccount() {
        wait.until(ExpectedConditions
                .elementToBeClickable(saveAccount));
        saveAccount.click();
        return new Account(driver);
    }
}
