package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		
    	String expectedUserId = "Welcome Harish2116";
        WebElement userId ;

        try {
            userId = driver.findElement(By.xpath("//a[@id='nameofuser']"));
            visibilityofElement(userId);
            String actualId = userId.getText();
            
            if (expectedUserId.equals(actualId)) {
                System.out.println("Login Successful !!");
            } else {
                System.out.println("Login failed");
                handleAlert();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Reference Exception caught. Retrying...");
            return validateLogin(); // Retry validating login
        }
        
        return this;
    }
    
   
	 
    //click the product
   
       
      //alert Handled
       private void handleAlert() {
           try {
               Alert alert = driver.switchTo().alert(); // Switch to alert
               System.out.println("Alert text: " + alert.getText()); // Print alert text
               alert.accept(); // Accept the alert
           } catch (Exception e) {
               System.out.println("No alert present.");
           }
       }

	public LoginPage clickTheCategoryL() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		return new LoginPage(driver);
	}

	
       
}
