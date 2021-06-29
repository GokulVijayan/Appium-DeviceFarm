package Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.Gson;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConfigFile {

	static String browserName,driverPath,url;
    private static AppiumDriver<MobileElement> driver;

    static ArrayList<String> lines = new ArrayList<String>();
    
    /**
	 * Retrieve ui mappers 
	 * @param classLoader 
	 * @param fileName - input json file name
	 * @param fullyQualifiedClassName - class file to which input json is converted
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static <T> Object RetrieveUIMap(ClassLoader classLoader, String fileName, String fullyQualifiedClassName) throws ClassNotFoundException, IOException
	{
		Gson gson = new Gson();
		URL Selector = classLoader.loadClass(fullyQualifiedClassName).getResource(fileName);
		Class<?> classType = Class.forName(fullyQualifiedClassName);

		InputStream SelectorStream = Selector.openStream();
		BufferedReader brSelector = new BufferedReader(new InputStreamReader(SelectorStream, "UTF-8"));
		
		Object selectorCaseObj = gson.fromJson(brSelector, classType);
			
		return selectorCaseObj;
	}
	
	
	/**
	 * Retrieve Testdat
	 * @param classLoader 
	 * @param fileName - input json file name
	 * @param fullyQualifiedClassName - class file to which input json is converted
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static <T> Object RetrieveTestData(ClassLoader classLoader, String fileName, String fullyQualifiedClassName) throws ClassNotFoundException, IOException
	{
		Gson gson = new Gson();
		URL Selector = classLoader.loadClass(fullyQualifiedClassName).getResource(fileName);
		Class<?> classType = Class.forName(fullyQualifiedClassName);

		InputStream SelectorStream = Selector.openStream();
		BufferedReader brSelector = new BufferedReader(new InputStreamReader(SelectorStream, "UTF-8"));
		
		Object selectorCaseObj = gson.fromJson(brSelector, classType);
			
		return selectorCaseObj;
	}
	
	
    /// <summary>
    /// Retrieve current date time in format 'MM-dd-yyyy HH-mm-ss'
    /// </summary>
    /// <returns></returns>
    public static String GetCurrentDateTime() throws Exception
    {
    	LocalDateTime datetime = LocalDateTime.now();
    	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern(Constant.dateTimeFormat);
        return datetime.format(datetimeformat);
    }
	

	
    /**
	 * Retrieve  apk specified in constant file
	 * @return application apk if apk ! = null else returns runtime exception
     * @throws Exception 
	 */
	public static String GetApk() throws Exception {
		String apk = Constant.currentDirectory+"//src//main//resources//apkfiles//"+Constant.appName;
		return apk;
	}
	
	  /// <summary>
    /// Initialize driver for the capabilities specified in appSettings and navigate to the URL specified in appSettings 
    /// </summary>
    /// <returns>driver - Initialized driver</returns>
    public static AppiumDriver<MobileElement> Init() throws Exception
    {
       
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
    	
    	if(Constant.runFromLocal.toLowerCase().contains("yes"))
    	{
    	capabilities.setCapability("deviceName", Constant.deviceName);
		capabilities.setCapability("udid", Constant.udid);
		capabilities.setCapability("platformName", Constant.platformName);
		capabilities.setCapability("platformVersion", Constant.platformVersion); 
		capabilities.setCapability("app", ConfigFile.GetApk());
		capabilities.setCapability("appPackage",Constant.appPackage);
		capabilities.setCapability("appActivity", Constant.appActivity);
		capabilities.setCapability("newCommandTimeout", Constant.newCommandTimeout);
		capabilities.setCapability("disableWindowAnimation", true);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("autoGrantPermissions",true);
    	}
    	
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return driver;
    }
	
	
}
