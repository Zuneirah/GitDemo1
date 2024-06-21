import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abdul Samir Shaikh\\eclipse-workspace\\SeleniumTestProject1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String url = driver.findElement(By.cssSelector("a[href*='soap']")).getAttribute("href");
		System.out.println(url);
		
		driver.quit();
	}

}
