package utilities;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SetCapabilities {
	TestUtils logger = new TestUtils();

	public UiAutomator2Options getOptions() throws IOException {
		GlobalParams params = new GlobalParams();
		Properties props = new ReadProperties().getProps();

		try {
			logger.log().info("----------Set UiAutomator2 options----------");
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName(params.getPlatformName());
//			options.setUdid(params.getUDID());
			options.setDeviceName(params.getDeviceName());

			switch (params.getPlatformName()) {
			case "Android":
				options.setAutomationName(props.getProperty("androidAutomationName"));
				options.setAppPackage(props.getProperty("androidAppPackage"));
				options.setAppActivity(props.getProperty("androidAppActivity"));
				options.setSystemPort(Integer.parseInt(params.getSystemPort()));
				options.setChromedriverPort(Integer.parseInt(params.getChromeDriverPort()));
				String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
						+ File.separator + "resources" + File.separator + "apps" + File.separator
						+ "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
				logger.log().info("----appUrl is---" + androidAppUrl);
				options.setApp(androidAppUrl);
				break;

			}
			return options;
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log().fatal("------Failed to load capabilities--------" + e.toString());
			throw e;
		}
	}
}
