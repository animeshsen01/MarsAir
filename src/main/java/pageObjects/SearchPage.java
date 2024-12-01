package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="departing")
	public WebElement departing;

	@FindBy(id="returning")
	public WebElement returning;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='content']/p")
	public WebElement seatAvailability;

}
