package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;
import net.bytebuddy.asm.Advice.This;

public class HomePage extends ProjectSpecificationMethod {
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public RegisterPage signUpClick() {
		driver.findElement(By.id("signin2")).click();
		return new RegisterPage(driver);
	}
	
	public LoginPage loginClick() {
		driver.findElement(By.id("login2")).click();
		return new LoginPage(driver);
	}
	
	
		
	
	
    public HomePage validateLogin() {
		
//    	try {
//        	String expectedUserId = "Welcome Harish2116";
//            WebElement userId ;
//            userId = driver.findElement(By.xpath("//a[@id='nameofuser']"));
//            visibilityofElement(userId);
//            String actualId = userId.getText();
//            
//            if (expectedUserId.equals(actualId)) {
//                System.out.println("Login Successful !!");
//            } else {
//            	 handleAlert();
//                System.out.println("Login failed");
//               
//            }
//        } catch (StaleElementReferenceException e) {
//            System.out.println("Stale Element Reference Exception caught. Retrying...");
//            return validateLogin(); // Retry validating login
//        }
//        
//        return this;
    	try {
            // Attempt to find the user ID element
            WebElement userId = driver.findElement(By.xpath("//a[@id='nameofuser']"));
            
            // Handle any potential alerts before checking the user ID
            handleAlert(); // Call this first to handle any alerts

            // Check visibility of the user ID element
            visibilityofElement(userId);
            
            // Get actual user ID text
            String actualId = userId.getText();
            String expectedUserId = "Welcome Harish2116";

            // Validate login success
            if (expectedUserId.equals(actualId)) {
                System.out.println("Login Successful !!");
            } else {
                System.out.println("Login failed");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Reference Exception caught. Retrying...");
            return validateLogin(); // Retry validating login
        } catch (NoSuchElementException e) {
            System.out.println("User ID element not found. Login may have failed.");
        } catch (UnhandledAlertException e) {
            System.out.println("Unhandled Alert: " + e.getMessage());
            handleAlert(); // Ensure we handle any unexpected alerts
        }

        return this;
    }
    
   
	 
    //click the product
   
       
      //alert Handled
       private void handleAlert() {

//    	   try {
//    		    // Attempt login
//    		  // Check for an alert only if you expect one
//    		    Alert alert = driver.switchTo().alert();
//    		    String alertText = alert.getText();
//    		    
//    		    if ("Wrong password.".equals(alertText)) {
//    		        System.out.println("Login failed: " + alertText);
//    		        alert.accept(); // Handle the expected alert
//    		    }
//    		} catch (NoAlertPresentException e) {
//    		    System.out.println("Login successful, no alerts present.");
//    		} catch (UnhandledAlertException e) {
//    		    System.out.println("Unexpected Alert: " + e.getMessage());
//    		}
    	   try {
    	        // Switch to the alert
    	        Alert alert = driver.switchTo().alert();
    	        String alertText = alert.getText();
    	        
    	        // Check if the alert text matches the expected message
    	        if ("Wrong password.".equals(alertText)) {
    	            System.out.println("Login failed: " + alertText);
    	            alert.accept(); // Accept the alert to close it
    	        }
    	    } catch (NoAlertPresentException e) {
    	        System.out.println("No alerts present.");
    	    } catch (UnhandledAlertException e) {
    	        System.out.println("Unexpected Alert: " + e.getMessage());
    	    } catch (Exception e) {
    	        System.out.println("An error occurred while handling the alert: " + e.getMessage());
    	    }

       }

	public LoginPage clickTheCategoryL() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		return new LoginPage(driver);
	}

	
       
}
