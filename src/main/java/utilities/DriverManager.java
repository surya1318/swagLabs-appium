package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils logger = new TestUtils();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        GlobalParams params = new GlobalParams();
        ReadProperties props = new ReadProperties();

        if(driver == null){
            try{
            	logger.log().info("-----------initializing Appium driver-----------");
                switch(params.getPlatformName()){
                    case "Android":
                        driver = new AndroidDriver(new AppiumServer().getServer().getUrl(), new SetCapabilities().getOptions());
                        break;
                }
                if(driver == null){
                    throw new Exception("-----------driver is null-----------");
                }
                logger.log().info("-----------Driver is initialized-----------");
                DriverManager.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                logger.log().fatal("-----------Driver initialization failure-----------" + e.toString());
                throw e;
            }
        }

    }

}
