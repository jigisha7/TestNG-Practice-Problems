import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import junit.framework.Assert;
public class Portcharges
{
	public static WebDriver driver;
	public static String[][] shipmentData = null;
	public static WebElement element;
	public static String railCharge, roadCharge, airCharge;

	// Apply the required annotation
	@BeforeMethod
	public WebDriver createDriver()
	{ 	
		// Create the driver using 'getWebDriver' method. Assign it to variable 'driver'
		// Return the variable driver
		driver=DriverSetup.getWebDriver();
		return driver;
	}

	// Apply the required annotation
	@DataProvider(name="portDetails")
	public Object[][] shipmentdata() 
	{  
		// Initialize 2 data set for orgPort, desPort, railMode, roadMode and airMode Charges
		shipmentData = new String[][] { { "Cochin", "Farah", "16000.0", "18000.0", "19000.0" },
				{ "Mumbai", "New York", "10000.0", "18000.0", "20000.0" } };
	// Return the data array
		return shipmentData;
	}

	// Apply the required annotation
	@Test(dataProvider="portDetails")
	public void testShipment(String orgPort, String desPort, String railMode, String roadMode, String airMode)
	{
        element=driver.findElement(By.name("origin_id"));
        Select obj1=new Select(element);
        obj1.selectByVisibleText(orgPort);
        
        element=driver.findElement(By.name("destination_id"));
        Select obj2=new Select(element);
        obj2.selectByVisibleText(desPort);
        
        driver.findElement(By.name("submit")).click();
       // driver.findElement(By.xpath("//html/body/form/table/tbody/tr[3]/td/input")).click();
		// Find the form elements using Locators and set the passed parameter values.
		// Submit the form.

		// select an origin port from the drop down

		// select a destination port from the drop down
		
		// Click on Get Charge button
	

		// Find the table element to get the railCharge.
		// Store the rail charge retrieved in a global static variable 'railCharge'
		// Assert the Rail Charge for the shipment with String railMode
		try
		{
            element=driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[2]"));
            railCharge=element.getText();
            Assert.assertEquals(railCharge,railMode,"Rail Charge doesnt match");
            
            element=driver.findElement(By.xpath("//html/body/table/tbody/tr[3]/td[2]"));
            roadCharge=element.getText();
            Assert.assertEquals(roadCharge,roadMode,"Road Charge doesnt match");
            
            element=driver.findElement(By.xpath("//html/body/table/tbody/tr[4]/td[2]"));
            airCharge=element.getText();
            Assert.assertEquals(airCharge,airMode,"Air Charge doesnt match");
            
            System.out.println("******"+railCharge+"\t*********"+roadCharge+"\t**********"+airCharge);
    	}
		catch(Exception e){ }
		// Find the table element to get the roadCharge.
		// Store the road charge retrieved in a global static variable 'roadCharge'
		// Assert the Road Charge for the shipment with String roadMode
		
		// Find the table element to get the airCharge.
		// Store the air charge retrieved in a global static variable 'airCharge'
		// Assert the Air Charge for the shipment with String airMode
	}

	// Apply the required annotation
	@AfterMethod
	public void closeBrowser()
	{ 
		// close the driver
		driver.close();
	}
}