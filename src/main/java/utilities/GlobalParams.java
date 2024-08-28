package utilities;

public class GlobalParams {

	private static ThreadLocal<String> platformName = new ThreadLocal<String>();
	private static ThreadLocal<String> udid = new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
	private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
	private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();

	public void setPlatformName(String platformName1) {
		platformName.set(platformName1);
	}

	public String getPlatformName() {
		return platformName.get();
	}

	public String getUDID() {
		return udid.get();
	}

	public void setUDID(String udid2) {
		udid.set(udid2);
	}

	public String getDeviceName() {
		return deviceName.get();
	}

	public void setDeviceName(String deviceName2) {
		deviceName.set(deviceName2);
	}

	public String getSystemPort() {
		return systemPort.get();
	}

	public void setSystemPort(String systemPort2) {
		systemPort.set(systemPort2);
	}

	public String getChromeDriverPort() {
		return chromeDriverPort.get();
	}

	public void setChromeDriverPort(String chromeDriverPort2) {
		chromeDriverPort.set(chromeDriverPort2);
	}

	



	public void initializeGlobalParams() {
		GlobalParams params = new GlobalParams();
		params.setPlatformName("Android");
//		params.setUDID("emulator-5554");
		params.setDeviceName("emulator-5554");

		switch (params.getPlatformName()) {
		case "Android":
			params.setSystemPort("10000");
			params.setChromeDriverPort("11000");
			break;
		
		default:
			throw new IllegalStateException("Invalid Platform Name!");
		}
	}

}
