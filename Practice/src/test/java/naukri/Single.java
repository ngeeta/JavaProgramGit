package naukri;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Single {
	static String username,password;
	static String otp;
	static FileReader reader; 
	static Properties p;
	static String[] a;
	public static void readOTP() throws IOException, InterruptedException {
		reader=new FileReader("otp.properties");
		p=new Properties();
		Thread.sleep(200000);
		p.load(reader);
		otp=p.getProperty("otp");
		
		  a=otp.split(""); for(String m:a) { System.out.println(m); }
		 
		System.out.println(otp +" is your otp");
	}
	public static void readCredentials() throws IOException {
		reader=new FileReader("db.properties");
		p=new Properties();
	    p.load(reader); 
	     username=p.getProperty("user");
	     password=p.getProperty("password");

	    System.out.println(username);  
	    System.out.println(password);  
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		readCredentials();
		
WebDriver driver=new ChromeDriver();

driver.manage().window().maximize();
driver.get("https://www.naukri.com/");

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
By loginOption =By.id("login_Layer");
driver.findElement(loginOption).click();

WebElement userId=driver.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username' and @type='text']"));
WebElement password=driver.findElement(By.xpath("//*[@type='password']"));

userId.sendKeys(username);
password.sendKeys(Single.password);

WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
loginButton.click();


List<WebElement> list=driver.findElements(By.xpath("//*[@class='otp-fields']/input"));
System.out.println(list.size());
Scanner myObj = new Scanner(System.in);  // Create a Scanner object
System.out.println("Enter OTP");

String userName = myObj.nextLine();  // Read user input
Thread.sleep(10000);
String o[]=userName.split("");
System.out.println("Username is: " + userName);
for(int i=0;i<list.size();i++) {
	list.get(i).click();
	list.get(i).sendKeys(o[i]);
}

By verify=By.className("btn-large verify-button ");
//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
//wait.until(ExpectedConditions.visibilityOfElementLocated(verify));
driver.findElement(verify).click();
	}

}
