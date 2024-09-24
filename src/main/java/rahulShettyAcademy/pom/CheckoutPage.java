package rahulShettyAcademy.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompnents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryField;
	
	@FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement checkoutBtn;
	
	By suggestedCountryModel = By.cssSelector(".ta-results");
	
	public void selectCountryName(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(countryField, countryName).build().perform();
		waitForElementToAppear(suggestedCountryModel);
		selectCountry.click();
	}
	
	public ConfirmationPage clickOnCheckoutBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(checkoutBtn).perform();
		checkoutBtn.click();
		ConfirmationPage successPg = new ConfirmationPage(driver);
		return successPg;
	}
	
	
}
