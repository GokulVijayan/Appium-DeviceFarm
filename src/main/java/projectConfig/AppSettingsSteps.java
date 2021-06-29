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
	
	public AppSettingsSteps(String timeOut, String dateTimeFormat, String date, String deviceName, String time, String platformName, String udid, String appPackage, String appActivity, String appName, String buildVersion, String newCommandTimeout, String platformVersion)
	{
		this.timeOut = timeOut;
		this.dateTimeFormat = dateTimeFormat;
		this.date = date;
		this.time = time;
		this.deviceName = deviceName;
		this.udid = udid;
		this.platformName = platformName;
		this.platformVersion = platformVersion;
		this.appPackage = appPackage;
		this.appActivity = appActivity;
		this.newCommandTimeout = newCommandTimeout;
		this.buildVersion = buildVersion;
		this.appName = appName;
		
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
	
	


}
