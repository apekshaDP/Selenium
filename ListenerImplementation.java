package commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	 
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
   String methodname = result.getMethod().getMethodName();
		
		Reporter.log(methodname+"Testscript execution is passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String msg = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is failed"+msg,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log(methodname+"Testscript execution is skipped",true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	         //   System.out.println("to start the execution");
		Reporter.log("Testscript execution is started",true);
		//Use ExtentSparkReporter class just to configure extent Report
		 
		JavaUtil jutil=new JavaUtil();
		ExtentSparkReporter reporter=new ExtentSparkReporter("./extentreport/report.html"+jutil.getRandomNumber()+".html");
		//call config() to configure ExtetReport &call setDocumentTitle() to give title for the report
		reporter.config().setDocumentTitle("vtigercrm");
		//call a method Set theme to set theme for extentreport-----standard and dark
		reporter.config().setTheme(Theme.DARK);
		//call a method called setReporter name to set the name to extentReport.
		reporter.config().setReportName("Pune");
		//create the object of extent report class which is from avenstack package to generate extent report
		 report=new ExtentReports();
		
		report.attachReporter(reporter);
		
		report.setSystemInfo("OS", "Window");
		
		report.setSystemInfo("Browser", "Chrome");
		
		report.setSystemInfo("chromeverison", "121");
		
		report.setSystemInfo("Author", "Abhishek");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		// System.out.println("to finish the execution");
		Reporter.log("Testscript execution is finished",true);
		report.flush();
		
	}
	

}
