package projectConfig;

public class AppSettingsSteps {
	
	private String timeOut;
	private String dateTimeFormat;
	private String date;
	private String time;
	private String deviceName;
	private String udid;
	private String platformName;
	private String platformVersion;
	private String appPackage;
	private String appActivity;
	private String newCommandTimeout;
	private String buildVersion;
	private String appName;
	private String runFromLocal;
	
	
	public AppSettingsSteps()
	{
		
		timeOut= "60";
		dateTimeFormat="dd-MM-yyyy HH-mm-ss";
		date= "MM-dd-yyyy";
		time= "HH:mm:ss";
		deviceName= "OnePlus 8";
		udid= "f5f7e6b7";
		platformName= "Android";
		platformVersion= "11";
		appPackage= "hibernate.v2.testyourandroid";
		appActivity= "hibernate.v2.testyourandroid.ui.main.MainActivity";
		newCommandTimeout= "90000";
	 	buildVersion="1.1";
	 	appName="hibernate.v2.testyourandroid_1910432_apps.evozi.com.apk";
	 	runFromLocal="no";
	}
	
	/**
	 * Retrieve timeOut
	 * @return
	 */

	public String getTimeout() {
		return timeOut;
	}

	/**
	 * Retrieve dateTimeFormat
	 * @return
	 */
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	/**
	 * Retrieve date
	 * @return
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Retrieve time
	 * @return
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * Retrieve deviceName
	 * @return
	 */
	public String getDeviceName() {
		return deviceName;
	}
	
	/**
	 * Retrieve udid
	 * @return
	 */
	public String getUdid() {
		return udid;
	}
	
	/**
	 * Retrieve platformName
	 * @return
	 */
	public String getPlatformName() {
		return platformName;
	}
	
	/**
	 * Retrieve platformVersion
	 * @return
	 */
	public String getPlatformVersion() {
		return platformVersion;
	}
	
	/**
	 * Retrieve appPackage
	 * @return
	 */
	public String getAppPackage() {
		return appPackage;
	}
	
	/**
	 * Retrieve appActivity
	 * @return
	 */
	public String getAppActivity() {
		return appActivity;
	}
	
	/**
	 * Retrieve newCommandTimeout
	 * @return
	 */
	public String getNewCommandTimeout() {
		return newCommandTimeout;
	}
	
	/**
	 * Retrieve buildVersion
	 * @return
	 */
	public String getBuildVersion() {
		return buildVersion;
	}
	
	/**
	 * Retrieve appName
	 * @return
	 */
	public String getAppName() {
		return appName;
	}
	
	
	/**
	 * Retrieve runFromLocal
	 * @return
	 */
	public String getRunFromLocal() {
		return runFromLocal;
	}


}
