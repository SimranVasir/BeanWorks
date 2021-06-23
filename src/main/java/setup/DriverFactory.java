package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver = null;

    public static WebDriver getDriver(String browserName) {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.out.println("in chrome");
                WebDriverManager.chromedriver().version("90.0.4430.24").setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("enable-automation");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }
}
