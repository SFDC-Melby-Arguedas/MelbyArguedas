package MainPage;

import Pages.*;
import org.junit.Test;
import org.testng.annotations.BeforeTest;
import sun.applet.Main;

/**
 * Created by Melby Arguedas on 8/10/2015.
 */
public class AddOportunitiesToProject {
    String username = "melbya@gmail.com";
    String password = "Alice2012";
    String accountName = "MelAccount";
    String opportunityName = "MelOpportunity";


    @Test
    public void requirementsExam() {
        String AccountName = "AccountTest1";
        LoginPage loginPage = new LoginPage().setUsername(username)
        .setPassword(password);
        MainApp mainApp= loginPage.clickLoginSalesForce();
        HomePage homePage= mainApp.goToHome();
        homePage.goToHomeTab()
                .openMenu();
        Account account = mainApp.goToAccount();
        account.setAccountName(accountName)
                .clickSaveAccount();
        Opportunity opportunity= mainApp.goToOpportunity();
        opportunity.goToOpportunityTab()
                .clickNewBtn()
                .setOpportunityName(opportunityName)
                .setCloseDate()
                .setStage();
        LookUpAccountName lookUpAccountName= opportunity.clickAccountNameImg();
        lookUpAccountName.setAccount(AccountName);
        opportunity.clickSave();

    }

}

