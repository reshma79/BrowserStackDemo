package tests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import base.BaseTest;
import utils.TestUtils;

public class Runner extends BaseTest{

    @DataProvider(name = "data")
    public Object[] getData() throws IOException {
    	String excelFile = "C:\\RSP\\EclipseProjects\\BrowserStackDemo\\AppData.xlsx";
    	String jsonFile = "C:\\RSP\\EclipseProjects\\BrowserStackDemo\\AppData.json";
    	
    	TestUtils.excelToJSONConverter(excelFile,jsonFile);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
        List<Map<String, String>> data = mapper.readValue(new File(jsonFile), new TypeReference<List<Map<String,String>>>() {});
        
        Object[] obj = new Object[data.size()];

        for (int i = 0; i < data.size(); i++) {
        	obj[i] = mapper.valueToTree(data.get(i));
        }
        return obj;
    }
    
    
    @Test (dataProvider = "data")
	public void executionEngine(Object obj) {
    try {
    	JsonNode objJSON = (JsonNode) obj;
    	String executeFlag = objJSON.get("Execute").asText();
    	if(executeFlag.equals("Y")) {
    		String menu = objJSON.get("Menu_1").asText();
    		switch(menu) {
    		case "Accessibility":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Animation":
    		{
    			executeAnimation(objJSON);
    			break;
    		}
    		case "App":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Content":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Graphics":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Media":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "NFC":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "OS":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Preference":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		case "Text":
    		{
    			executeText(objJSON);
    			break;
    		}
    		case "Views":
    		{
    			executeAccessibility(objJSON);
    			break;
    		}
    		default:
    		{
    			System.err.println("Menu '"+menu+"' not found or implemented");
    			break;
    		}
    		}
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    	System.err.println("In the Exception of @Test method");
    }
    
    }
	
    private void executeAccessibility(JsonNode obj) {

    	AccessibilityTest objAT = new AccessibilityTest();

    	String menu = obj.get("Menu_2").asText();
    	switch(menu) {
    	case "Accessibility Node Querying":
    	{
    		objAT.testAccessibilityNodeQuerying(obj);
    		break;
    	}
    	case "Accessibility Node Provider":
    	{
    		objAT.testAccessibilityNodeProvider(obj);
    		break;
    	}
    	case "Accessibility Service":
    	{
    		objAT.testAccessibilityService(obj);
    		break;
    	}
    	case "Custom View":
    	{
    		objAT.testCustomView(obj);
    		break;
    	}
    	default:
    	{
    		System.err.println("Menu '"+menu+"' not found or implemented");
    	}
    	}
    }

    private void executeAnimation(JsonNode obj) throws Exception {

    	AnimationTest objAT = new AnimationTest();

    	String menu = obj.get("Menu_2").asText();
    	switch(menu) {
    	case "":
    	{
    		objAT.testAnimation(obj);
    		break;
    	}
    	default:
    	{
    		System.err.println("Menu '"+menu+"' not found or implemented");
    	}
    	}
    }

    private void executeText(JsonNode obj) throws Exception {

    	TextTest objTT = new TextTest();

    	String menu = obj.get("Menu_2").asText();
    	switch(menu) {
    	case "KeyEventText":
    	{
    		objTT.testKeyEventText(obj);
    		break;
    	}
    	default:
    	{
    		System.err.println("Menu '"+menu+"' not found or implemented");
    	}
    	}
    }
}
