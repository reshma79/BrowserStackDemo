package tests;

import com.fasterxml.jackson.databind.JsonNode;

import base.BaseTest;
import pages.AnimationPage;

public class AnimationTest {

	AnimationPage page = new AnimationPage(BaseTest.getDriver());

	public void testAnimation(JsonNode obj) {
		
		page.clickMenuAnimation();
	}
}
