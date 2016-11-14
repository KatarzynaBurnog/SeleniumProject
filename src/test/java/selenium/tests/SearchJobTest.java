package selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.pages.SearchJobPage;
import selenium.pages.SearchResultPage;

public class SearchJobTest {  
  private WebDriver driver;

  @Parameters({"url", "timeToWait", "geckodriverPath"})
  @BeforeClass
  public void setUp(String url, String timeToWait, String geckodriverPath) {
	  
	System.setProperty("webdriver.gecko.driver", geckodriverPath);
	driver = new FirefoxDriver();

	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Long.parseLong(timeToWait), TimeUnit.SECONDS);
  }
  
  @Test(priority = 1)
  public void logOutCustomerSearchForJob(){
	  SearchJobPage searchPage = new SearchJobPage(driver);
	  Assert.assertTrue(searchPage.isPageOpened());
	  SearchResultPage searchResultPage = searchPage.searchJob("Test", "Krakow");
	  Assert.assertTrue(searchResultPage.matchingResultsForJobSearch());
	  
  }
  
  @Test(priority = 1)
  public void logOutCustomerSearchWithNoMatchingResult(){
	  SearchJobPage searchPage = new SearchJobPage(driver);
	  SearchResultPage searchResultPage = searchPage.searchJob("XXX", null);
	  Assert.assertTrue(searchResultPage.noMatchingResultsForJobSearch());
  }

  @AfterClass
  public void tearDown() {
	driver.quit();
  }
}
