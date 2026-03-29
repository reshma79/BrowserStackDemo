package utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GUIActions {

	public GUIActions(AndroidDriver driver) {
		this.driver = driver;
	}

	AndroidDriver driver;

	public WebElement findElement(String locatorType, String locatorValue) {

		WebElement wElement = null;
		switch(locatorType) {
		case "id" :
		{
			wElement = driver.findElement(AppiumBy.id(locatorValue));
			break;
		}
		case "class" :
		{
			wElement = driver.findElement(AppiumBy.className(locatorValue));
			break;
		}
		case "name" :
		{
			wElement = driver.findElement(AppiumBy.name(locatorValue));
			break;
		}
		case "accessibilityId" :
		{
			wElement = driver.findElement(AppiumBy.accessibilityId(locatorValue));
			break;
		}
		case "xpath" :
		{
			wElement = driver.findElement(AppiumBy.xpath(locatorValue));
			break;
		}
		case "coordinate" :
		{
			wElement = driver.findElement(AppiumBy.c );
			break;
		}
		default :
		{
			System.err.println("Locator Type = "+locatorType+" with Value = "+locatorValue+" does not exists");
			break;
		}
		}
		return wElement;
	}
	
	public void click(String locatorType, String locatorValue) {
		System.out.println("Click on "+locatorValue);
		findElement(locatorType, locatorValue).click();
	}

	public void type(String locatorType, String locatorValue, String value) {
		System.out.println("Type in "+locatorValue+ " = "+value);
		findElement(locatorType, locatorValue).sendKeys(value);;
	}

	public String getText(String locatorType, String locatorValue) {
		System.out.println("Click on "+locatorValue);
		return findElement(locatorType, locatorValue).getText();
	}

	public String getAttribute(String locatorType, String locatorValue, String attribute) {
		System.out.println("Click on "+locatorValue);
		return findElement(locatorType, locatorValue).getAttribute(attribute);
	}

	public void drag(String locatorType, String locatorValue, String coordinates) {

		WebElement source = findElement(locatorType, locatorValue);
		
		int varX = Integer.parseInt(coordinates.substring(0, coordinates.indexOf(',')));
		int varY = Integer.parseInt(coordinates.substring(coordinates.indexOf(',')));
		
		int startX = source.getLocation().getX() + (source.getSize().width / 2);
		int startY = source.getLocation().getY() + (source.getSize().height / 2);

		int endX = startX + varX;
		int endY = startY + varY;

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence drag = new Sequence(finger, 1);

		drag.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX, startY));

		drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

		drag.addAction(finger.createPointerMove(Duration.ofMillis(700),	PointerInput.Origin.viewport(), endX, endY));

		drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(drag));
	}
}
