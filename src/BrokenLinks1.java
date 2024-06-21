import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class BrokenLinks1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abdul Samir Shaikh\\eclipse-workspace\\SeleniumTestProject1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		List<WebElement> Links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		//System.out.println(Links.get(6).getText());
		//System.out.println(Links.get(6).getAttribute("href"));
		
		for(WebElement link: Links) {
			//String url = driver.findElement(By.cssSelector("a[href*='soap']")).getAttribute("href");
			String url = link.getAttribute("href");
			//System.out.println(url);
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode < 400, "The link with Text " + link.getText() + " is broken with code "
						+ responseCode);
			
		}
		
		a.assertAll();
		
		
		driver.quit();
	}

}
