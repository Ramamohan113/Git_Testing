

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMmodel {

WebDriver driver;
@FindBy(xpath="(//td[@class='mouseOut'])[2]")
WebElement regislink;

@FindBy(name="firstName")
WebElement Firstname;

@FindBy(name="lastName")
WebElement Lastname;

@FindBy(name="phone")
WebElement Phone;

@FindBy(id="userName")
WebElement email;

@FindBy(name="address1")
WebElement address;

@FindBy(name="state")
WebElement State;

@FindBy(name="postalCode")
WebElement pin;

@FindBy(name="country")
WebElement Conutry;

@FindBy(id="email")
WebElement Usermail;

@FindBy(name="password")
WebElement Pass;

@FindBy(name="confirmPassword")
WebElement ConPass;

@FindBy(name="submit")
WebElement sub;


public POMmodel(WebDriver d)
{
	driver=d;
	PageFactory.initElements(driver, this);
}

public void Click() {
	regislink.click();
}
public void setValues(String fname,String lname,String pho,String eml,String add,String st,String pincode)
{
	 Firstname.sendKeys("fname");
	 Lastname.sendKeys("lname");
	 Phone.sendKeys("pho");
	 email.sendKeys("eml");
	 address.sendKeys("add");
	 State.sendKeys("st");
	 pin.sendKeys("pincode");
	 
	 
}

public void Country() {
	Select s=new Select(Conutry);
	s.selectByVisibleText("INDIA");
}
public void setVules2(String useml,
		String p,String cp) {
	 Usermail.sendKeys("useml");
	 Pass.sendKeys("p");
	 ConPass.sendKeys("cp");
	 
}
public void submit()
{
	 sub.click();
	
}


}
