package seleniumProgram;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class localFileOTP {
	static String username,password;
	static String otp;
	static FileReader reader; 
	static Properties p; 
	static String[] a;
	public static void readOTP() throws IOException {
		reader=new FileReader("otp.properties");
		p=new Properties();
		p.load(reader);
		otp=p.getProperty("otp");
		
		a=otp.split(""); 
		for(String m:a) { System.out.println(m); }
	
		System.out.println(otp +" is your otp");
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
WebDriver driver=new ChromeDriver();
driver.get("file:///C:/Users/geeta/Desktop/xpath.html");

List<WebElement> list=driver.findElements(By.xpath("//*[@class='otp-fields']/input"));
System.out.println(list.size());
//readOTP();
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



	}

}
