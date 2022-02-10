package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public By searchField = By.id("woocommerce-product-search-field-0");

    public void searchForAProduct(String nameOfProduct) {
        driver.findElement(searchField).sendKeys(nameOfProduct);
        driver.findElement(searchField).submit();
    }
}