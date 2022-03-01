import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page_object.CartPage;
import page_object.HeaderPage;
import page_object.HomePage;
import page_object.ProductPage;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import static constans.Colors.BLUE;
import static constans.Messages.COUPON_IS_APPLIED;
import static constans.Products.HOODIE;


@Slf4j
public class CouponTest {

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
    public void applyCouponCode() {
        log.info("Step 2: The user clicks on product: " + HOODIE);
        homePage.clickOnProduct(HOODIE);

        log.info("Step 3: The user selects a 'Blue' colour from the colour options bar.");
        productPage.selectColor(BLUE);

        log.info("Step 4: The user selects logo options 'Yes' from the option bar.");
        productPage.selectLogo(true);

        log.info("Step 5: The user adds Hoodie to cart by pressing 'Add to cart' button.");
        productPage.addToCartjs();

        log.info("Step 6: The user clicks on the 'view cart' button.");
        productPage.viewCart();

        log.info("Step 7: The user types 'easy_discount' into the 'coupon code' field.");
        cartPage.enterCoupon("easy_discount");

        log.info("Step 8: The user applied coupon code 'easy_discount'.");
        cartPage.applyCoupon();

        log.info("Step 9: The user sees the message 'Coupon code applied successfully'.");
        cartPage.checkSuccessMessage(COUPON_IS_APPLIED);

        log.info("Step 10: The user types 'additional_discount' into the 'coupon code' field.");
        cartPage.enterCoupon("additional_discount");

        log.info("Step 11: The user applied coupon code 'additional_discount'.");
        cartPage.applyCoupon();

        log.info("Step 12: The user sees the message 'Coupon code applied successfully'.");
        cartPage.checkSuccessMessage(COUPON_IS_APPLIED);
    }

    @AfterEach
    public void tearDown() {
        LocalDriverManager.closeDriver();
    }
}