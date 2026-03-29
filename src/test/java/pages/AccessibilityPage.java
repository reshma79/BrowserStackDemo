package pages;


import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;
import utils.TestUtils;

public class AccessibilityPage {
	AndroidDriver driver;
	GUIActions gui;
	
    private By chkTakeOutTrash = AppiumBy.xpath("//android.widget.TextView[@text='Take out Trash']/following-sibling::android.widget.CheckBox");

    private By chkDoLaundry = AppiumBy.xpath("//android.widget.TextView[@text='Do Laundry']/following-sibling::android.widget.CheckBox");

    private By chkConquerWorld = AppiumBy.xpath("//android.widget.TextView[@text='Conquer World']/following-sibling::android.widget.CheckBox");

    private By chkNap = AppiumBy.xpath("//android.widget.TextView[@text='Nap']/following-sibling::android.widget.CheckBox");

    private By button = AppiumBy.id("io.appium.android.apis:id/button");
    
	public AccessibilityPage(AndroidDriver driver) {
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
	
    public void clickMenuAccessibility() {
    	gui.click("xpath", "//android.widget.TextView[@text='Accessibility']");
    }
    
    public void clickMenuAccessibilityNodeQuerying() {
    	gui.click("accessibilityId", "Accessibility Node Querying");
    }

    public void clickMenuAccessibilityNodeProvider() {
    	gui.click("accessibilityId", "Accessibility Node Provider");
    }

    public void clickMenuAccessibilityService() {
    	gui.click("accessibilityId", "Accessibility Service");
    }

    public void clickMenuCustomView() {
    	gui.click("accessibilityId", "Custom View");
    }
    
    public void clickCheckBox(String checkBox) {
    	gui.click("xpath", "//android.widget.TextView[@text='"+checkBox+"']/following-sibling::android.widget.CheckBox");
    }

    public Boolean stateCheckBox(String checkBox) {
    	return Boolean.parseBoolean(gui.getAttribute("xpath", "//android.widget.TextView[@text='"+checkBox+"']/following-sibling::android.widget.CheckBox", "checked"));
    }
    
    public void checkTakeOutTrash(){
    	driver.findElement(chkTakeOutTrash).click();
    }

    public boolean stateTakeOutTrash(){
    	return Boolean.parseBoolean(driver.findElement(chkTakeOutTrash).getAttribute("checked"));
    }

    public void checkDoLaundry(){
    	driver.findElement(chkDoLaundry).click();
    	TestUtils.sleep(1);
    }

    public boolean stateDoLaundry(){
    	return Boolean.parseBoolean(driver.findElement(chkDoLaundry).getAttribute("checked"));
    }

    public void checkConquerWorld(){
    	driver.findElement(chkConquerWorld).click();
    	TestUtils.sleep(1);
    }

    public boolean stateConquerWorld(){
    	return Boolean.parseBoolean(driver.findElement(chkConquerWorld).getAttribute("checked"));
    }

    public void checkNap(){
    	driver.findElement(chkNap).click();
    }

    public boolean stateNap(){
    	return Boolean.parseBoolean(driver.findElement(chkNap).getAttribute("checked"));
    }

    public void clickButton() {
    	driver.findElement(button).click();
    }
}
