package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalDriverManager;
import utils.PropertiesReader;

import java.time.Duration;

public class MenuPage {

    private final WebDriver driver = LocalDriverManager.getInstance();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(PropertiesReader.getProperties().getProperty("implicit.wait"))));

    private final By closeBanner = By.xpath("//*[@class=\"jsx-4189752321 close-modal-button__content\"]");
    private final By closeCookies = By.id("rcc-confirm-button");
    private final By loginButton = By.xpath("//span[@class=\"jsx-1179908699 menu-content__pointer\"]");
    private final By submitButton = By.xpath("//*[@class=\"jsx-1364437967 login-form__submit\"]");
    private final By myNameButton = By.xpath("//*[@class=\"jsx-1778375531 select__btn select__btn--light\"]");
    private final By myVacancyButton = By.linkText("Мои вакансии");
    private final By deleteButton = By.xpath("//span[contains(text(), \"Удалить\")]");

    public void setCloseBanner() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeBanner));
        driver.findElement(closeBanner).click();
    }

    public void submitCookies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeCookies));
        driver.findElement(closeCookies).click();
    }

    public void loginElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }

    public void setSubmitButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        driver.findElement(submitButton).click();
    }

    public void myName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myNameButton));
        driver.findElement(myNameButton).click();
    }

    public void myVacancy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myVacancyButton));
        driver.findElement(myVacancyButton).click();
    }

    public void setDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        driver.findElement(deleteButton).click();
    }
}