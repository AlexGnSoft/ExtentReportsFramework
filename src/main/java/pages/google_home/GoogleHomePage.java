package pages.google_home;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import java.util.concurrent.TimeUnit;
import static constants.Constants.TimeoutVariables.IMPLICITY_WAIT;

public class GoogleHomePage extends BasePage {
    private final By searchingField = By.xpath("//input[@name='q']");

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Для поиска вводим {input} и нажимаем ENTER с клавиатуры")
    public GoogleHomePage inputToSearchAndClick(String input){
        WebElement elementToSearch = driver.findElement(searchingField);
        waitElementIsVisible(elementToSearch).sendKeys(input);
        elementToSearch.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);

        return this;
    }
}
