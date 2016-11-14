package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchJobPage {
	
	private WebDriver driver;
	private String keywordId = "keyword";
	private String locationId ="loc_placeholder";
	private String searchBtnId = "jSearchSubmit";
    
    public SearchJobPage(WebDriver driver){
        this.driver=driver;
    }
    
    public boolean isPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".font_header_promo"),"Welcome to Akamai Careers"));
        return true;
    }
    
    public SearchResultPage searchJob(String keyword, String location){
    	if(keyword != null) {
    		driver.findElement(By.id("keyword")).clear();
	        WebElement keywordField = driver.findElement(By.id(keywordId));
	        keywordField.sendKeys(keyword);
    	}
    	if(location != null){    		
    		driver.findElement(By.id(locationId)).click();
    		WebElement selectedLocationElem = driver.findElement(By.cssSelector("input.default"));
    		selectedLocationElem.clear();
    		selectedLocationElem.sendKeys(location);
    		selectedLocationElem.click();
    	}
        WebElement searchBtn = driver.findElement(By.id(searchBtnId));
        searchBtn.click();

        return new SearchResultPage(driver);
    }
}
