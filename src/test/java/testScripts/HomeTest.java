package testScripts;

import java.util.List;

import org.json.JSONArray;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Reports.ReportModifier;
import Reports.TestReportSteps;
import Utilities.ConfigFile;
import pages.FlashlightPage;
import pages.HomePage;
import projectConfig.Setup;
import testdata.LoginPage.LoginTestData;
import uiselectors.FlashPage.FlashSelector;
import uiselectors.HomePage.HomeSelector;

@Listeners({ ReportModifier.class })
public class HomeTest extends Setup{

	public static JSONArray inputjson;
    static ClassLoader classLoader = HomeSelector.class.getClassLoader();

	public HomeTest() throws Exception {
		testObjective = "To Verify that home page is displayed.";		
		scriptName="IR001_HomePage";
	}
	

	@Test
	public void Home() throws Exception {

		List<TestReportSteps> report = null;
		
		report = HomePage.Home(driver);
		finalreport.addAll(report);		
		for (String s1 : HomePage.getFilePath()) {
			screenshotList.add(s1);
		}
		report.clear();
	}

	
	


}
