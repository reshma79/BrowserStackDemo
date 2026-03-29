package pages;

import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;
import utils.TestUtils;

public class ContentPage {

	AndroidDriver driver;
	GUIActions gui;

	public ContentPage(AndroidDriver driver) {
		this.driver = driver;
		gui = new GUIActions(driver);
	}

    public void navigateBack() {
    	driver.navigate().back();
    	System.out.println("navigate back called from page");
    }

    public void pageSource() {
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void clickMenuContent() {
    	gui.click("xpath", "//android.widget.TextView[@text='Content']");
    	TestUtils.sleep(1);
    }

    public void clickMenuContentMenu(String menu) {
    	gui.click("accessibilityId", menu);
    }

}
