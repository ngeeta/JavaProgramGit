package seleniumProgram;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframeResult"));
		System.out.println("Total number of iframes are " + iframeElements.size());
	}

}
