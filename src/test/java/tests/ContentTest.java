package tests;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.ContentPage;

public class ContentTest {

	ContentPage page = new ContentPage(BaseTest.getDriver());

    public void navigateBack() {
    	page.navigateBack();
    	System.out.println("navigate back called from Test");
    }

    public void menuContent(JsonNode obj) {
    	page.clickMenuContent();
    	page.pageSource();
    	page.clickMenuContentMenu("Assets");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuContentMenu("Clipboard");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuContentMenu("Packages");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuContentMenu("Provider");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuContentMenu("Resources");
    	page.pageSource();
    	navigateBack();
    	page.clickMenuContentMenu("Storage");
    	page.pageSource();
    	navigateBack();
    }
    
    
}
