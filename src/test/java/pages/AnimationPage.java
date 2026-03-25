package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;
import utils.TestUtils;

public class AnimationPage {

	AndroidDriver driver;
	GUIActions gui;

    private By chkTakeOutTrash = AppiumBy.xpath("//android.widget.TextView[@text='Take out Trash']/following-sibling::android.widget.CheckBox");

	
	public AnimationPage(AndroidDriver driver) {
		this.driver = driver;
		gui = new GUIActions(driver);
	}

    public void clickMenuAnimation() {
    	gui.click("xpath", "//android.widget.TextView[@text='Animation']");
    	TestUtils.sleep(1);
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();

    }
    
    

}
