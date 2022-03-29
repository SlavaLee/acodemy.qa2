package step_definitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.LocalDriverManager;

public class CommonStepsDefs {

    WebDriver driver = LocalDriverManager.getInstance();

    @Given("user open web page {string}")
    public void userOpenWebPage(String url) {
        driver.get(url);
    }
}
