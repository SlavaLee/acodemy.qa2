package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import java.time.Duration;

public class ProductPage {

    private final WebDriver driver = LocalDriverManager.getInstance();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesReader.getProperties().getProperty("implicit.wait"))));

    private final By colorSelection = By.id("pa_color");
    private final By logoSelection = By.id("logo");
    private final By productCartButton = By.xpath("//div//button[contains(@class,'single_add_to_cart_button')]");
    private final By viewCartButton = By.xpath("//div[@class='woocommerce']//a[text()='View cart']");

    public void selectColor(String color) {
        wait.until(ExpectedConditions.presenceOfElementLocated(colorSelection));
        Select sColor = new Select(driver.findElement(colorSelection));
        sColor.selectByVisibleText(color);
    }

    public void selectLogo(boolean isLogo) {
        Select sLogo = new Select(driver.findElement(logoSelection));
        if (isLogo) {
            sLogo.selectByVisibleText("Yes");
        } else {
            sLogo.selectByVisibleText("No");
        }
    }

    public void viewCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartButton));
        driver.findElement(viewCartButton).click();
    }

    public void addToCartjs() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productCartButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(productCartButton));
    }
}