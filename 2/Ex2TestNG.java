import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

@Listeners(FeatureTest.class)         //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Ex2TestNG {             //DO NOT Change the class Name
	
	
	public static WebDriver driver;
	String name;
	String password;
	
    @BeforeSuite
    public void createDriver() {                  //DO NOT change the method signature
		//Create driver and assign it to 'static' driver variable
		driver=DriverSetup.getWebDriver();
	}
	@BeforeTest
	public void resetName() {                   //DO NOT change the method signature
		//NO implementation required. ONLY proper annotation is required.
	}	
	@Test(dependsOnGroups={"init"})
	public void signin() {                       //DO NOT change the method signature
		System.out.println("signin");
	}
	
	@Test(priority=2 , groups={"init"})
    public void initializeName() {                //DO NOT change the method signature
		name="Tom";
	}
	@Test(priority=1 , groups={"init"})
	public void initializePassword() {           //DO NOT change the method signature
		password="Tom";
	}
	
	@AfterSuite
	public void closeBrowser() {                //DO NOT change the method signature
		//close the driver
		driver.close();
	}
	@Test
	public void invokeTest() {                 //DO NOT change the method signature
		//Implement code to invoke test using TestNG
		TestNG t=new TestNG();
		t.setTestClasses(new Class[] {Ex2TestNG.class});
		t.run();
	}

	public static void main(String[] args) {
	    Ex2TestNG ex2=new Ex2TestNG();
	    ex2.createDriver();
	    ex2.resetName();
	    ex2.signin();
	    ex2.initializeName();
	    ex2.initializePassword();
	    ex2.closeBrowser();
	    ex2.invokeTest();
	    //Implement any required code.
	}

  

}
