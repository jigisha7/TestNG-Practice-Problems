import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import junit.framework.Assert;

@Listeners(FeatureTest.class)       //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Shipment               //DO NOT Change the class Name
{
	public static WebDriver driver;
		//Add before suite annotation
	@BeforeSuite
	public void createDriver()
	{
		DriverSetup.getWebDriver();
    }
	
	//Add data provider annotation with name 'shipmentData'
	@DataProvider(name="shipmentData")
	public Object[][] shipmentData()           //DO NOT change the method signature
	{
	    //Do not change the values
	    return new Object[][] { { "Mumbai", "New York","18000","10000","20000" }};
	}

	//DO NOT change the method signature. Add data provider annotation with name 'shipmentData'
	@Test(dataProvider="shipmentData")
	void testShipment (String orginPort,String destinationPort,String railModeCharge,String roadModeCharge,String airModeCharge) throws InterruptedException
	{
		//Apply the array values to the respective form element
		// Test the tabled data against the data specified in the array
		WebElement ele1=driver.findElement(By.xpath("//html/body/form/table/tbody/tr[1]/td[2]/select/option[1]"));
		ele1.click();
		driver.findElement(By.xpath("//html/body/form/table/tbody/tr[2]/td[2]/select/option[2]")).click();
		driver.findElement(By.name("submit")).click();
		
		String rd=driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td[2]")).getText();
		String rail=driver.findElement(By.xpath("//html/body/table/tbody/tr[3]/td[2]")).getText();
		String air=driver.findElement(By.xpath("//html/body/table/tbody/tr[4]/td[2]")).getText();
	
		Assert.assertEquals(railModeCharge,rail,"The Rail mode Charge doesnt match");
	    Assert.assertEquals(roadModeCharge,rd,"The Road mode Charge doesnt match");
    	Assert.assertEquals(airModeCharge,air,"The Air mode Charge doesnt match");
	}
	
	public  void shipment() {
	    //Invoke TestNG only here
	    TestNG t=new TestNG();
	    t.setTestClasses(new  Class[] {Shipment.class});
	    t.run();
	}
	
	public static void main(String[] args) {
		Shipment ship=new Shipment();
		ship.shipment();
	    //Implement any required code. 
	    ship.createDriver();
	    ship.shipmentData();
	   // ship.testShipment();
	    ship.shipment();
	}
}