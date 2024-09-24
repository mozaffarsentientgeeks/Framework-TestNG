package rahulShettyAcademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompnents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "userEmail")
	WebElement emailField;
	
	@FindBy(id = "userPassword")
	WebElement passwordField;
	
	@FindBy(id = "login")
	WebElement submitBtn;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public String getErrorMessage() throws InterruptedException {
		Thread.sleep(500);
		return errorMessage.getText();
	}
	
	public ProductCatalogue loginToApp(String uName, String password) {
		emailField.sendKeys(uName);
		passwordField.sendKeys(password);
		submitBtn.click();
		ProductCatalogue prodCatalogue = new ProductCatalogue(driver);
		return prodCatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
