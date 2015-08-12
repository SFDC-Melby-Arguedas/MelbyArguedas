package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Melby Arguedas on 8/12/2015.
 */
public class LookUpAccountName {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "searchFrame")
    @CacheLookup
    private WebElement lookUpWindow;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement label;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement btnGo;

    @FindBy(name = "go")
    @CacheLookup
    private WebElement btnClose;


    private String windowsID;
    private String accountName;

    public LookUpAccountName (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 40);
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> listWindows = new LinkedList<String>(setWindows);
        this.driver.switchTo().window(listWindows.getLast());

        PageFactory.initElements(driver, this);

        try {

            windowsID = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            windows = driver.getWindowHandles();
            LinkedList<String> windowsList = new LinkedList(windows);
            driver.switchTo().window(windowsList.getLast());

            wait.until(ExpectedConditions
                    .frameToBeAvailableAndSwitchToIt(lookUpWindow));


        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }

    }

    public LookUpAccountName setAccount(String accountName){
        label.sendKeys(accountName);
        wait.until(ExpectedConditions.visibilityOf(btnGo));
        btnGo.click();
        return this;

    }

}
