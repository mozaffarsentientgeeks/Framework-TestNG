package rahulShettyAcademy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulShettyAcademy.pom.CartPage;
import rahulShettyAcademy.pom.CheckoutPage;
import rahulShettyAcademy.pom.ConfirmationPage;
import rahulShettyAcademy.pom.OrdersPage;
import rahulShettyAcademy.pom.ProductCatalogue;
import rahulShettyAcademy.testComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{
	String prodName = "ZARA COAT 3";
	
	@Test(dataProvider = "getData", groups = "Purchase")
    public void submitOrder(HashMap<String, String> input) throws IOException {
    	
		ProductCatalogue prodCatalogue = landingPage.loginToApp(input.get("email"), input.get("password"));

		prodCatalogue.addProductToCart(input.get("product"));
		CartPage cartPg = prodCatalogue.goToCartPage();
		
		boolean prodFound = cartPg.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(prodFound);
		CheckoutPage checkoutPg = cartPg.goToCheckout();
		
		checkoutPg.selectCountryName("india");
		ConfirmationPage successPg = checkoutPg.clickOnCheckoutBtn();
		
		String actualMsg = successPg.getConfirmationMessage();
		Assert.assertTrue(actualMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatalogue prodCatalogue = landingPage.loginToApp("anshika@gmail.com", "Iamking@000");
		OrdersPage ordersPg = prodCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPg.verifyOrderDisplay(prodName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\rahulShettyAcademy\\data\\purchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "xemis75528@cetnob.com");
//		map.put("password", "Test@123");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "niciko8638@heweek.com");
//		map1.put("password", "Test@123");
//		map1.put("product", "ADIDAS ORIGINAL");
//		
//		return new Object[][] {{map},{map1}};
//	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"xemis75528@cetnob.com", "Test@123", "ZARA COAT 3"},{"niciko8638@heweek.com", "Test@123", "ADIDAS ORIGINAL"}};
//	}
}
