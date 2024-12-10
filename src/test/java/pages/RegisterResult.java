package pages;

import static org.testng.Assert.assertEquals;

import java.security.PublicKey;
import java.sql.Driver;
import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Utility;

import base.ProjectSpecificationMethod;

public class RegisterResult extends ProjectSpecificationMethod {

	public RegisterResult (WebDriver driver) {
		this.driver=driver;
	}
	
	public RegisterResult validateAlertmessage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 try {
		        // Wait until the button is clickable
		        WebElement alertButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign up successful.')]")));
		        
		        // Click the button if it exists
		        alertButton.click();
		    } catch (Exception e) {
		        System.out.println("Button not found or not clickable: " + e.getMessage());
		    }
		    	    
		    return this;
		}
		
	}
	
	

