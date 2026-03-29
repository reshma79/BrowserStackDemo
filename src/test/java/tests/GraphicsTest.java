package tests;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.GraphicsPage;

public class GraphicsTest {

	GraphicsPage page = new GraphicsPage(BaseTest.getDriver());

    public void navigateBack() {
    	page.navigateBack();
    	System.out.println("navigate back called from Test");
    }

    public void menuGraphics(JsonNode obj) {
    	page.clickMenuGraphics();
    	page.pageSource();
    }
}
