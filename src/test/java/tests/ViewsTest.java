package tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import base.BaseTest;
import pages.ViewsPage;

public class ViewsTest {

	ViewsPage page = new ViewsPage(BaseTest.getDriver());

	public void testExecute(JsonNode obj) {
	try {
		page.clickMenu(obj.get("Menu_1").asText(), obj.get("Menu_2").asText(), obj.get("Menu_3").asText());
		
		ArrayNode objSteps = (ArrayNode) obj.get("steps");
		
		for(JsonNode step : objSteps) {
			switch (step.get("Action").asText()) {
			case "verify": {
				page.verifyObject(step.get("LocatorType").asText(), step.get("LocatorValue").asText(), 
								step.get("Verification_Attribute").asText(), step.get("Verification_Data").asText());
				break;
			}
			case "click": {
				page.click(step.get("LocatorType").asText(), step.get("LocatorValue").asText());
				break;
			}
			case "drag": {
				page.drag(step.get("LocatorType").asText(), step.get("LocatorValue").asText(),step.get("Input_Data").asText());
				break;
			}
			default:{
				throw new IllegalArgumentException("Unexpected value: " + step.get("Action").asText());
			}
			}
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
