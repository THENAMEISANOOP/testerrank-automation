package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccordionsTabsPage;
import pages.TopicsPage;

public class AccordionsTabsTest extends BaseTest {

	private AccordionsTabsPage accordionsTabsPage;

	@BeforeMethod
	public void openAccordionsTabsPage() {

		TopicsPage topicsPage = new TopicsPage(driver);

		topicsPage.clickAccordionsTabs();

		accordionsTabsPage = new AccordionsTabsPage(driver);
	}

	@Test(priority = 1)
	public void verifyAllAccordionsOpen() {

		accordionsTabsPage.clickAccordion1();

		String output1 = accordionsTabsPage.getExercise1Output();

		System.out.println("Accordion 1 Output: " + output1);

		Assert.assertEquals(output1, "Open items: 1");

		accordionsTabsPage.clickAccordion2();

		String output2 = accordionsTabsPage.getExercise1Output();

		System.out.println("Accordion 2 Output: " + output2);

		Assert.assertEquals(output2, "Open items: 2");

		accordionsTabsPage.clickAccordion3();

		String output3 = accordionsTabsPage.getExercise1Output();

		System.out.println("Accordion 3 Output: " + output3);

		Assert.assertEquals(output3, "Open items: 3");

		accordionsTabsPage.clickAccordion4();

		String output4 = accordionsTabsPage.getExercise1Output();

		System.out.println("Accordion 4 Output: " + output4);

		Assert.assertEquals(output4, "Open items: 4");
	}

	@Test(priority = 2)
	public void verifyExclusiveAccordionBehavior() {

		String initialOutput = accordionsTabsPage.getExercise2Output();

		System.out.println("Initial Output: " + initialOutput);

		Assert.assertEquals(initialOutput, "Open item: None");

		accordionsTabsPage.clickExclusiveAccordion1();

		String output1 = accordionsTabsPage.getExercise2Output();

		System.out.println("After Accordion 1: " + output1);

		Assert.assertEquals(output1, "Open item: 1");

		accordionsTabsPage.clickExclusiveAccordion2();

		String output2 = accordionsTabsPage.getExercise2Output();

		System.out.println("After Accordion 2: " + output2);

		Assert.assertEquals(output2, "Open item: 2");

		accordionsTabsPage.clickExclusiveAccordion3();

		String output3 = accordionsTabsPage.getExercise2Output();

		System.out.println("After Accordion 3: " + output3);

		Assert.assertEquals(output3, "Open item: 3");

		accordionsTabsPage.clickExclusiveAccordion4();

		String output4 = accordionsTabsPage.getExercise2Output();

		System.out.println("After Accordion 4: " + output4);

		Assert.assertEquals(output4, "Open item: 4");
	}

	@Test(priority = 3)
	public void verifyExclusiveAccordionCanBeClosed() {

		accordionsTabsPage.clickExclusiveAccordion1();

		String openOutput = accordionsTabsPage.getExercise2Output();

		System.out.println("After Opening: " + openOutput);

		Assert.assertEquals(openOutput, "Open item: 1");

		accordionsTabsPage.clickExclusiveAccordion1();

		String closeOutput = accordionsTabsPage.getExercise2Output();

		System.out.println("After Closing: " + closeOutput);

		Assert.assertEquals(closeOutput, "Open item: None");
	}

	@Test(priority = 4)
	public void verifyHorizontalTabs() {

		String initialOutput = accordionsTabsPage.getExercise3Output();

		System.out.println("Initial Tab: " + initialOutput);

		Assert.assertEquals(initialOutput, "Active tab: Overview");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(1), "true");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(2), "false");

		accordionsTabsPage.clickTab2();

		String featuresOutput = accordionsTabsPage.getExercise3Output();

		System.out.println("After Features: " + featuresOutput);

		Assert.assertEquals(featuresOutput, "Active tab: Features");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(1), "false");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(2), "true");

		accordionsTabsPage.clickTab3();

		String pricingOutput = accordionsTabsPage.getExercise3Output();

		System.out.println("After Pricing: " + pricingOutput);

		Assert.assertEquals(pricingOutput, "Active tab: Pricing");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(2), "false");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(3), "true");

		accordionsTabsPage.clickTab4();

		String reviewsOutput = accordionsTabsPage.getExercise3Output();

		System.out.println("After Reviews: " + reviewsOutput);

		Assert.assertEquals(reviewsOutput, "Active tab: Reviews");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(3), "false");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(4), "true");

		// Click Overview again
		accordionsTabsPage.clickTab1();

		String overviewOutput = accordionsTabsPage.getExercise3Output();

		System.out.println("After Overview: " + overviewOutput);

		Assert.assertEquals(overviewOutput, "Active tab: Overview");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(4), "false");

		Assert.assertEquals(accordionsTabsPage.getTabSelectedState(1), "true");
	}

	@Test(priority = 5)
	public void verifyVerticalTabs() {

		String initialOutput = accordionsTabsPage.getExercise4Output();

		System.out.println("Initial Tab: " + initialOutput);

		Assert.assertEquals(initialOutput, "Active tab: Overview");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(1), "true");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(2), "false");

		accordionsTabsPage.clickVerticalTab2();

		String featuresOutput = accordionsTabsPage.getExercise4Output();

		System.out.println("After Features: " + featuresOutput);

		Assert.assertEquals(featuresOutput, "Active tab: Features");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(1), "false");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(2), "true");

		accordionsTabsPage.clickVerticalTab3();

		String pricingOutput = accordionsTabsPage.getExercise4Output();

		System.out.println("After Pricing: " + pricingOutput);

		Assert.assertEquals(pricingOutput, "Active tab: Pricing");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(2), "false");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(3), "true");

		accordionsTabsPage.clickVerticalTab4();

		String reviewsOutput = accordionsTabsPage.getExercise4Output();

		System.out.println("After Reviews: " + reviewsOutput);

		Assert.assertEquals(reviewsOutput, "Active tab: Reviews");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(3), "false");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(4), "true");

		accordionsTabsPage.clickVerticalTab1();

		String overviewOutput = accordionsTabsPage.getExercise4Output();

		System.out.println("After Overview: " + overviewOutput);

		Assert.assertEquals(overviewOutput, "Active tab: Overview");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(4), "false");

		Assert.assertEquals(accordionsTabsPage.getVerticalTabSelectedState(1), "true");
	}
}