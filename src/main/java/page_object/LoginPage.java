package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver = LocalDriverManager.getInstance();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesReader.getProperties().getProperty("implicit.wait"))));

    private final By emailNameField = By.name("email");
    private final By passwordNameField = By.name("password");

    public void enterEmail(String emailName) {
        driver.findElement(emailNameField).sendKeys(emailName);
    }

    public void enterPassword(String passwordKey) {
        driver.findElement(passwordNameField).sendKeys(passwordKey);
    }
}