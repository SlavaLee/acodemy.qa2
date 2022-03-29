package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LocalDriverManager;

public class HeaderPage {

    private final WebDriver driver = LocalDriverManager.getInstance();

    public By searchField = By.id("woocommerce-product-search-field-0");

    public void searchForAProduct(String nameOfProduct) {
        driver.findElement(searchField).sendKeys(nameOfProduct);
        driver.findElement(searchField).submit();
    }
}