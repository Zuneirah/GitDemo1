import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScopeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abdul Samir Shaikh\\eclipse-workspace\\SeleniumTestProject1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println("---"+ driver.findElements(By.tagName("a")).size()+"---");
		
		WebElement footer= driver.findElement(By.cssSelector("div[id='gf-BIG']"));
		
		System.out.println("---"+ footer.findElements(By.tagName("a")).size() + " --- ");
		
		WebElement columndriver = footer.findElement(By.xpath(("//table/tbody/tr/td[1]/ul")));
		
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++) {
			
			String clickonLinkTab= Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
			
			
			
		}
		
		Set<String> s1= driver.getWindowHandles();
		Iterator<String> itr= s1.iterator();
		
		String parentWindow = itr.next();
		
		
		while(itr.hasNext()) {
			String childWindow = itr.next();
			if(!parentWindow.equals(childWindow)) {
				
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
			}
			
			//driver.switchTo().window(itr.next());
			//System.out.println(driver.getTitle());
			
		}
		
		
		
		
		
		
		driver.quit();
		
		
	}

}
