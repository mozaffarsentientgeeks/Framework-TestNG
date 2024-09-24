package rahulShettyAcademy.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractCompnents.AbstractComponent;

public class OrdersPage extends AbstractComponent{
	
	WebDriver driver;

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderedProducts;
	
	public boolean verifyOrderDisplay(String prodName) {
		boolean prodFound = orderedProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(prodName));
		return prodFound;
	}
}
