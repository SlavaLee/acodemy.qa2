import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page_object.CartPage;
import page_object.HeaderPage;
import page_object.HomePage;
import page_object.ProductPage;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import static constans.Products.pilseta;


@Slf4j
public class Coupon {

    private final WebDriver driver = LocalDriverManager.getInstance();

    HeaderPage header = new HeaderPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @BeforeEach
    public void init() {
        log.info("Step 1: User opens Online shop web page");
        driver.get(PropertiesReader.getProperties().getProperty("home.page"));
    }

    @Test
    public void closeBanner() {
        log.info("Step 2: The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.viewCart();
        log.info("Step 22: The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.submitCookies();
        log.info("Step 2 'Add to cart' button.");
            productPage.loginElement();
        log.info("Step 3: The user types 'easy_discount' into the 'coupon code' field.");
        cartPage.enterEmail("d3f@inbox.lv");
        log.info("Step 4: The user types 'easy_discount' into the 'coupon code' field.");
        cartPage.enterPassword("Skolotaja1980");
        log.info("Step 5: The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.setSubmitButton();
        log.info("Step 6 The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.viewList();
        log.info("Step 7 The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.viewVacancy();
        log.info("Step 2: The user clicks on product: " + pilseta);
        homePage.clickOnProduct(pilseta);
    }

//    @AfterEach
//    public void tearDown() {
//        LocalDriverManager.closeDriver();
//    }
}