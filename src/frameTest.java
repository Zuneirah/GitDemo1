import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abdul Samir Shaikh\\eclipse-workspace\\SeleniumTestProject1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//int iframeCount = driver.findElements(By.tagName("iframe")).size();
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
	    a.dragAndDrop(source, destination).build().perform();
	    
	    driver.switchTo().defaultContent();
	    System.out.println("Testcase Passed Successfully!");
		
		
	}

}
