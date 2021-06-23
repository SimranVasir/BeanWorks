package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.RegisterPage;
import setup.DriverFactory;

import java.util.concurrent.TimeUnit;

public class RegisterSteps {

    MainPage mainPage;
    RegisterPage registerPage;
    WebDriver driver;

    public RegisterSteps() {
        this.driver = DriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.registerPage = new RegisterPage(driver);
        this.mainPage = new MainPage(driver);
    }

    @When("^the user clicks register button on main page$")
    public void clickRegister() {
        mainPage.clickRegister();
    }

    @When("^the user fills in registration form with (.*)$")
    public void fillRegisterationForm(String username) {
        registerPage.enterFirstName("Simran");
        registerPage.enterLastName("Vasir");
        registerPage.enterCity("Vancouver");
        registerPage.enterState("BC");
        registerPage.enterStreet("304 E 60th Ave");
        registerPage.enterZipCode("V4E3L7");
        registerPage.enterPhoneNumber("7788891234");
        registerPage.enterSSN("1234935");
        if (username.equalsIgnoreCase("randomUser")) {
            registerPage.enterUsername(RandomStringUtils.randomAlphanumeric(20));
        } else if (username.equalsIgnoreCase("emptyUser")) {
            registerPage.enterUsername("");
        } else {
            registerPage.enterUsername(username);
        }
        registerPage.enterPassword("test1234");
        registerPage.enterRepeatedPassword("test1234");
    }

    @And("^the user submits registration form$")
    public void register() {
        registerPage.clickRegister();
    }

    @Then("^user should see successful registration message on next page$")
    public void verifySuccessfulRegistration() {
        Assert.assertTrue(driver.getPageSource().contains("successful"));
    }

    @And("the users closes the browser")
    public void closeBrowser() {
        driver.close();
    }

    @And("^the user logs out$")
    public void verifyMainPage() {
        mainPage.logOut();
    }

    @Then("^the user should see a user already exists registration error$")
    public void userAlreadyExistsErrorOccurs() {
        Assert.assertTrue(registerPage.isUserNameExistsErrorVisible());
    }

    @Then("^the user should see a username required error message$")
    public void userRequiredErrorOccurs() {
        Assert.assertTrue(registerPage.isUserNameRequiredErrorVisible());
    }

}
