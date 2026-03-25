package tests;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.AccessibilityPage;

public class AccessibilityTest {

	AccessibilityPage page = new AccessibilityPage(BaseTest.getDriver());
	
	public void testAccessibilityNodeQuerying(JsonNode obj) {
		
        System.out.println("Click on 'Accessibility'");
        page.clickMenuAccessibility();

        System.out.println("Click on 'Accessibility Node Querying'");
        page.clickMenuAccessibilityNodeQuerying();

        String input = obj.get("Input_1").asText();
        String[] arrInput = input.split(",");
        for(int i=0; i<arrInput.length; i++) {
        	String element = arrInput[i].trim();
	        System.out.println("Select '"+element+"'");
        	switch (element) {
			case "Take out Trash": {
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            break;
			}
			case "Do Laundry": {
		        System.out.println("'"+element+"' = "+page.stateDoLaundry());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateDoLaundry());
	            break;
			}
			case "Conquer World": {
		        System.out.println("'Conquer World' = "+page.stateConquerWorld());
	            page.checkConquerWorld();
		        System.out.println("'Conquer World' = "+page.stateConquerWorld());
	            break;
			}
			case "Nap": {
		        System.out.println("'"+element+"' = "+page.stateNap());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateNap());
	            break;
			}
			case "Do Taxes": {
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            break;
			}
			case "Abolish IRS": {
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            break;
			}
			case "Tea with Aunt Sharon": {
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            page.checkTakeOutTrash();
		        System.out.println("'"+element+"' = "+page.stateTakeOutTrash());
	            break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + element);
			}
        }
        
	}
	
	public void testAccessibilityNodeProvider(JsonNode obj) {
		
        System.out.println("Click on 'Accessibility'");
        page.clickMenuAccessibility();

        System.out.println("Click on 'Accessibility Node Provider'");
        page.clickMenuAccessibilityNodeProvider();
        
	}
	
	public void testAccessibilityService(JsonNode obj) {

        System.out.println("Click on 'Accessibility'");
        page.clickMenuAccessibility();

        System.out.println("Click on 'Accessibility Service'");
        page.clickMenuAccessibilityService();
        
        

	}

	public void testCustomView(JsonNode obj) {

        System.out.println("Click on 'Accessibility'");
        page.clickMenuAccessibility();

        System.out.println("Click on 'Custom View'");
        page.clickMenuCustomView();

	}

}
