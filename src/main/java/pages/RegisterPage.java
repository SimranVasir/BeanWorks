package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private By usernameField = By.cssSelector("#rightPanel input[name='customer.username']");
    private By passwordField = By.cssSelector("#rightPanel input[name='customer.password']");
    private By passwordRepeatedField = By.cssSelector("#rightPanel input[name='repeatedPassword']");
    private By firstNameField = By.cssSelector("#rightPanel input[name='customer.firstName']");
    private By lastNameField = By.cssSelector("#rightPanel input[name='customer.lastName']");
    private By streetField = By.cssSelector("#rightPanel input[name='customer.address.street']");
    private By cityField = By.cssSelector("#rightPanel input[name='customer.address.city']");
    private By stateField = By.cssSelector("#rightPanel input[name='customer.address.state']");
    private By zipCodeField = By.cssSelector("#rightPanel input[name='customer.address.zipCode']");
    private By phoneNumberField = By.cssSelector("#rightPanel input[name='customer.phoneNumber']");
    private By ssnField = By.cssSelector("#rightPanel input[name='customer.ssn']");
    private By registerButton = By.cssSelector("#rightPanel .button[value='Register']");
    private By registrationErrorSpan = By.cssSelector("#customerForm .error");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterRepeatedPassword(String password) {
        driver.findElement(passwordRepeatedField).sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterStreet(String street) {
        driver.findElement(streetField).sendKeys(street);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phoneNum) {
        driver.findElement(phoneNumberField).sendKeys(phoneNum);
    }

    public void enterSSN(String ssn) {
        driver.findElement(ssnField).sendKeys(ssn);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public boolean isUserNameExistsErrorVisible() {
        WebElement errorMessage = waitForElementToBeVisible(registrationErrorSpan);
        return errorMessage.getText().contains("This username already exists.");
    }

    public boolean isUserNameRequiredErrorVisible() {
        WebElement errorMessage = waitForElementToBeVisible(registrationErrorSpan);
        return errorMessage.getText().contains("Username is required.");
    }

}
