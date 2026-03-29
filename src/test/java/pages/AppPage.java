package pages;

import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;
import utils.TestUtils;

public class AppPage {

	AndroidDriver driver;
	GUIActions gui;

	public AppPage(AndroidDriver driver) {
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

    public void clickMenuApp() {
    	gui.click("xpath", "//android.widget.TextView[@text='App']");
    	TestUtils.sleep(1);
    }

    public void clickMenuAppMenu(String menu) {
    	gui.click("accessibilityId", menu);
    }
}
