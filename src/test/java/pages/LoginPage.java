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

public class LoginPage {
	public static JSONObject jObject;
    public static List<String> screenshotList = new ArrayList<String>();

	 
	
	 public  List<TestReportSteps> LoginToApplication(AppiumDriver<MobileElement> driver,JSONObject inputjson) throws Exception
		{
		 List<TestReportSteps> listOfReport=new ArrayList<TestReportSteps>();
         screenshotList.clear();
         int step = 0;
         String objective = "To verify that user has reached homepage.";
         jObject = ConfigFile.RetrieveUIMap("LoginPageSelector.json");

         try
         {
             //Enter username
        	 listOfReport.add(ReusableComponents.GenerateReportSteps("Verify homepage is displayed.Capture Screenshot.","", objective, step));
        	 if(ReusableComponents.CheckElementVisible(driver, "XPath", jObject.get("flashlight").toString())==true)
        	 {
                 listOfReport.get(step++).actualResultFail = "";
        	 }
             screenshotList.add(CaptureScreenshot.TakeSingleSnapShot(driver, "homepage"));

             //Enter password
             listOfReport.add(ReusableComponents.GenerateReportSteps("Click on homepage.","", objective, step));
             ReusableComponents.Click(driver, "XPath", jObject.get("flashlight").toString());
             listOfReport.get(step++).actualResultFail = "";
             
          
             
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
	
	 
	 
	 
	 
	 
	 public List<String> getFilePath()
		{
			return screenshotList;
		}
	 
	 
	 
	 
}
