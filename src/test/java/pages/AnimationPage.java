package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.GUIActions;
import utils.TestUtils;

public class AnimationPage {

	AndroidDriver driver;
	GUIActions gui;

    private By btnRun = AppiumBy.accessibilityId("Run");

    private By btnPlay = AppiumBy.accessibilityId("Play");

    private By btnAdd = AppiumBy.accessibilityId("Add Button");

    private By btnCancel = AppiumBy.accessibilityId("Cancel");

    private By btnEnd = AppiumBy.accessibilityId("End");

    private By btnShow = AppiumBy.accessibilityId("Show Buttons");

    private By btnReverse = AppiumBy.accessibilityId("Reverse");

    private By btnFlip = AppiumBy.accessibilityId("Flip");

    private By btn_0 = AppiumBy.xpath("//android.widget.Button[@text='0']");

    private By btn_1 = AppiumBy.xpath("//android.widget.Button[@text='1']");

    private By btn_2 = AppiumBy.xpath("//android.widget.Button[@text='2']");

    private By btn_3 = AppiumBy.xpath("//android.widget.Button[@text='3']");

    private By chkEndImmediately = AppiumBy.accessibilityId("End Immediately");

    private By chkCustomAnimations = AppiumBy.accessibilityId("Custom Animations");

    private By chkHideGONE = AppiumBy.accessibilityId("Hide (GONE)");

    private By chkIn = AppiumBy.accessibilityId("In");
    private By chkOut = AppiumBy.accessibilityId("Out");
    private By chkChangingIn = AppiumBy.accessibilityId("Changing-In");
    private By chkChangingOut = AppiumBy.accessibilityId("Changing-Out");

    private By seekBar = AppiumBy.id("io.appium.android.apis:id/seekBar");
    
	public AnimationPage(AndroidDriver driver) {
		this.driver = driver;
		gui = new GUIActions(driver);
	}

    public void navigateBack() {
    	driver.navigate().back();
    	System.out.println("navigate back called from page");
    }

    public void clickMenuAnimation() {
    	gui.click("xpath", "//android.widget.TextView[@text='Animation']");
    	TestUtils.sleep(1);
    }
    
    public void clickMenuAnimationPage(String menu) {
    	gui.click("accessibilityId", menu);
    	TestUtils.sleep(1);
    	
    }
    
    public void clickRun() {
    	driver.findElement(btnRun).click();
    }
    
    public void clickPlay() {
    	driver.findElement(btnPlay).click();
    }

    public void clickReverse() {
    	driver.findElement(btnReverse).click();
    }

    public void clickAdd() {
    	driver.findElement(btnAdd).click();
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void clickCancel() {
    	driver.findElement(btnCancel).click();
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void clickEnd() {
    	driver.findElement(btnEnd).click();
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void chkEndImmediately() {
    	driver.findElement(chkEndImmediately).click();
    }

    public void clickShow() {
    	driver.findElement(btnShow).click();
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void clickBtn_0() {
    	driver.findElement(btn_0).click();
    }

    public void clickBtn_1() {
    	driver.findElement(btn_1).click();
    }

    public void clickBtn_2() {
    	driver.findElement(btn_2).click();
    }

    public void clickBtn_3() {
    	driver.findElement(btn_3).click();
    }

    public void chkCustomAnimations() {
    	driver.findElement(chkCustomAnimations).click();
    }

    public void chkHideGONE() {
    	driver.findElement(chkHideGONE).click();
    }

    public void chkIn() {
    	driver.findElement(chkIn).click();
    }
    public void chkOut() {
    	driver.findElement(chkOut).click();
    }
    public void chkChangingIn() {
    	driver.findElement(chkChangingIn).click();
    }
    public void chkChangingOut() {
    	driver.findElement(chkChangingOut).click();
    }
    
    public String getSeekBarValue() {
    	return driver.findElement(seekBar).getAttribute("Text");
    }
    
    public void clickFlip() {
    	driver.findElement(btnFlip).click();
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();
    }

    public void selectList(int index) {
    	driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='io.appium.android.apis:id/list_fr']/following::android.widget.TextView["+index+"]")).click();
    }
    
    public String getText(int index) {
    	return driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id='io.appium.android.apis:id/list_fr']/following::android.widget.TextView["+index+"]")).getText();
    }

}
