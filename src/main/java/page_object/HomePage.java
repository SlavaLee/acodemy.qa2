package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productElements = By.xpath("//ul[contains(@class, 'products')]//li");
    private final By colorSelection = By.id("pa_color");

    public List<WebElement> getAllProducts() {
        return driver.findElements(productElements);
    }

    public void clickOnProduct(String productName) {
        for(WebElement product : getAllProducts()) {
            if(product.getText().contains(productName)) {
                product.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        Select sColor = new Select(driver.findElement(colorSelection));
        sColor.selectByVisibleText(color);
    }
}