package git;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TackScreenShotImage {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.guru99.com");
TakesScreenshot t=(TakesScreenshot) driver;
Thread.sleep(2000);
File src = t.getScreenshotAs(OutputType.FILE);
File des=new File("./Screenshot/ss.png");
FileUtils.copyFile(src, des);
driver.close();

}
}
