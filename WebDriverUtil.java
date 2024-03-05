package commonUtils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
         
	public WebDriver driver;
	
	
	
	
	public void maximise(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implcitWait(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	}
	public void handledropdown(WebElement element,String targetedelement) {
		Select s=new Select(element);
		s.selectByVisibleText(targetedelement);
	}
	public void mouseover(WebDriver driver,WebElement element) {
		 Actions a=new Actions( driver);
         a.moveToElement(element);
         a.perform();
	}
	public void switchwindow(WebDriver driver,String expectedurl) {
		Set<String> ids=driver.getWindowHandles();
		for(String e:ids) {
			String actualurl = driver.switchTo().window(e).getCurrentUrl();
			if ( actualurl.contains( expectedurl)) {
				break;
				
			}
		}
	}
	
	
	
	
	
	
	
	
}
