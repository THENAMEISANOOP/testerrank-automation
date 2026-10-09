package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AlertsPage;
import pages.TopicsPage;

public class AlertsTest extends BaseTest {

	private TopicsPage topicsPage;
	private AlertsPage alertsPage;

	@BeforeMethod
	public void openAlertsPage() {

		topicsPage = new TopicsPage(driver);

		topicsPage.clickAlerts();

		alertsPage = new AlertsPage(driver);
	}

	@Test(priority = 1)
	public void verifySimpleAlert() {

		alertsPage.clickSimpleAlert();

		String message = alertsPage.getAlertMessage();

		Assert.assertEquals(message, "This is a simple alert!");

		alertsPage.acceptAlert();

	}

	@Test(priority = 2)
	public void verifyConfirmAlertAccept() {

		alertsPage.clickConfirmAlert();

		String message = alertsPage.getConfirmAlertMessage();

		System.out.println("Confirm Alert Message: " + message);

		alertsPage.acceptConfirmAlert();

		String result = alertsPage.getConfirmResult();

		System.out.println("Confirm Result: " + result);

		Assert.assertEquals(result, "Result: Accepted");
	}

	@Test(priority = 3)
	public void verifyConfirmAlertDismiss() {

		alertsPage.clickConfirmAlert();

		String message = alertsPage.getConfirmAlertMessage();

		System.out.println("Confirm Alert Message: " + message);

		Alert alert = driver.switchTo().alert();

		alert.dismiss();

		String result = alertsPage.getConfirmResult();

		System.out.println("Confirm Result: " + result);

		Assert.assertEquals(result, "Result: Dismissed");
	}

	@Test(priority = 4)
	public void verifyPromptAlert() {

		alertsPage.clickPromptAlert();

		String message = alertsPage.getPromptAlertMessage();

		System.out.println("Prompt Alert Message: " + message);

		alertsPage.enterPromptText("Anoop");

		alertsPage.acceptPromptAlert();

		String result = alertsPage.getPromptResult();

		System.out.println("Prompt Result: " + result);

		Assert.assertEquals(result, "You entered: Anoop");
	}

	@Test(priority = 5)
	public void verifyCustomModal() {

		alertsPage.openModal();

		Assert.assertTrue(alertsPage.isModalDisplayed());

		String title = alertsPage.getModalTitle();

		System.out.println("Modal Title: " + title);

		Assert.assertEquals(title, "Custom Modal Dialog");

		alertsPage.closeModalUsingX();
	}

	@Test(priority = 6)
	public void verifyModalCloseButton() {

		alertsPage.openModal();

		Assert.assertTrue(alertsPage.isModalDisplayed());

		alertsPage.closeModal();
	}

	@Test(priority = 7)
	public void verifyModalOverlayClose() {

		alertsPage.openModal();

		Assert.assertTrue(alertsPage.isModalDisplayed());

		alertsPage.closeModalUsingOverlay();
	}

	@Test(priority = 8)
	public void verifySuccessToast() {

		alertsPage.clickSuccessToast();

		String message = alertsPage.getSuccessToastMessage();

		System.out.println("Success Toast Message: " + message);

		Assert.assertEquals(message, "✓\nOperation completed successfully!");
	}

	@Test(priority = 9)
	public void verifyErrorToast() {

		alertsPage.clickErrorToast();

		String message = alertsPage.getSuccessToastMessage();

		System.out.println("Error Toast Message: " + message);

		Assert.assertEquals(message, "✗\nSomething went wrong! Please try again.");
	}

	@Test(priority = 10)
	public void verifyWarningToast() {

		alertsPage.clickWarningToast();

		String message = alertsPage.getSuccessToastMessage();

		System.out.println("Warning Toast Message: " + message);

		Assert.assertEquals(message, "⚠\nWarning: This action cannot be undone.");
	}

	@Test(priority = 11)
	public void verifyInfoToast() {

		alertsPage.clickInfoToast();

		String message = alertsPage.getSuccessToastMessage();

		System.out.println("Info Toast Message: " + message);

		Assert.assertEquals(message, "ℹ\nTip: You can use keyboard shortcuts.");
	}

}