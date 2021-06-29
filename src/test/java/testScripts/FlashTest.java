package testScripts;




import java.util.List;

import org.json.JSONArray;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ReportModifier;
import Reports.TestReportSteps;
import Utilities.ConfigFile;
import pages.FlashlightPage;
import projectConfig.Setup;
import testdata.LoginPage.LoginTestData;
import uiselectors.FlashPage.FlashSelector;

@Listeners({ ReportModifier.class })
public class FlashTest extends Setup{

	public static JSONArray inputjson;
    static ClassLoader classLoader = FlashSelector.class.getClassLoader();
    private static LoginTestData listOfInputs;

	public FlashTest() throws Exception {
		testObjective = "To Verify that user is able to login to iroads application";		
		scriptName="IR001_LoginToApplication";
		listOfInputs=(LoginTestData) ConfigFile.RetrieveTestData(classLoader, "LoginTestData.json", "testdata.LoginPage.LoginTestData");
		System.out.println("Input Data is:"+listOfInputs.getPassword());
	}
	

	@Test
	public void login() throws Exception {

		List<TestReportSteps> report = null;
		
		report = FlashlightPage.FlashOn(driver);
		finalreport.addAll(report);		
		for (String s1 : FlashlightPage.getFilePath()) {
			screenshotList.add(s1);
		}
		report.clear();
	}

	
	


}
