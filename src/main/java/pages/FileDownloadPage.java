package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloadPage {

	private WebDriver driver;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
	}

	private By downloadTextButton = By.id("downloadTextBtn");

	private By downloadTextStatus = By.id("downloadTextStatus");

	public void clickDownloadTextButton() {

		driver.findElement(downloadTextButton).click();
	}

	// Get download status
	public String getDownloadTextStatus() {

		return driver.findElement(downloadTextStatus).getText();
	}

//	----CSV download---

	private By downloadCsvButton = By.id("downloadCsvBtn");

	private By downloadCsvStatus = By.id("downloadCsvStatus");

	public void clickDownloadCsvButton() {

		driver.findElement(downloadCsvButton).click();
	}

	public String getDownloadCsvStatus() {

		return driver.findElement(downloadCsvStatus).getText();
	}

//	invoice download---

	private By downloadInvoiceButton = By.id("downloadInvoiceBtn");

	private By invoiceResult = By.id("invoiceResult");

	private By confirmDownloadButton = By.id("confirmDownloadBtn");

	public void clickDownloadInvoiceButton() {

		WebElement button = driver.findElement(downloadInvoiceButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getInvoiceResult() {

		return driver.findElement(invoiceResult).getText();
	}

	public void confirmInvoiceDownload() {

		WebElement confirmButton = driver.findElement(confirmDownloadButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmButton);
	}

	private By cancelDownloadButton = By.id("cancelDownloadBtn");

	public void cancelInvoiceDownload() {

		WebElement cancelButton = driver.findElement(cancelDownloadButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelButton);
	}

	private By reportQ1 = By.id("reportQ1");

	private By reportQ2 = By.id("reportQ2");

	private By reportQ3 = By.id("reportQ3");

	private By downloadSelectedButton = By.id("downloadSelectedBtn");

	private By downloadCounter = By.id("downloadCounter");

	public void selectAllReports() {

		WebElement q1 = driver.findElement(reportQ1);

		WebElement q2 = driver.findElement(reportQ2);

		WebElement q3 = driver.findElement(reportQ3);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", q1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", q2);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", q3);
	}

	public void clickDownloadSelected() {

		WebElement button = driver.findElement(downloadSelectedButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getDownloadCounter() {

		return driver.findElement(downloadCounter).getText();
	}

}