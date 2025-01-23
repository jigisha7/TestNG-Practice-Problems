import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.*;
public class Main 
{ 
	public static WebDriver driver;
	public static WebElement element;

	//Apply the required annotation here
	@BeforeTest
	public static WebDriver setDriver()
	{
	    driver=DriverSetup.getDriver();
	    return driver;
	    // Create the driver using 'getDriver' method. Assign it to variable 'driver'
		// Return the variable driver
	}

	// Apply the required annotation with its essential attributes for input parameters & preference of execution
	@Test(dataProvider="getData",priority=1)
	public static void setData(String nickName,String contactName,String company,String city,String country,String type) throws Exception
	{
		// Method to locate the text fields NickName, ContactName, Company, City, Country & Type by id
		// Pass on input data by picking from data provider passed thru attributes
		driver.findElement(By.id("nickname")).sendKeys(nickName);
		driver.findElement(By.id("contact")).sendKeys(contactName);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("type")).sendKeys(type);
		driver.findElement(By.id("add")).click();
	}

	// Apply the required annotation with its essential attribute for preference of execution
	@Test(priority=2)
	public static void deleteTable() throws Exception 
	{ 
		// Method to remove row in the table 
		// Select the second row & delete it
		driver.findElement(By.id("radio0")).click();
		driver.findElement(By.id("delete")).click();
		
	}

	// Apply the required annotation with its essential attribute for preference of execution
	@Test(priority=3)
	public static void tableCheck() throws Exception
	{  
		// Method to check, if the table is present or not after refreshing the Webpage
		// First store the first text from table in a string by using its xpath
		// Then refresh the webpage
		// Now try to locate the table with its xpath & try to store the first text in another string
		// By comparing both strings, assess if table could be found 
		// if table not found, print message 'Table Not Found'
		// Use try.. catch, to do this validation
		element=driver.findElement(By.xpath("//*[id='result']/table/tbody/tr/th[1]"));
		String str=element.getText();
		driver.navigate().refresh();
		try{
		String str1=driver.findElement(By.xpath("//*[id='result']/table/tbody/tr/th[1]")).getText();
		
		    Assert.assertEquals(str,str1,"Table Not Found");
		   }
		catch(Exception e)
		{
		    System.out.println("Table Not Found");   
		}
		
	}


	//Apply the required annotation
	@DataProvider(name="getData")
	public String[][] getData() {  
		// Method to set the input data for NickName, ContactName, Company, City, Country & Type
		// Rows - Number of times your test has to be repeated.
		// Columns - Number of parameters in test data.
		
		// Use these 2 sets of data
		String[][] data = new String[2][6];

		// 1st row
		data[0][0] = "Dera";
		data[0][1] = "John";
		data[0][2] = "Cognizant";
		data[0][3] = "Chennai";
		data[0][4] = "India";
		data[0][5] = "Business";

		// 2nd row
		data[1][0] = "Charles";
		data[1][1] = "Kevin";
		data[1][2] = "Thompsons";
		data[1][3] = "Bangalore";
		data[1][4] = "India";
		data[1][5] = "Marketing";

		return data;
	}

	//Apply the required annotation
	@AfterTest
	public static void closeBrowser()
	{ 
		// Method to close the Browser
	    driver.close();	
	}
}