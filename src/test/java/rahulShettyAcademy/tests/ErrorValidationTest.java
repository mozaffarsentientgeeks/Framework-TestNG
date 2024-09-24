package rahulShettyAcademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulShettyAcademy.pom.CartPage;
import rahulShettyAcademy.pom.ProductCatalogue;
import rahulShettyAcademy.testComponents.BaseTest;
import rahulShettyAcademy.testComponents.RetryMechanism;

public class ErrorValidationTest extends BaseTest{
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryMechanism.class)
    public void loginErrorValidation() throws IOException, InterruptedException {
		landingPage.loginToApp("anshika@gmail.com", "king@000");
		String errorMsg = landingPage.getErrorMessage();
		Assert.assertEquals(errorMsg, "Incorrect email or password.");
	}
	
	@Test(groups = {"ErrorHandling"})
    public void productErrorValidation() throws IOException {
    	
		String productName = "ZARA COAT 3";
		ProductCatalogue prodCatalogue = landingPage.loginToApp("anshika@gmail.com", "Iamking@000");

		prodCatalogue.addProductToCart(productName);
		CartPage cartPg = prodCatalogue.goToCartPage();
		
		boolean prodFound = cartPg.verifyProductDisplay(productName);
		Assert.assertTrue(prodFound);
	}
}
