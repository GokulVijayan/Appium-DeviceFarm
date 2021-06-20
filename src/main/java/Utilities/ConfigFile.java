package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import GenericComponents.ReusableComponents;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConfigFile {

	static String browserName,driverPath,url;
    private static AppiumDriver<MobileElement> driver;

    static ArrayList<String> lines = new ArrayList<String>();
	
    /// <summary>
    /// To retrieve testdata array input in json array format for the input file specified
    /// </summary>
    /// <param name="fileName">Input testdata file name</param>
	public static JSONArray RetrieveTestData(String fileName) throws Exception
    {
		System.out.println(Constant.currentDirectory);
		Path dir = FileSystems.getDefault().getPath(Constant.currentDirectory );
		DirectoryStream<Path> stream = Files.newDirectoryStream( dir );
		for (Path path : stream) {
		   System.out.println( path.getFileName() );
		}
		stream.close();
		String path1 = "src//main//resources//testdata";
		//File file = new File(path1);
		/*
		 ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		    InputStream inputStream = ConfigFile.class.getClassLoader().getResourceAsStream(Constant.currentDirectory +"//testdata//"+fileName);
		    String theString = IOUtils.toString(inputStream, "UTF-8"); 
		    System.out.println( theString );
		    */
		    //Get file from resources folder
	        ClassLoader classLoader = (new ConfigFile()).getClass().getClassLoader();

	        InputStream streamss = classLoader.getResourceAsStream("testdata//"+fileName);
	        InputStream input=Thread.currentThread().getContextClassLoader().getResourceAsStream( ReusableComponents.GetAbsoluteFilePath("//tmp//testdata//")+fileName);
	        
	        //URL resource = ClassLoader.getSystemResource("testdata//"+fileName);
	        //InputStream streams = resource.openStream();

		    //InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		    /*BufferedReader reader = new BufferedReader(streamReader);
		    for (String line; (line = reader.readLine()) != null;) {
		      lines.add(line);
		    }*/
		    String theStrings = IOUtils.toString(input, "UTF-8"); 
		System.out.println(theStrings.toString());
		//String path = file.getAbsolutePath()+"//"+fileName;
		//String data = new String(Files.readAllBytes(Paths.get(fileName))); 
        JSONObject obj = new JSONObject(theStrings);
        JSONArray testData = obj.getJSONArray("TestData");
        return testData;
    }
	
	  /// <summary>
    /// Returns UiMap object
    /// </summary>
    /// <param name="fileName"></param>
    /// <returns>JObject</returns>
	public static JSONObject RetrieveUIMap(String fileName) throws IOException, JSONException
    {
		String path1 = "src//main//resources//uiselectors";
		//File file = new File(path1);
		//String path = file.getAbsolutePath()+"//"+fileName;
		//String data = new String(Files.readAllBytes(Paths.get(fileName))); 
		 ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		    InputStream inputStream = classloader.getResourceAsStream("uiselectors//"+fileName);
		    String theString = IOUtils.toString(inputStream, "UTF-8"); 
			System.out.println(theString.toString());
        JSONObject obj = new JSONObject(theString);
        return obj;
    }
	
	
    /// <summary>
    /// Retrieve current date time in format 'MM-dd-yyyy HH-mm-ss'
    /// </summary>
    /// <returns></returns>
    public static String GetCurrentDateTime() throws Exception
    {
    	LocalDateTime datetime = LocalDateTime.now();
    	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        return datetime.format(datetimeformat);
    }
	
	/// <summary>
    /// Returns configuration settings
    /// </summary>
    /// <returns>Configuration</returns>
    public static String GetAppConfig(String settings) throws Exception
    {
    	String path1 = "src//main//java//projectConfig//AppSettings.json";
		File file = new File(path1);
		String path = file.getAbsolutePath();
		String data = new String(Files.readAllBytes(Paths.get("AppSettings.json"))); 
        JSONObject obj = new JSONObject(data);
        return obj.get(settings).toString();
    }

	
    /**
	 * Retrieve pax app apk specified in constant file
	 * @return application apk if apk ! = null else returns runtime exception
     * @throws Exception 
	 */
	public static String GetApk() throws Exception {
		//String apk = Constant.currentDirectory+"//src//main//resources//apkfiles//"+ConfigFile.GetAppConfig("appName");
		String apk = ConfigFile.GetAppConfig("appName");
		return apk;
	}
	
	  /// <summary>
    /// Initialize driver for the capabilities specified in appSettings and navigate to the URL specified in appSettings 
    /// </summary>
    /// <returns>driver - Initialized driver</returns>
    public static AppiumDriver<MobileElement> Init() throws Exception
    {
       
    	
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("deviceName", "OnePlus 8");
		//capabilities.setCapability("udid", "f5f7e6b7");
		//capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("platformVersion", "11"); 
		//capabilities.setCapability("app", "hibernate.v2.testyourandroid_1910432_apps.evozi.com.apk");
		//capabilities.setCapability("appPackage","hibernate.v2.testyourandroid");
		//capabilities.setCapability("appActivity", "hibernate.v2.testyourandroid.ui.main.MainActivity");
		//capabilities.setCapability("newCommandTimeout", "90000");
		//capabilities.setCapability("disableWindowAnimation", true);
		//capabilities.setCapability("noReset", true);
		//capabilities.setCapability("fullReset", false);
		//capabilities.setCapability("autoGrantPermissions",true);
		
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
