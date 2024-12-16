package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_003_InvalidLoginTest extends ProjectSpecificationMethod {
	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("RegisterTestData");
		testName="InvalidTest";
		testDescription="Test the LoginFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
		
	}
	
	@Test
	public void InvalidTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.loginClick()
		.userName(prop.getProperty("invalidUsername"))
		.password(prop.getProperty("validPassword"))
		.clickSignInButton()
		.validateLogin();
	}

}
