import java.net.URI;
import java.util.List;
//import java.net.URL;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BrowserStackAppiumTest {

    AndroidDriver driver;
    
//    @BeforeTest
    public void setup() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S22");
        caps.setCapability("os_version", "12");

        //LocalSample.apk downloaded from BrowserStack
        caps.setCapability("app", "bs://05aaabbab3c79bd4db919b0ba1eafcc7ec7ab76f");
        
        //ApiDemos-debug.apk suggested by chatGPT
        caps.setCapability("app", "bs://d321d2e2e733ab8194141d987d0e027bfdf4f4a8");

        //in.marketpulse_8.0.52.apk - a stock market app
        caps.setCapability("app", "bs://c69f933964c62ab50e296495c29fb4a3c76d7273");
        
        caps.setCapability("project", "Appium Demo");
        caps.setCapability("build", "Build 1");
        caps.setCapability("name", "Sample Test");

//        driver = new AndroidDriver(
//                new URL("https://reshmapikle_2HMFvc:5jxcqC2dNJy2v5Spbe4o@hub.browserstack.com/wd/hub"),
//                caps);
        driver = new AndroidDriver(
                URI.create("https://reshmapikle_2HMFvc:5jxcqC2dNJy2v5Spbe4o@hub.browserstack.com/wd/hub").toURL(),
                caps);
        System.out.println("App launched successfully");


    }
    
//    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
    
//    @Test
    public void testApp() throws Exception {
        // Get current page source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        /*
        //LocalSample.apk
        //Getting text from the object displayed on screen
        String textName = driver.findElement(By.className("android.widget.TextView")).getText();
        Assert.assertEquals("textName : ", textName);
        */

        //ApiDemos-debug.apk
        int link = 2;
        
        if(link==1) {
        	
        System.out.println("Click on 'Text'");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Text']")).click();
        Thread.sleep(500);

        pageSource = driver.getPageSource();
        System.out.println(pageSource);

        System.out.println("Click on 'KeyEventText'");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='KeyEventText']")).click();
        Thread.sleep(500);
        
        System.out.println("Click on 'text box' and enter 'Hello World'");
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/text")).sendKeys("Hello World");
        Thread.sleep(500);
        
        System.out.println("get text written in 'text box' and verify");
        String actText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/text")).getText();
        Thread.sleep(500);
        String expText = "Hello World";
        Assert.assertEquals(actText, expText, "Verify TextBox data");
        
        System.out.println("Click on 'CLEAR' Button");
        driver.findElement(AppiumBy.accessibilityId("Clear")).click();
        Thread.sleep(500);

        System.out.println("get text written in 'text box' and verify");
        actText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/text")).getText();
        Thread.sleep(500);
        expText = "";
        Assert.assertEquals(actText, expText, "Verify TextBox data");

        System.out.println("Back to previous page");
        Thread.sleep(2000);
        driver.navigate().back();
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.executeScript("mobile: pressButton", Map.of("name","back"));
//        driver.executeScript("mobile: shell", Map.of(
//        	    "command", "input",
//        	    "args", List.of("keyevent", "4")
//        	));
        Thread.sleep(2000);
        driver.navigate().back();
//        driver.pressKey(new KeyEvent(AndroidKey.BACK));
//        driver.executeScript("mobile: pressButton", Map.of("name","back"));
//        driver.executeScript("mobile: shell", Map.of(
//        	    "command", "input",
//        	    "args", List.of("keyevent", "4")
//        	));
        Thread.sleep(500);
        
        pageSource = driver.getPageSource();
        System.out.println(pageSource);
        
        }else if(link==2){
        	
        System.out.println("Click on 'Accessibility'");
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Accessibility']")).click();
        Thread.sleep(100);

        System.out.println("Click on 'Accessibility Node Querying'");
        driver.findElement(AppiumBy.accessibilityId("Accessibility Node Querying") ).click();
        Thread.sleep(100);

        pageSource = driver.getPageSource();
        System.out.println(pageSource);

        System.out.println("Select 'Take out Trash'");
        WebElement checkbox = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Take out Trash']/following-sibling::android.widget.CheckBox"));
        System.out.println("'Take out Trash' = "+checkbox.getAttribute("checked"));
        
        if(checkbox.getAttribute("checked").equals("false")) {
            checkbox.click();
        }
        Thread.sleep(100);
        System.out.println("'Take out Trash' = "+checkbox.getAttribute("checked"));
        
        System.out.println("Select 'Conquer World'");
        checkbox = driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@text='Conquer World']/following-sibling::android.widget.CheckBox"));
        System.out.println("'Conquer World' = "+checkbox.getAttribute("checked"));
        
        if(checkbox.getAttribute("checked").equals("false")) {
            checkbox.click();
        }
        System.out.println("'Conquer World' = "+checkbox.getAttribute("checked"));
        
        Thread.sleep(100);
        
//        System.out.println("Click on the button");
//        driver.findElement(AppiumBy.id("io.appium.android.apis:id/button")).click();
//        Thread.sleep(100);
        
        pageSource = driver.getPageSource();
        System.out.println(pageSource);

        }else if(link==3){
        	
        }
    }

}