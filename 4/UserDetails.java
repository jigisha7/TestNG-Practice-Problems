import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class UserDetails
{ 
	public WebDriver driver;
	public WebElement element;

	//Constructors are already given. If required, you can add more code into it but do NOT remove the existing code.
	public UserDetails(){}

	public UserDetails(WebDriver driver)
	{
		this.driver= driver;
	}

	public void setName(String name) 
	{
	    //locate and fill the input box of the 'Name' with 'name'
	    driver.findElement(By.id("name")).sendKeys(name);
	}
	
	public void setAddress(String address) 
	{
		//locate and fill the input box of the 'Address' with 'address'
		driver.findElement(By.id("address")).sendKeys(address);
	}
	
	public void setMobile(String mobile)
	{
		//locate and fill the input box of the 'Mobile Number' with 'mobile'
		driver.findElement(By.id("mobile")).sendKeys(mobile);
	}
	
	public void setEmail(String email)
	{
		//locate and fill the input box of the 'Email' with 'email'
		driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public void submit() 
	{
		//locate and submit the button
		driver.findElement(By.id("Submit")).click();
	}

	public String getMobileWarning() 
	{
		//locate and retrieve the erromessage for 'MobileNumber'
		//return the text using getText()
		element= driver.findElement(By.xpath("//div[@id='mobileWarning']"));
		System.out.println("++++++++++++++++++++"+element.getText());
		return (element.getText());
    
        }
	
	public String getEmailWarning() 
	{
		//locate and retrieve the erromessage for 'email'
		//return the text using getText()
		element= driver.findElement(By.xpath("//div[@id='emailWarning']"));
		System.out.println("++++++++++++"+element.getText());
		return (element.getText());
	}
}