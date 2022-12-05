

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataUsing {
 WebDriver driver;
 @BeforeClass
 public void setUp() {
	 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
 }
 
 @Test(dataProvider="LoginData")
 public void loginTest(String user,String pass,String exp)
 {
	 driver.get("https://demo.actitime.com/login.do");

	WebElement username = driver.findElement(By.name("username"));
	username.clear();
	username.sendKeys(user);
	 WebElement password = driver.findElement(By.name("pwd"));
	 password.clear();
	 password.sendKeys(pass);
	driver.findElement(By.xpath("//div[text()='Login ']"));
	 String exp_result = "Enter Time-Track";
	String actval_result=driver.findElement(By.xpath("//td[contains(text(),'Enter Time-Track')]")).getText();
	if(exp.equals("VALID"))
	{
		if(exp_result.equals(actval_result))
		{
			driver.findElement(By.id("logoutLink")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	else if(exp.equals("INVALID"))
	{
	if(exp_result.equals(actval_result))
	{
		driver.findElement(By.id("logoutLink")).click();

		Assert.assertTrue(false);

	}
	else
	{
		Assert.assertTrue(true);
	
	}
		
	}
		
 }
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception{
		String path="./data/actitimeDetails.xlsx";
		Utilites uti=new Utilites(path);
		int totalrows = uti.getRows("Sheet1");
		int totalcells=uti.getCell("Sheet1", 1);
		String loginData[][]=new String[totalrows][totalcells];
		for(int i=1;i<totalrows;i++)
		{
			for(int j=0;j<totalcells;j++)
			{
				loginData[i-1][j]=uti.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
