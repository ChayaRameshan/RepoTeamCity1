package firstTestNGPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchWindowExample {
	public static WebDriver driver;
	 
		
		 
		@Test
		public void printChildWindowTitles() {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	        driver = new ChromeDriver();
			 
			// Maximize browser
			driver.manage().window().maximize();
			
			// Load app
			driver.get("http://www.naukri.com/");
			
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		 
		// This will return the number of windows opened by Webdriver and will return Set of St//rings
		Set<String>s1=driver.getWindowHandles();
		 
		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		 
		while(I1.hasNext())
		{
		 
		   String child_window=I1.next();
		 
		// Here we will compare if parent window is not equal to child window then we            will close
		 
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		 
		System.out.println("child window title is "+ driver.switchTo().window(child_window).getTitle());
		 
		driver.close();
		}
		 
		}
		// once all pop up closed now switch to parent window
		driver.switchTo().window(parent);
		
		System.out.println("Back to parent window after closing child windows");
		//Line added via git
		}
}
