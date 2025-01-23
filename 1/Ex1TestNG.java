import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.annotations.*;

//ADD the required TestNG annotations on respective methods

public class Ex1TestNG 
{         
	public static WebDriver driver; 
	String name;
	String password;
	
	@BeforeSuite
	public void createDriver() 
	{ 
		//Implement code to create Driver from DriverSetup and assign it to 'static' driver variable
		driver=DriverSetup.getWebDriver();
    }
	
	@Test(groups={"init"})
	public void initializeName() 
	{        
		name="Tom";
	}
	
	@Test(groups={"init"})
	public void initializePassword()
	{       
		password="Tom";
	}
	
	@Test(dependsOnGroups={"init"})
	public void signin()
	{               
		System.out.println("signin");
	}
	
	@AfterSuite
	public void closeBrowser()
	{ 
		driver.close();
	}
	
	public static void main(String[] args)
	{          
	    Ex1TestNG page=new Ex1TestNG();
	    //Implement the required code
	   page.createDriver();
	   page.initializeName();
	   page.initializePassword();
	   page.signin();
	   page.closeBrowser();
	    
	    
	}
}