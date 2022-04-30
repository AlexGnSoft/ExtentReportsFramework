package search_test;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;
import static constants.Constants.TimeoutVariables.SEARCHED_ELEMENT;
import static constants.Constants.Urls.GOOGLE_HOME_PAGE;

public class SearchTest extends BaseTest{

    @Test
    public void checkIsRedirectedToSearchedPage() throws InterruptedException {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("extentReports.html");
        extent.attachReporter(extentSparkReporter);
        ExtentTest test = extent.createTest("GoogleSearchTest", "This is a simple test to validate a Google Search Functionality");
        test.log(Status.INFO, "Starting Test");

        basePage.open(GOOGLE_HOME_PAGE);
        test.pass("Navigated to Google.com page");
        googleHomePage.inputToSearchAndClick(SEARCHED_ELEMENT);
        test.pass("Entered a world to Search Field AND Navigated to the search results page");
//      Thread.sleep(1000);
        searchedPage.checkSearchedResult();
        test.pass("Found element and did the test");
        test.info("Test is Completed");
        extent.flush();

    }
}
