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

public class FlashlightPage {
	public static JSONObject jObject;
    public static List<String> screenshotList = new ArrayList<String>();

	 
	
	 public static  List<TestReportSteps> FlashOn(AppiumDriver<MobileElement> driver) throws Exception
		{
		 List<TestReportSteps> listOfReport=new ArrayList<TestReportSteps>();
         screenshotList.clear();
         int step = 0;
         String objective = "To verify that user is able to switch on flashlight.";
         //jObject = ConfigFile.RetrieveUIMap("FlashlightPageSelector.json");

         try
         {
             //Enter username
        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify user click switch on.Capture Screenshot.","", objective, step));
        	 ReusableComponents.Click(driver, "XPath","//android.widget.TextView[@content-desc='Add to home screen']");
             listOfReport.get(step++).actualResultFail = "";
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashpage"));

             //Enter password
             listOfReport.add(ReusableComponents.GenerateReportSteps("Verify popup displayed.Capture Screenshot.","", objective, step));
             if(ReusableComponents.CheckElementVisible(driver, "XPath", "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")==true)
        	 {
                 listOfReport.get(step++).actualResultFail = "";
        	 }
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "lastscreenshot"));
             
          
             
         }
         catch (Exception e)
         {
        	 System.out.println("LoginToApplication failed at step: "+(step+1)+" "+e);
             if(!listOfReport.get(step).GetStepDescription().toLowerCase().contains("screenshot"))          
             listOfReport.get(step).stepDescription=listOfReport.get(step).stepDescription.concat(" Capture Screenshot.");           
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashpageError"+ ConfigFile.GetCurrentDateTime()));

         }

         return listOfReport;
			
		}

	 public static List<String> getFilePath()
		{
			return screenshotList;
		}
}
