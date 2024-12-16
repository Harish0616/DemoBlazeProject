package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_002_SignInTest extends ProjectSpecificationMethod {

	
	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("RegisterTestData");
		testName="LoginTest";
		testDescription="Test the LoginFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginClick()
		.userName(prop.getProperty("validUserName"))
		.password(prop.getProperty("ValidPassword"))
		.clickSignInButton()
		.validateLogin()
		.clickTheCategoryL()
		.validateTitle()
		.clickTheProduct()
		.getProductPrice()
		.getAddToCart()
		.getCartClick()
		.deleteItemFromCart()
		.totalValue()
		.clickHomePage()
		.clickTheProduct()
		.getAddToCart()
		.getCartClick()
		.getClickPurchasePage()
		.FillDetailName(prop.getProperty("validName"))
		.FillDetailCountry(prop.getProperty("validCountry"))
		.FillDetailcity(prop.getProperty("validCity"))
		.FillDetailCard(prop.getProperty("vaidCreditCard"))
		.FillDetailMonth(prop.getProperty("validMonth"))
		.FillDetailYear(prop.getProperty("validYear"))
		.clickPurchaseButton()
		.getSuccessPage()
		.clickSuccessOkButton()
		.isLogOutButtonVisible()
		.logOutLink();
		
		
		
	}
}
