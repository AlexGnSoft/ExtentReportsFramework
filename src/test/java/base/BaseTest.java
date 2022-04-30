package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.google_home.GoogleHomePage;
import pages.searched_page.SearchedPage;
import settings.DriverSettings;

import static settings.Config.CLEAR_COOKIES_AND_STORAGE;

public class BaseTest {
    protected WebDriver driver = DriverSettings.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    protected SearchedPage searchedPage = new SearchedPage(driver);

    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
