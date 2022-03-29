import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page_object.LoginPage;
import page_object.HomePage;
import page_object.MenuPage;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import static constans.ExpiredDate.expiredText;

@Slf4j
public class PageRemoverTest {

    private final WebDriver driver = LocalDriverManager.getInstance();

    HomePage homePage = new HomePage();
    MenuPage productPage = new MenuPage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void init() {
        log.info("Step 1: The user opens job ads web page");
        driver.get(PropertiesReader.getProperties().getProperty("home.page"));
    }

    @Test
    public void closeBanner() {

        log.info("Step 2: The user closes popup banner");
        productPage.setCloseBanner();

        log.info("Step 3: The user agrees to use cookie by pressing 'ok' button.");
        productPage.submitCookies();

        log.info("Step 4: The user clicks on 'Login' button.");
        productPage.loginElement();

        log.info("Step 5: The user types email address into the 'E-mail or username' field.");
        loginPage.enterEmail("d3f@inbox.lv");

        log.info("Step 6: The user types password into the 'Password' field.");
        loginPage.enterPassword("Skola2022");

        log.info("Step 7: The user his name.");
        productPage.setSubmitButton();

        log.info("Step 8: The user clicks on 'My job ads'.");
        productPage.myName();

        log.info("Step 9: The user search for specific word");
        productPage.myVacancy();

        log.info("Step 10: The user clicks on that vacancy: " + expiredText);
        homePage.clickOnProduct(expiredText);

        log.info("Step 11: The user removes saved vacancy from his list");
        productPage.setDeleteButton();
    }

    @AfterEach
    public void tearDown() {
        LocalDriverManager.closeDriver();
    }
}