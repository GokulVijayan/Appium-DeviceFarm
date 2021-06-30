package pages;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import GenericComponents.ReusableComponents;
import Reports.CaptureScreenshot;
import Reports.TestReportSteps;
import Utilities.ConfigFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import uiselectors.HomePage.HomeSelector;

public class HomePage {
	public static JSONObject jObject;
    public static List<String> screenshotList = new ArrayList<String>();
    static ClassLoader classLoader = HomeSelector.class.getClassLoader();
    private static HomeSelector listOfSelectors;
	
	 public static  List<TestReportSteps> Home(AppiumDriver<MobileElement> driver) throws Exception
		{
		 List<TestReportSteps> listOfReport=new ArrayList<TestReportSteps>();
		 listOfSelectors=(HomeSelector) ConfigFile.RetrieveUIMap(classLoader, "HomeSelector.json", "uiselectors.HomePage.HomeSelector");
         screenshotList.clear();
         int step = 0;
         String objective = "To verify that user reaches the home page.";
       

         try
         {
        	 Thread.sleep(5000);
        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify homepage is displayed.Capture Screenshot.","", objective, step));
        	 if(ReusableComponents.CheckElementVisible(driver, "XPath", listOfSelectors.getflashlight())==true)
        	 {
                 listOfReport.get(step++).actualResultFail = "";
        	 }
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashpage"));

             
          
             
         }
         catch (Exception e)
         {
        	 System.out.println("LoginToApplication failed at step: "+(step+1)+" "+e);
             if(!listOfReport.get(step).GetStepDescription().toLowerCase().contains("screenshot"))          
             listOfReport.get(step).stepDescription=listOfReport.get(step).stepDescription.concat(" Capture Screenshot.");           
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "homepageError"+ ConfigFile.GetCurrentDateTime()));

         }

         return listOfReport;
			
		}

	 public static List<String> getFilePath()
		{
			return screenshotList;
		}
}
