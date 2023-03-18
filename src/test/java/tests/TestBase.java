package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class TestBase {
	
	protected static ExtentSparkReporter reporter;
	protected static ExtentReports  extent;
	protected static ExtentTest test;
	
	
	 @BeforeSuite
	    public void setUp() {
	        // set the file name for the HTML report to be generated by Extent Reports
		 reporter = new ExtentSparkReporter("extent.html");
	    
	        // create and ExtentReports object to write to htmlReported
	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	    }

	 @AfterSuite
	    public void tearDown() {
	        // flush the data into ExtentReports object for the reports to be generated
	        extent.flush();
	    }

}
