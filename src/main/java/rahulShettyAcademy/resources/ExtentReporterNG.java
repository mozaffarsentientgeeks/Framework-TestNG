package rahulShettyAcademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
			String path = System.getProperty("user.dir") + "//extentReport//index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Report");
			reporter.config().setDocumentTitle("Test Result");
			
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Mozaffar");
			return extent;
	}
}
