package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GUIActions {

	public GUIActions(AndroidDriver driver) {
		this.driver = driver;
	}

	AndroidDriver driver;

	public void click(String locatorType, String locatorValue) {
		System.out.println("Click on "+locatorValue);
		switch(locatorType) {
		case "id" :
		{
			driver.findElement(AppiumBy.id(locatorValue)).click();
			break;
		}
		case "class" :
		{
			driver.findElement(AppiumBy.className(locatorValue)).click();
			break;
		}
		case "name" :
		{
			driver.findElement(AppiumBy.name(locatorValue)).click();
			break;
		}
		case "accessibilityId" :
		{
			driver.findElement(AppiumBy.accessibilityId(locatorValue)).click();
			break;
		}
		case "xpath" :
		{
			driver.findElement(AppiumBy.xpath(locatorValue)).click();
			break;
		}
		default :
		{
			System.err.println("Locator Type = "+locatorType+" with Value = "+locatorValue+" does not exists");
			break;
		}
		}
	}
	
}
