package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.TextPage;

public class TextTest extends BaseTest{
	
	TextPage page = new TextPage(BaseTest.getDriver());
	
    @Test
    public void testKeyEventText(JsonNode obj) throws Exception {
    	
        System.out.println("Click on 'Text'");
        page.clickMenuText();
        System.out.println("Click on 'KeyEventText'");
        page.clickMenuKeyEventText();
        System.out.println("Click on 'text box' and enter 'Hello World'");
        page.setTextBoxKeyEvent("Hello World");
        
        System.out.println("get text written in 'text box' and verify");
        String actText = page.getTextBoxKeyEvent();
        String expText = "Hello World";
        Assert.assertEquals(actText, expText, "Verify TextBox data");
        
        System.out.println("Click on 'CLEAR' Button");
        page.clickButtonClear();

        System.out.println("get text written in 'text box' and verify");
        actText = page.getTextBoxKeyEvent();
        expText = "";
        Assert.assertEquals(actText, expText, "Verify TextBox data");
    }

}
