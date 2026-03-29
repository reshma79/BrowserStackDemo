package tests;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.AppPage;

public class AppTest {

	AppPage page = new AppPage(BaseTest.getDriver());

    public void navigateBack() {
    	page.navigateBack();
    	System.out.println("navigate back called from Test");
    }

    public void menuApp(JsonNode obj) {
    	page.clickMenuApp();
    	page.pageSource();
    	page.clickMenuAppMenu("Action Bar");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Activity");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Alarm");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Alert Dialogs");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Device Admin");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Fragment");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Launcher Shortcuts");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Loader");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Menu");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Notification");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Search");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Service");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Text-To-Speech");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuAppMenu("Voice Recognition");
    	page.pageSource();
    	navigateBack();
    	
    }
}
