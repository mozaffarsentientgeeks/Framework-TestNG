package rahulShettyAcademy.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompnents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutBtn;
	
	public boolean verifyProductDisplay(String prodName) {
		boolean prodFound = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(prodName));
		return prodFound;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutBtn.click();
		CheckoutPage chechoutPg = new CheckoutPage(driver);
		return chechoutPg;
	}
}
