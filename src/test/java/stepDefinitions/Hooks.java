package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;
import utilities.DriverManager;

public class Hooks {
	
	@Before
	public void initializeDriver() throws Exception {
		
		 BasePage basePage = new BasePage();
	        basePage.closeApp();
	        basePage.launchApp();
		
	}
	
	@After
	public void quit(Scenario scenario) throws IOException {
		 if(scenario.isFailed()){
	            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName());
	        }
		
	}
	


}
