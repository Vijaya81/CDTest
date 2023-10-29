package com.cd.qa.util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("CD Test Automation Results");
		sparkReporter.config().setDocumentTitle("CD Automation Report");
		sparkReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);	
		
		return extentReport;
		
	}

}
