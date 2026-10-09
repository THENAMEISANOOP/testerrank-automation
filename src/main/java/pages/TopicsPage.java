package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopicsPage {

	private WebDriverWait wait;

	public TopicsPage(WebDriver driver) {

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By formsTopic = By.xpath("//a[contains(normalize-space(), 'Forms & Inputs')]");

	private By dropdownsTopic = By.xpath("//a[contains(normalize-space(), 'Dropdowns')]");

	private By checkBoxTopic = By.xpath("//a[contains(normalize-space(), 'Checkboxes')]");

	private By alertsTopic = By.xpath("//a[contains(normalize-space(), 'Alerts')]");

	private By tablesTopic = By.xpath("//a[contains(normalize-space(), 'Tables')]");

	private By fileUploadTopic = By.xpath("//a[contains(normalize-space(), 'File Upload')]");

	private By fileDownloadTopic = By.xpath("//a[contains(normalize-space(), 'File Download')]");

	private By accordionsTabsTopic = By.xpath("//a[contains(normalize-space(), 'Accordions & Tabs')]");

	public void clickForms() {

		wait.until(ExpectedConditions.elementToBeClickable(formsTopic)).click();
	}

	public void clickDropdowns() {

		wait.until(ExpectedConditions.elementToBeClickable(dropdownsTopic)).click();
	}

	public void clickCheckboxes() {

		wait.until(ExpectedConditions.elementToBeClickable(checkBoxTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/checkboxes"));
	}

	public void clickAlerts() {

		wait.until(ExpectedConditions.elementToBeClickable(alertsTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/alerts"));
	}

	public void clickTables() {

		wait.until(ExpectedConditions.elementToBeClickable(tablesTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/tables"));
	}

	public void clickFileUpload() {

		wait.until(ExpectedConditions.elementToBeClickable(fileUploadTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/file-upload"));
	}

	public void clickFileDownload() {

		wait.until(ExpectedConditions.elementToBeClickable(fileDownloadTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/file-download"));
	}

	public void clickAccordionsTabs() {

		wait.until(ExpectedConditions.elementToBeClickable(accordionsTabsTopic)).click();

		wait.until(ExpectedConditions.urlContains("/topics/accordions-tabs"));
	}

}