package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By registerLink = By.cssSelector("#leftPanel a[href='register.htm']");
    private By logOutLink = By.cssSelector("#leftPanel a[href='/parabank/logout.htm']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void logOut() {
        driver.findElement(logOutLink).click();
    }
}
