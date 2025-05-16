package genaralUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**Listenerclass used to monitor runtime execution of testscript and 
 * capture the pass/fail status to log in extentreport
 * 
 */
public class ListenerImplementation implements ITestListener
{
	ExtentSparkReporter sReporter;//UI of the report
	ExtentReports report;// common info of the report
	ExtentTest test;//creating testcase entries and update the status
	String repName;
	WebDriverUtility w=new WebDriverUtility();
	javaUtility j=new javaUtility();
	public void onStart(ITestContext context) {
	javaUtility j=new javaUtility();
		String repName="Test Report"+j.systemDate()+".html";
		
		
		sReporter =new ExtentSparkReporter(".\\Reports\\"+repName);
		sReporter.config().setDocumentTitle("Automation Report");
		sReporter.config().setReportName("Functional Testing");
		sReporter.config().setTheme(Theme.STANDARD);
		report=new ExtentReports();
		report.attachReporter(sReporter);
		report.setSystemInfo("Computer Name","local Host");
		report.setSystemInfo("Environment","test");
		report.setSystemInfo("Tester Name","sangeetha");
		report.setSystemInfo("OS","windows11");
		report.setSystemInfo("Browser Name","Chrome");
		
		System.out.println("************** suite execution started***********");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"*************Test script execution started******");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName =result.getMethod().getMethodName();
		test=report.createTest( methodName);
		test.log(Status.PASS,methodName+" is successfully executed");
		
		System.out.println(methodName+"*****************Test success**********");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName =result.getMethod().getMethodName();
		test=report.createTest( methodName);
		test.log(Status.FAIL,methodName+" is failed");
		
		//String methodName =result.getMethod().getMethodName();
	
		System.out.println(methodName+"*****************Test failure**********");
		try
		{			
		String path = w.captureScreenShot(BaseClass.driver,methodName);
		test.addScreenCaptureFromPath(path);}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodName =result.getMethod().getMethodName();
		test=report.createTest( methodName);
		test.log(Status.SKIP,methodName+" is skipped");
		//String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"***************test skipped***************");
	}


	
	
	

	
	public void onFinish(ITestContext context) {
		report.flush();
		
		System.out.println("************** suite execution finished***********");}

}
