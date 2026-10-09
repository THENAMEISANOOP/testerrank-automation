package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckboxesPage;
import pages.TopicsPage;

public class CheckboxesTest extends BaseTest {

	private TopicsPage topicsPage;

	private CheckboxesPage checkboxesPage;

	@BeforeMethod
	public void openCheckboxesPage() {

		topicsPage = new TopicsPage(driver);
		topicsPage.clickCheckboxes();
//		System.out.println("Current URL: " + driver.getCurrentUrl());
//		System.out.println("Page Title: " + driver.getTitle());

		checkboxesPage = new CheckboxesPage(driver);
	}

	@Test(priority = 1)
	public void verifyBasicCheckboxes() {

		checkboxesPage.selectReading();
		checkboxesPage.selectCooking();
		checkboxesPage.selectGaming();
		checkboxesPage.selectTraveling();
		checkboxesPage.selectMusic();

		Assert.assertTrue(checkboxesPage.isReadingSelected());

		Assert.assertTrue(checkboxesPage.isCookingSelected());

		Assert.assertTrue(checkboxesPage.isGamingSelected());

		Assert.assertTrue(checkboxesPage.isTravelingSelected());

		Assert.assertTrue(checkboxesPage.isMusicSelected());
	}

	@Test(priority = 2)
	public void verifySelectAll() {

		System.out.println("Current URL: " + driver.getCurrentUrl());

		checkboxesPage.clickSelectAll();

		Assert.assertTrue(checkboxesPage.isItem1Selected());

		Assert.assertTrue(checkboxesPage.isItem2Selected());

		Assert.assertTrue(checkboxesPage.isItem3Selected());

		Assert.assertTrue(checkboxesPage.isItem4Selected());

		Assert.assertTrue(checkboxesPage.isItem5Selected());

		Assert.assertTrue(checkboxesPage.isItem6Selected());

		Assert.assertEquals(checkboxesPage.getSelectionCount(), "6 of 6 selected");

	}

	@Test(priority = 3)
	public void verifySelectNone() {

		// First select all checkboxes
		checkboxesPage.clickSelectAll();

		// Click again to unselect all
		checkboxesPage.clickSelectAll();

		Assert.assertFalse(checkboxesPage.isItem1Selected());

		Assert.assertFalse(checkboxesPage.isItem2Selected());

		Assert.assertFalse(checkboxesPage.isItem3Selected());

		Assert.assertFalse(checkboxesPage.isItem4Selected());

		Assert.assertFalse(checkboxesPage.isItem5Selected());

		Assert.assertFalse(checkboxesPage.isItem6Selected());

		Assert.assertEquals(checkboxesPage.getSelectionCount(), "0 of 6 selected");
	}

	@Test(priority = 4)
	public void verifyIndividualItems() {

		checkboxesPage.clickItem1();
		checkboxesPage.clickItem2();
		checkboxesPage.clickItem3();
		checkboxesPage.clickItem4();
		checkboxesPage.clickItem5();
		checkboxesPage.clickItem6();

		Assert.assertTrue(checkboxesPage.isItem1Selected());
		Assert.assertTrue(checkboxesPage.isItem2Selected());
		Assert.assertTrue(checkboxesPage.isItem3Selected());
		Assert.assertTrue(checkboxesPage.isItem4Selected());
		Assert.assertTrue(checkboxesPage.isItem5Selected());
		Assert.assertTrue(checkboxesPage.isItem6Selected());

		Assert.assertEquals(checkboxesPage.getSelectionCount(), "6 of 6 selected");
	}

	@Test(priority = 5)
	public void verifyGenderRadioButtons() {

		checkboxesPage.selectMale();
		System.out.println("Male Selected: " + checkboxesPage.isMaleSelected());

		Assert.assertTrue(checkboxesPage.isMaleSelected());

		Assert.assertFalse(checkboxesPage.isFemaleSelected());

		Assert.assertFalse(checkboxesPage.isOtherSelected());
	}

	@Test(priority = 6)
	public void verifyGenderRadioButtonSwitching() {

		checkboxesPage.selectMale();

		System.out.println("Male Selected: " + checkboxesPage.isMaleSelected());

		System.out.println("Female Selected: " + checkboxesPage.isFemaleSelected());

		System.out.println("Other Selected: " + checkboxesPage.isOtherSelected());

		Assert.assertTrue(checkboxesPage.isMaleSelected());

		checkboxesPage.selectFemale();

		System.out.println("After selecting Female:");

		System.out.println("Male Selected: " + checkboxesPage.isMaleSelected());

		System.out.println("Female Selected: " + checkboxesPage.isFemaleSelected());

		System.out.println("Other Selected: " + checkboxesPage.isOtherSelected());

		Assert.assertTrue(checkboxesPage.isFemaleSelected());

		Assert.assertFalse(checkboxesPage.isMaleSelected());

		Assert.assertFalse(checkboxesPage.isOtherSelected());
	}

	@Test(priority = 7)
	public void verifyNotificationsToggle() {

		System.out.println("Notifications before click: " + checkboxesPage.isNotificationsEnabled());

		Assert.assertFalse(checkboxesPage.isNotificationsEnabled());

		checkboxesPage.toggleNotifications();

		System.out.println("Notifications after click: " + checkboxesPage.isNotificationsEnabled());

		Assert.assertTrue(checkboxesPage.isNotificationsEnabled());
	}

	@Test(priority = 8)
	public void verifyDarkModeToggle() {

		System.out.println("Dark Mode before click: " + checkboxesPage.isDarkModeEnabled());

		Assert.assertFalse(checkboxesPage.isDarkModeEnabled());

		checkboxesPage.toggleDarkMode();

		System.out.println("Dark Mode after click: " + checkboxesPage.isDarkModeEnabled());

		Assert.assertTrue(checkboxesPage.isDarkModeEnabled());
	}

	@Test(priority = 9)
	public void verifyAutoSaveToggle() {

		System.out.println("Auto-save before click: " + checkboxesPage.isAutoSaveEnabled());

		Assert.assertFalse(checkboxesPage.isAutoSaveEnabled());

		checkboxesPage.toggleAutoSave();

		System.out.println("Auto-save after click: " + checkboxesPage.isAutoSaveEnabled());

		Assert.assertTrue(checkboxesPage.isAutoSaveEnabled());
	}

	@Test(priority = 10)
	public void verifyEmailAlertsToggle() {

		System.out.println("Email Alerts before click: " + checkboxesPage.isEmailAlertsEnabled());

		Assert.assertFalse(checkboxesPage.isEmailAlertsEnabled());

		checkboxesPage.toggleEmailAlerts();

		System.out.println("Email Alerts after click: " + checkboxesPage.isEmailAlertsEnabled());

		Assert.assertTrue(checkboxesPage.isEmailAlertsEnabled());
	}
}