package testRunner;

import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utilities.DriverManager;
import utilities.GlobalParams;
import utilities.AppiumServer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(		
		features = {"src/test/resources/featureFiles"}, 
		glue = {"stepDefinitions"},
		//cucumber report is generated under target/cucumber-html-reports as sparkReport.html
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		monochrome = true,
		dryRun = false,
		tags = ("@Login or @product")) //included tags to run scenarios from both the feature files

@Test
public class RunCuke extends AbstractTestNGCucumberTests{
	
	@BeforeSuite 
	    public static void initialize() throws Exception {
	        GlobalParams params = new GlobalParams();
	        params.initializeGlobalParams();

	        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
	                + params.getDeviceName());

	        new AppiumServer().startServer();
	        new DriverManager().initializeDriver();
	    }

	    @AfterSuite
	    public static void quit(){
	        DriverManager driverManager = new DriverManager();
	        if(driverManager.getDriver() != null){
	            driverManager.getDriver().quit();
	            driverManager.setDriver(null);
	        }
	        AppiumServer server = new AppiumServer();
	        if(server.getServer() != null){
	        	server.getServer().stop();
	        }
	    }

}
