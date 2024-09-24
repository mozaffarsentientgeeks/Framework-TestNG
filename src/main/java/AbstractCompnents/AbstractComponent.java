package AbstractCompnents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyAcademy.pom.CartPage;
import rahulShettyAcademy.pom.OrdersPage;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeaderBtn;
	
	@FindBy(css = "[routerlink*='orders']")
	WebElement ordersHeaderBtn;
	
	public CartPage goToCartPage() {
		moveToElement(cartHeaderBtn);
		cartHeaderBtn.click();
		CartPage cartPg = new CartPage(driver);
		return cartPg;
	}
	
	public OrdersPage goToOrdersPage() {
		moveToElement(ordersHeaderBtn);
		ordersHeaderBtn.click();
		OrdersPage ordersPg = new OrdersPage(driver);
		return ordersPg;
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToDisppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void moveToElement(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
}
