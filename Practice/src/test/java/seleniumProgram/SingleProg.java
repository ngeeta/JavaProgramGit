package seleniumProgram;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleProg {
	
	static WebDriver driver;
	static String username, password;
	static String otp;
	static FileReader reader;
	static Properties p;
	static String[] a;
	private static WebDriverWait wait;
	
	public static void readCredentials() throws IOException {
		reader = new FileReader("db.properties");
		p = new Properties();
		p.load(reader);
		username = p.getProperty("user");
		password = p.getProperty("password");

		System.out.println(username);
		System.out.println(password);
	}
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		readCredentials();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		By loginOption = By.id("login_Layer");
		driver.findElement(loginOption).click();

		WebElement userIdEle = driver
				.findElement(By.xpath("//*[@placeholder='Enter your active Email ID / Username' and @type='text']"));
		WebElement passwordEle = driver.findElement(By.xpath("//*[@type='password']"));

		userIdEle.sendKeys(username);
		passwordEle.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 By otpPage = By.xpath("//*[@class='otp-fields']/input");
		 List<WebElement> list = driver.findElements(otpPage);
		if (list.size() != 0) {
			System.out.println(list.size());
			Scanner myObj = new Scanner(System.in); // Create a Scanner object
			System.out.println("Enter OTP");

			String otp = myObj.nextLine(); // Read user input
			Thread.sleep(10000);
			String o[] = otp.split("");
			System.out.println("Username is: " + otp);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).click();
				list.get(i).sendKeys(o[i]);
			}
			By verify = By.xpath("//*[starts-with(@class,'btn-large')]");
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(verify)));
			driver.findElement(verify).click();

		}
		WebElement viewProfile = driver.findElement(By.xpath("(//*[@href='/mnjuser/profile'])[1]"));
		viewProfile.click();
		Boolean modalDis = false;
		WebElement modal = null;
		try {
			modal = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.className("crossIcon chatBot chatBot-ic-cross")));

			modalDis = modal.isDisplayed();
		} catch (InvalidSelectorException e) {
			System.out.println("Modal exception occurs " + e);

		}
		if (modalDis) {
			modal.click();
			System.out.println("Modal can be seen");
		}
		System.out.println("Modal not seen");
		WebElement resumebut=driver.findElement(By.xpath("//*[starts-with(@class,'dummyUpload')]"));
		  resumebut.click();
		//mention your file full path
		  String filename="C:\\Users\\geeta\\Resume_Geeta_Borkar_Sr_QA_Profile.pdf";
		  //set content in clipboard
		  StringSelection filedetails=new StringSelection(filename);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filedetails,null);
		  Robot robot=new Robot();
		  robot.delay(1000);
		  //ctrl+v
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  //enter
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
