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
    	String excelFile = "C:\\RSP\\EclipseProjects\\BrowserStackDemo\\APIDemoTestData.xlsx";
    	String jsonFile = "C:\\RSP\\EclipseProjects\\BrowserStackDemo\\APIDemoTestData.json";
    	
    	TestUtils.excelToJSONConverter(excelFile,jsonFile);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	
        List<Map<String, Object>> data = mapper.readValue(new File(jsonFile), new TypeReference<List<Map<String,Object>>>() {});
        
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
    			executeApp(objJSON);
    			break;
    		}
    		case "Content":
    		{
    			executeContent(objJSON);
    			break;
    		}
    		case "Graphics":
    		{
    			executeGraphics(objJSON);
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
    			executeViews(objJSON);
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

    	AccessibilityTest objTest = new AccessibilityTest();

    	objTest.testExecute(obj);
    	
    }

    private void executeViews(JsonNode obj) {

    	ViewsTest objTest = new ViewsTest();

    	objTest.testExecute(obj);
    }
    
    private void executeAnimation(JsonNode obj) throws Exception {

    	AnimationTest objAT = new AnimationTest();

    	String menu = obj.get("Menu_2").asText();
    	switch(menu) {
    	case "Bouncing Balls":
    	{
    		objAT.testBouncingBalls(obj);
    		break;
    	}
    	case "Cloning":
    	{
    		objAT.testCloning(obj);
    		break;
    	}
    	case "Custom Evaluator":
    	{
    		objAT.testCustomEvaluator(obj);
    		break;
    	}
    	case "Default Layout Animations":
    	{
    		objAT.testDefaultLayoutAnimations(obj);
    		break;
    	}
    	case "Events":
    	{
    		objAT.testEvents(obj);
    		break;
    	}
    	case "Hide-Show Animations":
    	{
    		objAT.testHideShowAnimations(obj);
    		break;
    	}
    	case "Layout Animations":
    	{
    		objAT.testLayoutAnimations(obj);
    		break;
    	}
    	case "Loading":
    	{
    		objAT.testLoading(obj);
    		break;
    	}
    	case "Multiple Properties":
    	{
    		objAT.testMultipleProperties(obj);
    		break;
    	}
    	case "Reversing":
    	{
    		objAT.testReversing(obj);
    		break;
    	}
    	case "Seeking":
    	{
    		objAT.testSeeking(obj);
    		break;
    	}
    	case "View Flip":
    	{
    		objAT.testViewFlip(obj);
    		break;
    	}
    	default:
    	{
    		System.err.println("Menu '"+menu+"' not found or implemented");
    	}
    	}
    	objAT.navigateBack();
    }

    private void executeContent(JsonNode obj) throws Exception {

    	ContentTest objAT = new ContentTest();

    	objAT.menuContent(obj);
    	objAT.navigateBack();
    	
    }
    
    private void executeApp(JsonNode obj) throws Exception {

    	AppTest objAT = new AppTest();

    	objAT.menuApp(obj);
    	objAT.navigateBack();
    }

    private void executeGraphics(JsonNode obj) throws Exception {

    	GraphicsTest objAT = new GraphicsTest();

    	objAT.menuGraphics(obj);
    	objAT.navigateBack();
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
