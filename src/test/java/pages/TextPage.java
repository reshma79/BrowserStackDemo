package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.GUIActions;
import utils.TestUtils;

public class TextPage {

	AndroidDriver driver;
	GUIActions gui;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Text']")
    private WebElement menuText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='KeyEventText']")
    private WebElement menuKeyEventText;
    
    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    private WebElement textBoxKeyEvent;

    @AndroidFindBy(accessibility = "Clear")
    private WebElement buttonClear;
    
	public TextPage(AndroidDriver driver) {
//		super();
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		gui = new GUIActions(driver);
	}

    public void clickMenuText() {
    	
    	gui.click("xpath", "//android.widget.TextView[@text='Text']");

    	TestUtils.sleep(1);
    	
    	String pageSource = driver.getPageSource();
    	System.out.println(pageSource);
    	System.out.println();

//    	menuText.click();
    	TestUtils.sleep(1);
    }

    public void clickMenuKeyEventText() {
    	gui.click("xpath", "//android.widget.TextView[@text='KeyEventText']");
//    	menuKeyEventText.click();
    	TestUtils.sleep(1);
    }

    public void setTextBoxKeyEvent(String text) {
    	menuKeyEventText.sendKeys(text);
    	TestUtils.sleep(1);
    }

    public String getTextBoxKeyEvent() {
    	TestUtils.sleep(1);
    	return menuKeyEventText.getText();
    }

    public void clickButtonClear() {
    	buttonClear.click();
    	TestUtils.sleep(1);
    }
    
    
}
