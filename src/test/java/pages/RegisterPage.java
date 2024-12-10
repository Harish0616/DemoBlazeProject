package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;

import base.ProjectSpecificationMethod;

public class RegisterPage extends ProjectSpecificationMethod {
	
	

	public RegisterPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public RegisterPage userName(String uname) {
		driver.findElement(By.id("sign-username")).sendKeys(uname);
		return this;
	}
	
	public RegisterPage password(String pass) {
		driver.findElement(By.id("sign-password")).sendKeys(pass);
		return this;
	}
	
	public RegisterResult signInButton() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		return new RegisterResult(driver);
	}
	
	
	
	
	

}
