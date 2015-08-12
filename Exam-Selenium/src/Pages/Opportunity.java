package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Melby Arguedas on 8/11/2015.
 */
public class Opportunity {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//a[@title='Opportunities Tab']")
    @CacheLookup
    private WebElement opportunityTab;

    @FindBy (xpath = "//input[@name='new']")
    @CacheLookup
    private WebElement newBtn;

    @FindBy (id="opp3")
    @CacheLookup
    private WebElement opportunityName;

    @FindBy (id="opp9")
    @CacheLookup
    private WebElement dateField;

    @FindBy (id="datePicker")
    @CacheLookup
    private WebElement calendar;

    @FindBy (xpath ="//td[contains(@class,'weekday todayDate highlight')]")
    @CacheLookup
    private WebElement todayDay;

    @FindBy (id="opp11")
    @CacheLookup
    private WebElement stage;

    @FindBy (xpath = "//option[@value='Prospecting']")
    @CacheLookup
    private WebElement prospectingStage;

    @FindBy (id="opp4_lkwgt")
    @CacheLookup
    private WebElement btnLookUp;

    @FindBy (name ="save")
    @CacheLookup
    private WebElement btnSave;

    private String opportunityNameText;



    public Opportunity (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public Opportunity goToOpportunityTab(){
        opportunityTab.click();
        return this;
    }
    public Opportunity clickNewBtn(){
        wait.until(ExpectedConditions
                .elementToBeClickable(newBtn));
        newBtn.click();
        return this;
    }

    public Opportunity setOpportunityName(String opportunityNameText ) {
        opportunityName.sendKeys(opportunityNameText);
        return this;
    }

    public Opportunity setCloseDate(){
        dateField.click();
        this.driver.switchTo().activeElement().click();
        calendar.click();
        todayDay.click();
        return this;
    }

    public Opportunity setStage() {
        stage = wait.until(ExpectedConditions.visibilityOf(prospectingStage));
        prospectingStage.click();
        return this;
    }

    public LookUpAccountName clickAccountNameImg(){
        wait.until(ExpectedConditions.visibilityOf(btnLookUp));
        btnLookUp.click();
        return new LookUpAccountName(driver);
    }

    public Opportunity clickSave(){
        wait.until(ExpectedConditions.visibilityOf(btnSave));
        btnSave.click();
        return this;
    }

}
