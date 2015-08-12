package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Melby Arguedas on 8/10/2015.
 */
public class MainApp {

    private WebDriver driver;
    private WebDriverWait wait;

    public MainApp(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }
    public HomePage goToHome() {
        return new HomePage(driver);
    }

    public Account goToAccount(){
        return new Account(driver);
    }

    public Opportunity goToOpportunity (){
        return new Opportunity(driver);
    }
}



