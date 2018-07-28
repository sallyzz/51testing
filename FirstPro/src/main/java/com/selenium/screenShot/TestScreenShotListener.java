package com.selenium.screenShot;

import java.io.File;
import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestScreenShotListener extends TestListenerAdapter{
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		try {
			Field field=tr.getTestClass().getRealClass().getField("driver");
			WebDriver driver=(WebDriver)field.get(tr.getInstance());
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			file.renameTo(new File("abc.png"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onTestFailure(tr);
	}

}
