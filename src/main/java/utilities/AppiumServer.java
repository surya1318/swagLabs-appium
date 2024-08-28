package utilities;

import java.io.File;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
	
	private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    TestUtils logger = new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
    	
    	logger.log().info("------------starting appium server----------------");
//    	AppiumDriverLocalService server = getAppiumServerDefault();
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){
        	logger.log().fatal("------------Appium server not started----------------");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started");
        }
        server.clearOutPutStreams();
        AppiumServer.server.set(server);
        logger.log().info("------------Appium server started----------------");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));

    }

}
