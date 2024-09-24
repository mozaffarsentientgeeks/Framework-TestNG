package rahulShettyAcademy.stepDefinations;

//import java.io.IOException;
//
//import org.testng.Assert;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import rahulShettyAcademy.pom.CartPage;
//import rahulShettyAcademy.pom.CheckoutPage;
//import rahulShettyAcademy.pom.ConfirmationPage;
//import rahulShettyAcademy.pom.LandingPage;
//import rahulShettyAcademy.pom.ProductCatalogue;
//import rahulShettyAcademy.testComponents.BaseTest;
//
//public class StepDefinationImpl extends BaseTest{
//	public LandingPage landingPage;
//	public ProductCatalogue prodCataloguePg;
//	public CartPage cartPg;
//	public CheckoutPage checkoutPg;
//	public ConfirmationPage confirmationPg;
//	
//	@Given("I landed on Ecommerce Page")
//	public void I_landed_on_Ecommerce_Page() throws IOException {
//		landingPage = launchApplication();
//	}
//	
//	@Given("^Logged in with username (.+) and password (.+)$")
//	public void logged_in_with_username_and_password(String username, String password) {
//		prodCataloguePg = landingPage.loginToApp(username, password);
//	}
//	
//	@When("^I add product (.+) to Cart$")
//	public void I_add_product_products_to_Cart(String prodName) {
//		prodCataloguePg.addProductToCart(prodName);
//	}
//	
//	@When("^Checkout (.+) and submit the order$")
//	public void Checkout_product_and_submit_the_order(String prodName) {
//		cartPg = prodCataloguePg.goToCartPage();
//		boolean prodFound = cartPg.verifyProductDisplay(prodName);
//		Assert.assertTrue(prodFound);
//		checkoutPg = cartPg.goToCheckout();
//		checkoutPg.selectCountryName("India");
//		confirmationPg = checkoutPg.clickOnCheckoutBtn();
//	}
//	
//	@Then("{string} message is displayed on confirmation page")
//	public void message_is_displayed_on_confirmation_page(String string) {
//		String confirmationMsg = confirmationPg.getConfirmationMessage();
//		Assert.assertTrue(confirmationMsg.equalsIgnoreCase(string));
//		driver.close();
//	}
//	
//}
