package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private By accountsTable = By.cssSelector("#accountTable");


    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountsTableVisible() {
        return waitForElementToBeVisible(accountsTable) != null;
    }
}
