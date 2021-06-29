package Utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import projectConfig.AppSettingsSteps;





public class Constant {
    public static int waitTimeout;
    public static String currentDateTime;
    public static String currentDate;
    public static String currentTime;
    public static String browserName;
    public static String timeOut;
    public static String dateTimeFormat;
    public static String date;
    public static String time;
    public static String deviceName;
    public static String udid;
    public static String platformName;
    public static String platformVersion;
    public static String appPackage;
    public static String appActivity;
    public static String newCommandTimeout;
    public static String buildVersion;
    public static String appName;
    public static final String currentDirectory = System.getProperty("user.dir");
    static ClassLoader classLoader = AppSettingsSteps.class.getClassLoader();
    private static AppSettingsSteps listOfSettings;
    
    /// <summary>
    /// Sets values from configFile into variables
    /// </summary>
    /// <param name="file"></param>
    public static void SetConfig() throws Exception, Exception
    {
    	listOfSettings=(AppSettingsSteps) ConfigFile.RetrieveUIMap(classLoader, "AppSettings.json", "projectConfig.AppSettingsSteps");
    	timeOut=listOfSettings.getTimeout();
    	dateTimeFormat=listOfSettings.getDateTimeFormat();
    	date=listOfSettings.getDate();
    	time=listOfSettings.getTime();
    	deviceName=listOfSettings.getDeviceName();
    	udid=listOfSettings.getUdid();
    	platformName=listOfSettings.getPlatformName();
    	platformVersion=listOfSettings.getPlatformVersion();
    	appPackage=listOfSettings.getAppPackage();
    	appActivity=listOfSettings.getAppActivity();
    	newCommandTimeout=listOfSettings.getNewCommandTimeout();
    	buildVersion=listOfSettings.getBuildVersion();
    	appName=listOfSettings.getAppName();
    
    	
    	LocalDateTime datetime = LocalDateTime.now();
    	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern(dateTimeFormat);
        currentDateTime = datetime.format(datetimeformat);
        LocalDate dateFormat = LocalDate.now(); 
    	DateTimeFormatter dateformat = DateTimeFormatter.ofPattern(date);
        currentDate = dateFormat.format(dateformat);
        	    LocalTime timeInHrs = LocalTime.now();
        DateTimeFormatter timeformat = DateTimeFormatter.ofPattern(time);
        currentTime = timeInHrs.format(timeformat);
        waitTimeout = Integer.parseInt(timeOut)*1000;

    }        
    
    
    
}
