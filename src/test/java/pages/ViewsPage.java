package pages;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;

public class ViewsPage {

	AndroidDriver driver;
	GUIActions gui;

	public ViewsPage(AndroidDriver driver) {
		this.driver = driver;
		gui = new GUIActions(driver);
	}

	public void clickMenu(String menu1, String menu2, String menu3) {
		
		if(!menu1.isEmpty())
			gui.click("xpath", "//android.widget.TextView[@text='"+menu1+"']");
		if(!menu2.isEmpty())
			gui.click("accessibilityId", menu2);
		if(!menu3.isEmpty())
			gui.click("accessibilityId", menu3);
	}
	
	public void verifyObject(String locatorType, String locatorValue, String verificationAttribute, String verificationData) {
		String actData = gui.getAttribute(locatorType, locatorValue, verificationAttribute);
		Assert.assertEquals(actData, verificationData, "Verify "+verificationAttribute);
	}
	
	public void click(String locatorType, String locatorValue) {
		gui.click(locatorType, locatorValue);
	}
	
	public void type(String locatorType, String locatorValue, String value) {
		gui.type(locatorType, locatorValue, value);
	}
	
	public String getText(String locatorType, String locatorValue) {
		return gui.getText(locatorType, locatorValue);
	}
	
	public String getAttribute(String locatorType, String locatorValue, String attribute) {
		return gui.getAttribute(locatorType, locatorValue, attribute);
	}

	public void drag(String locatorType, String locatorValue, String coordinates) {
		gui.drag(locatorType, locatorValue, coordinates);
	}
}
