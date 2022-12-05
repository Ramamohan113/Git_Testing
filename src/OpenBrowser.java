

import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.ExtentReporter;

public class OpenBrowser {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("httpa://www.facebook.com");
		Thread.sleep(2000);
	driver.findElement(By.xpath(""));
	ExtentReporter report= new ExtentReporter() {
	};
	}

}
