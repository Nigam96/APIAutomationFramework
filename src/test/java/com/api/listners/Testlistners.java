package com.api.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Testlistners implements ITestListener {
private static final Logger getLogger=LogManager.getLogger(Testlistners.class);

	public void onTestStart(ITestResult result) {
		getLogger.info("Started !!"+result.getMethod().getMethodName());
		getLogger.info("Description"+result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		getLogger.info("Passed !!"+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		getLogger.error("Failed !!"+result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onStart(ITestContext context) {
		getLogger.info("Test Suite Started !!");
	}

	
	public void onFinish(ITestContext context) {
		getLogger.info("Test Suite Completed !!");
	}
}
