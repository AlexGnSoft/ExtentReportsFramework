package pages.searched_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class SearchedPage extends BasePage {

    public SearchedPage(WebDriver driver) {
        super(driver);
    }

    private final By searchedElement = By.xpath("//div[contains(text(),'About')]");
    String ExpectedElement = "About";

    public SearchedPage checkSearchedResult(){
        WebElement elementActual = driver.findElement(searchedElement);
        waitElementIsVisible(elementActual);
        Assert.assertTrue(elementActual.getText().contains(ExpectedElement));

        return this;
    }
}
