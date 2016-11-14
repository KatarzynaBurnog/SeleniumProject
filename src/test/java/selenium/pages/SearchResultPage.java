package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
	private WebDriver driver;
	
	private String searchNoResultCssSelector = ".search_result_sentence";
	private String nrOfResultsCssSelector = ".number_of_results";
	private String totalResultsCssSelector = ".total_results";
	
	private static final String SEARCH_NO_RESULT_TEXT = "did not return any job results";
	private static final String SEARCH_RESULT_TEXT = "results";
	
	public SearchResultPage(WebDriver driver){
        this.driver=driver;
    }

	public boolean noMatchingResultsForJobSearch(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(searchNoResultCssSelector), SEARCH_NO_RESULT_TEXT));
		return driver.findElement(By.cssSelector(searchNoResultCssSelector)).isDisplayed();
	}
	
	public boolean matchingResultsForJobSearch(){
		new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(nrOfResultsCssSelector), SEARCH_RESULT_TEXT));
		return Long.parseLong(driver.findElement(By.cssSelector(totalResultsCssSelector)).getText())>0?true:false;
	}
}
