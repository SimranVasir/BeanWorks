package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
import pages.LoginPage;
import setup.DriverFactory;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    LoginPage loginPage;
    AccountsPage accountsPage;
    WebDriver driver;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.loginPage = new LoginPage(driver);
        this.accountsPage = new AccountsPage(driver);
    }

    @When("^the user logs in with username (.*) and password (.*) and clicks login$")
    public void enterLoginCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("^the user goes to Parabank website$")
    public void goToParabank() {
        driver.get("https://parabank.parasoft.com/parabank");
    }

    @Then("^the user should arrive on Accounts page$")
    public void verifyMainPage() {
        Assert.assertTrue(accountsPage.isAccountsTableVisible());
    }
}
