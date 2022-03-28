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
    private final By closeBanner = By.xpath("//*[@class=\"jsx-4189752321 close-modal-button__content\"]");
    private final By closeCookies = By.id("rcc-confirm-button");
    private final By myNameButton = By.xpath("//*[@class=\"jsx-1778375531 select__btn select__btn--light\"]");
    private final By myVacancyButton = By.linkText("Мои вакансии");
    private final By submitButton = By.xpath("//*[@class=\"jsx-1364437967 login-form__submit\"]");
    private final By loginButton = By.xpath("//span[@class=\"jsx-1179908699 menu-content__pointer\"]");

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeBanner));
        driver.findElement(closeBanner).click();
    }
    public void submitCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeCookies));
        driver.findElement(closeCookies).click();
    }
    public void viewList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myNameButton));
        driver.findElement(myNameButton).click();
    }    public void viewVacancy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myVacancyButton));
        driver.findElement(myVacancyButton).click();
    }
    public void setSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }
    public void loginElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

/*    public void addToCartjs() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productCartButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("__next"))));
        js.executeScript("arguments[0].click();", driver.findElement(productCartButton));

    }*/
}