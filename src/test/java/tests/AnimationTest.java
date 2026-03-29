package tests;

import org.testng.Assert;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.AnimationPage;
import utils.TestUtils;

public class AnimationTest {

	AnimationPage page = new AnimationPage(BaseTest.getDriver());

    public void navigateBack() {
    	page.navigateBack();
    	System.out.println("navigate back called from Test");
    }

	public void testBouncingBalls(JsonNode obj) {
		
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());
		
		page.navigateBack();
	}
	
	public void testCloning(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());
		
		page.clickRun();

		page.navigateBack();
	}
	
	public void testCustomEvaluator(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickPlay();

		page.navigateBack();
	}
	
	public void testDefaultLayoutAnimations(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickAdd();

		page.navigateBack();
	}
	
	public void testEvents(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickPlay();
		
		page.clickCancel();
		
		page.clickEnd();
		
		page.chkEndImmediately();

		page.clickEnd();

		page.navigateBack();
	}
	
	public void testHideShowAnimations(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickShow();
		
		page.chkCustomAnimations();
		
		page.chkHideGONE();
		
		page.clickBtn_0();
		page.clickBtn_1();
		page.clickBtn_2();
		page.clickBtn_3();
		
		page.navigateBack();
	}
	
	public void testLayoutAnimations(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickAdd();
		page.chkCustomAnimations();
		page.chkIn();
		page.chkOut();
		page.chkChangingIn();
		page.chkChangingOut();
		
		page.navigateBack();
	}
	
	public void testLoading(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickRun();
		
		page.navigateBack();
	}
	
	public void testMultipleProperties(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickRun();
		
		page.navigateBack();
	}
	
	public void testReversing(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickPlay();
		page.clickReverse();
		
		page.navigateBack();
	}
	
	public void testSeeking(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		page.clickRun();
		TestUtils.sleep(200);
		String seekBaarValue = page.getSeekBarValue();
		
		System.out.println("Seek Bar Value = "+seekBaarValue);
		
		page.navigateBack();
	}
	
	public void testViewFlip(JsonNode obj) {
		page.clickMenuAnimation();
		
		page.clickMenuAnimationPage(obj.get("Menu_2").asText());

		String text_One = page.getText(1);
		String text_Two = page.getText(2);
		
		page.clickFlip();
		
		Assert.assertEquals(text_Two, page.getText(1), "Text at Position 1");
		Assert.assertEquals(text_One, page.getText(2), "Text at Position 2");
		
		page.navigateBack();
	}

}
