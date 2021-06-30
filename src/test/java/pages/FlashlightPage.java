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
import uiselectors.FlashPage.FlashSelector;

public class FlashlightPage {
	public static JSONObject jObject;
    public static List<String> screenshotList = new ArrayList<String>();
    static ClassLoader classLoader = FlashSelector.class.getClassLoader();
    private static FlashSelector listOfSelectors;
	
	 public static  List<TestReportSteps> FlashOn(AppiumDriver<MobileElement> driver) throws Exception
		{
		 List<TestReportSteps> listOfReport=new ArrayList<TestReportSteps>();
		 listOfSelectors=(FlashSelector) ConfigFile.RetrieveUIMap(classLoader, "FlashSelector.json", "uiselectors.FlashPage.FlashSelector.java");
         screenshotList.clear();
         int step = 0;
         String objective = "To verify that user is able to switch on flashlight.";
       

         try
         {
        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify user click on Flashlight icon.Capture Screenshot.","", objective, step));
        	 ReusableComponents.Click(driver, "XPath",listOfSelectors.getflashlight());
             listOfReport.get(step++).actualResultFail = "";
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashing"));

        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify user click switch on button.Capture Screenshot.","", objective, step));
        	 ReusableComponents.Click(driver, "Id",listOfSelectors.getaddbtn());
             listOfReport.get(step++).actualResultFail = "";
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashpage"));
             Thread.sleep(4000);
             listOfReport.add(ReusableComponents.GenerateReportSteps("Verify user click switch off button.Capture Screenshot.","", objective, step));
        	 ReusableComponents.Click(driver, "Id",listOfSelectors.getaddbtn());
             listOfReport.get(step++).actualResultFail = "";
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
