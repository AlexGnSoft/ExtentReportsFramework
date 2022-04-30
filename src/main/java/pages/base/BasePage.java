package pages.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static constants.Constants.TimeoutVariables.EXPLICITY_WAIT;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу {url}")
    public void open(String url){
        driver.get(url);
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICITY_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
