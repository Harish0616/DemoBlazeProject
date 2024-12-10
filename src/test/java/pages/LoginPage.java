package pages;

import java.awt.datatransfer.SystemFlavorMap;
import java.time.Duration;

import org.apache.logging.log4j.message.Message;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {
	///continue with product functionality
		@FindBy(id="name")
		WebElement fname;
		
		@FindBy(id="country")
		WebElement fcountry;
		
		@FindBy(id="city")
		WebElement fcity ;
		
		@FindBy(id="card")
		WebElement fcreaditcard ;
		
		@FindBy(id="month")
		WebElement fmonth ;
		
		@FindBy(id="year")
		WebElement fyear ;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage userName(String uname) {
		driver.findElement(By.id("loginusername")).sendKeys(uname);
		return this;
	}
	
	public LoginPage password(String upass) {
		driver.findElement(By.id("loginpassword")).sendKeys(upass);
		return this;
	}
	
	public HomePage clickSignInButton() {
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		return new HomePage(driver);
	}
	
	public LoginPage clickTheCategoryL() {
		driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		return this;
		
	}

    public LoginPage validateTitle() {
        String expectedTitle = "PRODUCT STORE"; // Update this with the actual expected title
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set a wait time of 20 seconds

        // Wait for the title to match or contain part of the expected title
        wait.until(ExpectedConditions.titleContains("STORE")); // Adjusted condition

        // Get actual title
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Expected Title is matched: " + actualTitle);
        } else {
            System.out.println("Expected Title is NOT matched. Expected: " + expectedTitle + ", but got: " + actualTitle);
        }

        return this;
    }

    // Select the Laptop Product
    public LoginPage clickTheProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set a wait time of 20 seconds
        WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sony vaio i5")));
        
        productLink.click();
        return this;
    }
    
    // view ths Selected Product
    public LoginPage getProductPrice() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set a wait time of 30 seconds
        
        // Update selector based on actual HTML structure
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price-container"))); // Assuming it's a class
        String priceText = priceElement.getText();

        // Optionally retrieve more information about the product
        WebElement moreInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("more-information")));
        String moreInfoText = moreInfoElement.getText();

        System.out.println("Price: " + priceText);
        System.out.println("More Information: " + moreInfoText);
    	return this;
    }
    
   
    
    //select the Add to cart button
    public LoginPage getAddToCart() throws InterruptedException {
    	  // Set up WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout

       // Wait until the "Add to Cart" button is clickable
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]")));
        for(int i=0; i<3;i++) {
        	addToCartButton.click();
        	Thread.sleep(5000);
        	 handleAlert();
        	 System.out.println("Clck ADD-TO-CART Multiple items");
        }
       // Click the "Add to Cart" button
          System.out.println("button clicking");
         return this;
     }
    //click the cart Header Button
    //select the cart button
    		public LoginPage getCartClick() {
    			driver.findElement(By.xpath("//a[text()='Cart']")).click();
    			return this;
    		}
    
    //click the delete button
     public LoginPage deleteItemFromCart() throws InterruptedException{
    	 for(int i=0; i<3;i++) {
    	 try {
    		// Set up WebDriverWait
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // 20 seconds timeout
    	        
    	        WebElement deleteButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Delete')]")));
    	        
    	        deleteButton.click();
    	        totalValue();
    	        Thread.sleep(2000);
    	        
    	        
    	} catch (Exception e) {
			// TODO: handle exception
    		System.out.println("Product are not deleted");
		}
		
    	 }
		return this;
       
    }

  
     public LoginPage totalValue() {
    	String value=driver.findElement(By.id("totalp")).getText();
    	System.out.println("get total value"+value);
		return this;
   
    }
     
     public LoginPage clickHomePage() {
    	 driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
    	return this;
    	 
     }
     
     //click the purchase button
     public LoginPage getClickPurchasePage() {
    	 try {
     		// Set up WebDriverWait
     	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 20 seconds timeout
     	        
     	        WebElement puchaseButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Place Order')]")));
     	        
     	        puchaseButton.click();
     	        System.out.println("Purchase pop up navigating");
     	       
     	      } catch (Exception e) {
 			// TODO: handle exception
     		System.out.println("purchase Button Not Clicked");
 		}
    	 return this;
     }
     
     //fill the details name
    public LoginPage FillDetailName(String fname) {
    	driver.findElement(By.id("name")).sendKeys(fname);
		return this;
    }
    //fill the details country
    public LoginPage FillDetailCountry(String fcountry) {
    	driver.findElement(By.id("country")).sendKeys(fcountry);
		return this;
    }
  //fill the details city
    public LoginPage FillDetailcity(String fcity) {
    	driver.findElement(By.id("city")).sendKeys(fcity);
		return this;
    }
  //fill the details card
    public LoginPage FillDetailCard(String fcreaditcard) {
    	driver.findElement(By.id("card")).sendKeys(fcreaditcard);
		return this;
    }
    
  //fill the details card
    public LoginPage FillDetailMonth(String fmonth) {
    	driver.findElement(By.id("month")).sendKeys(fmonth);
		return this;
    }
    
  //fill the details card
    public LoginPage FillDetailYear(String fyear) {
    	driver.findElement(By.id("year")).sendKeys(fyear);
		return this;
    }
    
     //click the purchase order
     public LoginPage clickPurchaseButton() {
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // 20 seconds timeout
	        
	     WebElement purchaseButton =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Purchase')]")));
    	 
	     purchaseButton.click();
	     System.out.println("purchase Button Clicked");
		return this;
    	 
     }
     
     //Get Success Message 
     public LoginPage getSuccessPage() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         WebElement  successGet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Thank you for your purchase!']")));
         
         successGet.getText();
         System.out.println("The Purchase message Successfull"+successGet);

		return this;
     }
     
     public LoginPage clickSuccessOkButton() {
    	// Click on 'OK' button after purchase confirmation
    	 try {
    		 WebElement okButton = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
             
              Thread.sleep(3000);
             okButton.click();
             driver.switchTo().alert().accept();

             // Refresh the page to go back to home page
             driver.navigate().refresh();

             // Optionally, you can navigate back to home if needed
             driver.get("https://www.demoblaze.com/index.html");

            
    		 
    	 }
    	 catch(Exception e){
    		 
    		 System.out.println("The ANY FAILURE"+e.getMessage());
    	 }
        
		return this;
    	 
     }
     public LoginPage isLogOutButtonVisible() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         try {
             WebElement logOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
             logOutButton.isDisplayed(); // Check if the logout button is displayed
         } catch (Exception e) {
             System.out.println("Logout button not visible.");
              // If there's an exception, return false
         }
		return this;
     }

     // Method to click on Logout button
     public LoginPage logOutLink() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // 50 seconds timeout
         
         try {
             // Wait until the logout button is clickable
             WebElement logOutClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
             logOutClick.click();
             System.out.println("Successfully logged out");
         } catch (Exception e) {
             System.out.println("Failed to click logout: " + e.getMessage());
         }
         
         return this;
     }

     
     
     
     
     
     
     
//     public LoginPage navigateToHome() {
//    	 
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // 20 seconds timeout
//	        
//	     WebElement clickHomePage =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Home')]")));
//	     clickHomePage.click();
//		return this;
//     }
//     
//     //click the LogoutButton
//     public LoginPage logOutLink() {
//    	 
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // 20 seconds timeout
//	        
//	     WebElement logOutClick =wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
//	     isLogOutButtonVisible();
//	     logOutClick.click();
//	     
//	     System.out.println("Successfully Logout");
//		return this;
//    	 
//     }
//     //logoutbuttonvisible
//     private void isLogOutButtonVisible() {
//         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30) );
//         try {
//             WebElement logOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
//             logOutButton.isDisplayed(); // Check if the logout button is displayed
//         } catch (Exception e) {
//              System.out.println("Not Displayed");// If there's an exception, return false
//         }
//     }
//     
    

     private void handleAlert() {
		// TODO Auto-generated method stub
		try {
            Alert alert = driver.switchTo().alert(); // Switch to alert
            System.out.println("Alert text: " + alert.getText()); // Print alert text
            alert.accept(); // Accept the alert
        } catch (Exception e) {
            System.out.println("No alert present.");
        }
	}
	
}
