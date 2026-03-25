package pages;


import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;

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

    private By chkDoTaxes = AppiumBy.xpath("//android.widget.TextView[@text='Do Taxes']/following-sibling::android.widget.CheckBox");

    private By chkAbolishIRS = AppiumBy.xpath("//android.widget.TextView[@text='Abolish IRS']/following-sibling::android.widget.CheckBox");

    private By chkTeaWithAuntSharon = AppiumBy.xpath("//android.widget.TextView[@text='Tea with Aunt Sharon']/following-sibling::android.widget.CheckBox");

    private By imgStatusBar = AppiumBy.id("android:id/statusBarBackground");

    private By button = AppiumBy.id("io.appium.android.apis:id/button");
    
	public AccessibilityPage(AndroidDriver driver) {
		this.driver = driver;
		gui = new GUIActions(driver);
	}

    public void clickMenuAccessibility() {
    	gui.click("xpath", "//android.widget.TextView[@text='Accessibility']");
    	TestUtils.sleep(1);
    }
    
    public void clickMenuAccessibilityNodeQuerying() {
    	gui.click("accessibilityId", "Accessibility Node Querying");
    	TestUtils.sleep(1);
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void clickMenuAccessibilityNodeProvider() {
    	gui.click("accessibilityId", "Accessibility Node Provider");
    	TestUtils.sleep(1);
    }

    public void clickMenuAccessibilityService() {
    	gui.click("accessibilityId", "Accessibility Service");
    	TestUtils.sleep(1);
    }

    public void clickMenuCustomView() {
    	gui.click("accessibilityId", "Custom View");
    	TestUtils.sleep(1);
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void checkTakeOutTrash(){
    	driver.findElement(chkTakeOutTrash).click();
    	TestUtils.sleep(1);
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
    	TestUtils.sleep(1);
    }

    public boolean stateNap(){
    	return Boolean.parseBoolean(driver.findElement(chkNap).getAttribute("checked"));
    }

    public void clickButton() {
    	driver.findElement(button).click();
    }
}
