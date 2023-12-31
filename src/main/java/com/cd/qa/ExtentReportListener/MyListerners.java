package com.cd.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cd.qa.base.TestBase;
import com.cd.qa.util.ExtentReporter;

public class MyListerners extends TestBase implements ITestListener {
	
	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReport = ExtentReporter.generateExtentReport();			
	}		
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName= result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
				
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		extentTest.log(Status.PASS,testName+" got successfully executed" );				
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName= result.getName();	
				
		 File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destinationScreenshotPath = System.getProperty("user.dir")+"\\ScreenShots\\"+testName+".png";
		 try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {			
			e.printStackTrace();
		}		 
		 
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,testName+" got failed");
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName= result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testName+ " got skipped");		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	
	
	
	
	
	
	
	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	

}
