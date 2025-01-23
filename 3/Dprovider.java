import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;
public class Dprovider
{ 
    public static WebDriver driver;
	public static WebElement firstName,lastName,userName,userCity;
	public static String fNametext,lNametext,uNametext,cityText;
	public static Select select;
	
	//Add required Annotation
	@BeforeMethod
	public void setDriver()
	{ 
		// Create the driver using 'getWebDriver' method. Assign it to variable 'driver'
        driver=DriverSetup.getWebDriver();
	}
	
	//Add required Annotation
	@DataProvider(name="data-provider")
	public Object[][] dpMethod()
	{ // Do not change the method signature
	    return new Object[][] {{"charles","ganesh","ismail","Chennai","Male","religion"}};
    }

    //Add required Annotation
    @Test(dataProvider="data-provider")
    public void testRegisterForm(String fName, String lName, String uName, String city, String gender,String password)
    { 
	    
	    // Find the form elements using Locators and set the passed parameter values.
		// Submit the form.
		firstName=driver.findElement(By.id("firstname"));
		firstName.sendKeys(fName);
		
		lastName=driver.findElement(By.id("lastname"));
		lastName.sendKeys(lName);
		
		userName=driver.findElement(By.id("username"));
		userName.sendKeys(uName);
		
		userCity=driver.findElement(By.id("selectcity"));
		select=new Select(userCity);
		select.selectByVisibleText(city);
		
		if(gender.equalsIgnoreCase("male"))
		    driver.findElement(By.xpath("//input[@name='gender' and @value='male']")).click();
		else if(gender.equalsIgnoreCase("female"))
		        driver.findElement(By.xpath("//input[@name='gender' and @value='female']")).click();
		        else
		        driver.findElement(By.xpath("//input[@name='gender' and @value='other']")).click();
	
		driver.findElement(By.id("pass")).sendKeys(password);
		
		//driver.findElement(By.xpath("//html/body/form/div[6]/input[1]")).click();
		driver.findElement(By.id("reg")).click();
	    //Get the table WebElement corresponding to FirstName, the row value inserted after form submission 
    	//Extract firstname text which displayed in table and assert it. Store the firstname text in a static variable 'fNametext'
	    //If extracted text didntmatch with dpMethod data then script throws an exception
	    fNametext=driver.findElement(By.xpath("//table[@id='ttab']/tbody/tr[3]/td[1]")).getText();
	    lNametext=driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td[2]")).getText();
	    uNametext=driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td[3]")).getText();
	    cityText=driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td[4]")).getText();
	    try {
	        assertEquals(fName,fNametext);
	    }
	    catch(AssertionError e)
	    {
	        System.out.println("FirstName doesnt match");
	    }
	    try{
	       assertEquals(lName,lNametext);
	    }
	    catch(AssertionError e)
	    {
	        System.out.println("LastName doesnt match");
	    }
	    try{
	        assertEquals(uName,uNametext);
	    }
	    catch(AssertionError e)
	    {
	        System.out.println("UserName doesnt match");
	    }
	    try{
	        assertEquals(city,cityText);
	        
	    }catch(AssertionError e) {
	        System.out.println("city doesnt match");
	    } 
	   
	    //Get the table WebElement corresponding to LastName, the row value inserted after form submission
	    //Extract lastname text which displayed in table and assert it. Store the lastname text in a static variable 'lNametext'
		//If extracted text didntmatch with dpMethod data then script throws an exception
	
	    //Get the table WebElement corresponding to UserName, the row value inserted after form submission
	    //Extract username text which displayed in table and assert it. Store the username text in a static variable 'uNametext'
		//If extracted text didntmatch with dpMethod data then script throws an exception

        //Get the table WebElement corresponding to City, the row value inserted after form submission
	    //Extract city text which displayed in table and assert it. Store the city text in a static variable 'cityText'
		//If extracted text didntmatch with dpMethod data then script throws an exception
		

    }

    //Apply the required annotation
    @AfterMethod
    public void closeBrowser()
    {
	    //close the driver
	    driver.close();
    }
}