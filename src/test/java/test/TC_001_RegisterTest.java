package test;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_001_RegisterTest  extends ProjectSpecificationMethod{

	
	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("RegisterTestData");
		testName="RegisterTest";
		testDescription="Test the RegisterFunctionality with postive and negtive";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	@Test
	public void registerTest() {
		HomePage obj = new HomePage(driver);
		obj.signUpClick()
		.userName(prop.getProperty("validUserName"))
		.password(prop.getProperty("ValidPassword"))
		.signInButton()
		.validateAlertmessage();
		
		
	}
	

}
