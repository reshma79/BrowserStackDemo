package base;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    static AndroidDriver driver;
    DesiredCapabilities caps = new DesiredCapabilities();

    public static AndroidDriver getDriver() {
		return driver;
	}
    //For BrowserStack website
	@BeforeTest
    public void setup() throws Exception {

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("os_version", "12");

        //LocalSample.apk downloaded from BrowserStack
//        caps.setCapability("app", "bs://05aaabbab3c79bd4db919b0ba1eafcc7ec7ab76f");
        
        //ApiDemos-debug.apk suggested by chatGPT
        caps.setCapability("app", "bs://d321d2e2e733ab8194141d987d0e027bfdf4f4a8");

        //in.marketpulse_8.0.52.apk - a stock market app
//        caps.setCapability("app", "bs://c69f933964c62ab50e296495c29fb4a3c76d7273");
        
        caps.setCapability("project", "Appium Demo");
        caps.setCapability("build", "Build 2");
        caps.setCapability("name", "Sample Test");

        driver = new AndroidDriver(
                URI.create("https://reshmapikle_2HMFvc:5jxcqC2dNJy2v5Spbe4o@hub.browserstack.com/wd/hub").toURL(),
                caps);
        System.out.println("App launched successfully");

    }

/*    
    //For BlueStacks
	@BeforeTest
    public void setup() throws Exception {

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "BlueStacks");
        caps.setCapability("udid", "127.0.0.1:5555");
        caps.setCapability("appPackage", "com.example.app");
        caps.setCapability("appActivity", "com.example.app.MainActivity");
        caps.setCapability("noReset", true);
        caps.setCapability("automationName", "UiAutomator2");

        AndroidDriver driver = new AndroidDriver(URI.create("http://127.0.0.1:4723/wd/hub").toURL(), caps);
        
        System.out.println("App launched successfully");

    }
*/	
	
//	@BeforeMethod
	public void launchApp() throws Exception{
        driver = new AndroidDriver(
                URI.create("https://reshmapikle_2HMFvc:5jxcqC2dNJy2v5Spbe4o@hub.browserstack.com/wd/hub").toURL(),
                caps);
        System.out.println("App launched successfully");
//        driver.executeScript("mobile: shell", Map.of(
//        	    "command", "settings",
//        	    "args", List.of("put", "secure", "accessibility_enabled", "1")
//        	));
	}

	@AfterTest
    public void tearDown() throws Exception {
    	System.out.println("App Quit called in @AfterTest");
        driver.quit();
    }

//    @AfterMethod
//    public void navigateBack() {
//    	System.out.println("App Restarted");
//	    driver.terminateApp("io.appium.android.apis");
//	    driver.activateApp("io.appium.android.apis");
//	    driver.closeApp();
//	    driver.launchApp();
//    	System.out.println("navigate back called in @AfterMethod");
//        driver.navigate().back();
//	}

    
}
