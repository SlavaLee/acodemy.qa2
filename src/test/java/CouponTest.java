import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.HeaderPage;
import page_object.HomePage;

import static constants.Products.HOODIE;

@Slf4j
public class CouponTest {

    WebDriver driver;
    HeaderPage header;
    HomePage homePage;

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        this.header = new HeaderPage(driver);
        this.homePage = new HomePage(driver);
    }

    /*
    Hamcrest library assertions example:
    assertThat(driver.getTitle(), equalTo("Online shop – acodemy – Just another WordPress site"));
/   assertThat(driver.getTitle(), is("Online shop – acodemy – Just another WordPress site"));
     */

    @Test
    public void applyCouponCode() {

        log.info("Step 1: User open webpage");
        driver.get("https://shop.acodemy.lv");

        log.info("Step 2: User select product by product name" + HOODIE);
        homePage.clickOnProduct(HOODIE);

        homePage.selectColor("Green");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}