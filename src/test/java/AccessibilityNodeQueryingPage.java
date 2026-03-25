//
//package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AccessibilityNodeQueryingPage {

    private AndroidDriver driver;

    public AccessibilityNodeQueryingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By taskLabel = AppiumBy.id("io.appium.android.apis:id/tasklist_label");
    private By taskCheckbox = AppiumBy.id("io.appium.android.apis:id/tasklist_finished");
    private By addButton = AppiumBy.id("io.appium.android.apis:id/button");

    // Click Add Button
    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    // Get checkbox element by task name
    private WebElement getTaskCheckbox(String taskName) {
        String xpath = "//android.widget.TextView[@text='" + taskName +
                "']/following-sibling::android.widget.CheckBox";
        return driver.findElement(AppiumBy.xpath(xpath));
    }

    // Check if task is completed
    public boolean isTaskCompleted(String taskName) {
        return Boolean.parseBoolean(getTaskCheckbox(taskName).getAttribute("checked"));
    }

    // Mark task as completed
    public void markTaskCompleted(String taskName) {
        WebElement checkbox = getTaskCheckbox(taskName);
        if (!Boolean.parseBoolean(checkbox.getAttribute("checked"))) {
            checkbox.click();
        }
    }

    // Unmark task
    public void unmarkTask(String taskName) {
        WebElement checkbox = getTaskCheckbox(taskName);
        if (Boolean.parseBoolean(checkbox.getAttribute("checked"))) {
            checkbox.click();
        }
    }

}

