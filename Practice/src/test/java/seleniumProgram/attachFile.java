package seleniumProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class attachFile {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
	    WebElement fileInput = driver.findElement(By.id("fileInput"));
	    fileInput.sendKeys("C:/Users/geeta/Desktop/Resume_Geeta_Borkar_Sr_QA_Profile.pdf");


	}

}
