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
import uiselectors.LoginPage.LoginSelectorSteps;

public class FlashlightPage {
	public static JSONObject jObject;
    public static List<String> screenshotList = new ArrayList<String>();
    static ClassLoader classLoader = LoginSelectorSteps.class.getClassLoader();
    private static LoginSelectorSteps listOfSelectors;
	
	 public static  List<TestReportSteps> FlashOn(AppiumDriver<MobileElement> driver) throws Exception
		{
		 List<TestReportSteps> listOfReport=new ArrayList<TestReportSteps>();
		 listOfSelectors=(LoginSelectorSteps) ConfigFile.RetrieveUIMap(classLoader, "LoginSelector.json", "uiselectors.LoginPage.LoginSelectorSteps");
         screenshotList.clear();
         int step = 0;
         String objective = "To verify that user is able to switch on flashlight.";
       

         try
         {
             //Enter username
        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify user click switch on.Capture Screenshot.","", objective, step));
        	 ReusableComponents.Click(driver, "XPath",listOfSelectors.getAddButton());
             listOfReport.get(step++).actualResultFail = "";
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "flashpage"));

             //Enter password
             listOfReport.add(ReusableComponents.GenerateReportSteps("Verify popup displayed.Capture Screenshot.","", objective, step));
             if(ReusableComponents.CheckElementVisible(driver, "XPath", listOfSelectors.getSubmitButton())==true)
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
