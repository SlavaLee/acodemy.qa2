package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPage {

    private final WebDriver driver = LocalDriverManager.getInstance();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesReader.getProperties().getProperty("implicit.wait"))));

    private final By couponCodeField = By.id("coupon_code");
    private final By applyCouponButton = By.name("apply_coupon");
    private final By successMessage = By.className("woocommerce-message");

    public void enterCoupon(String code) {
        driver.findElement(couponCodeField).sendKeys(code);
    }

    public void applyCoupon() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(applyCouponButton));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//form[contains(@class,'processing')]"))));
    }

    public void checkSuccessMessage(String message) {
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        assertThat(driver.findElement(successMessage).getText(), equalTo(message));
    }
}