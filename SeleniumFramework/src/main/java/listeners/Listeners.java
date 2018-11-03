package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener, ISuiteListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("********* " + result.getName() + " started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("********* " + result.getName() + " passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("********* " + result.getName() + " failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("********* " + result.getName() + " skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********* " + result.getName() + " failed but within success percentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("********* " + context.getName() + " started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("********* " + context.getName() + " finished");
		
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("********* " + suite.getName() + " started");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("********* " + suite.getName() + " finished");
		
	}	
}
