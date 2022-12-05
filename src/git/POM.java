package git;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM {

	@Test
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		POMmodel p = new POMmodel(driver);
		p.Click();
		p.setValues("bogini", "ramu", "9398153860", "ramamohan143@gmail.com", "mallaluva", "andhra","74598");
		p.Country();
		p.setVules2("ramamohan143n1@gmail.com", "ramu@113", "ramu@113");		
		p.submit();
driver.close();
	}
	
}
