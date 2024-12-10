package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import base.ProjectSpecificationMethod;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends ProjectSpecificationMethod implements ITestListener {

	@Override
    public void onTestSuccess(ITestResult result) {
        // Log success in the report
    	test.log(Status.PASS, "Test passed");
    }

  

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the report
    	// TODO Auto-generated method stub
//    			test = extent.createTest(testName,testDescription);
//    			test.assignCategory(testCategory);
//    			test.assignAuthor(testAuthor);
    	test = extent.createTest(result.getMethod().getMethodName());
    }

    

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure in the report
    	// TODO Auto-generated method stub
    			test.fail(result.getThrowable());
    			String filepath =null;
    			try {
    				filepath =screenshot(result.getMethod().getMethodName());
    				
    				
    			} catch (IOException e) {
    				// TODO: handle exception
    				e.printStackTrace();
    			}
    			test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
    
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the reports at the end of the tests
        extent.flush();
    }
}