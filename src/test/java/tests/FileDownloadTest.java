package tests;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileDownloadPage;
import pages.TopicsPage;

public class FileDownloadTest extends BaseTest {

	private FileDownloadPage fileDownloadPage;

	@BeforeMethod
	public void openFileDownloadPage() {

		TopicsPage topicsPage = new TopicsPage(driver);

		topicsPage.clickFileDownload();

		fileDownloadPage = new FileDownloadPage(driver);
	}

	@Test(priority = 1)
	public void verifyTextFileDownloadStarts() {

		fileDownloadPage.clickDownloadTextButton();

		String status = fileDownloadPage.getDownloadTextStatus();

		System.out.println("Download Status: " + status);

		Assert.assertEquals(status, "Download started!");
	}

	@Test(priority = 2)
	public void verifyTextFileIsDownloaded() {

		File downloadFolder = new File("downloads");

		int filesBefore = downloadFolder.listFiles().length;

		System.out.println("Files Before Download: " + filesBefore);

		fileDownloadPage.clickDownloadTextButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean newFileDownloaded = wait.until(driver -> downloadFolder.listFiles().length > filesBefore);

		System.out.println("New File Downloaded: " + newFileDownloaded);

		// Verify a new file was downloaded
		Assert.assertTrue(newFileDownloaded, "No new file was downloaded!");
	}

	@Test(priority = 3)
	public void verifyCsvDownloadStarts() {

		fileDownloadPage.clickDownloadCsvButton();

		String status = fileDownloadPage.getDownloadCsvStatus();

		System.out.println("CSV Download Status: " + status);

		// Verify download started
		Assert.assertEquals(status, "Download started!");
	}

	@Test(priority = 4)
	public void verifyCsvFileContents() throws Exception {

		File downloadFolder = new File("downloads");

		File[] filesBefore = downloadFolder.listFiles();

		fileDownloadPage.clickDownloadCsvButton();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		File csvFile = wait.until(driver -> {

			File[] filesAfter = downloadFolder.listFiles();

			for (File file : filesAfter) {

				if (!file.getName().endsWith(".csv")) {
					continue;
				}

				boolean isNewFile = true;

				// Compare with files that existed before
				for (File oldFile : filesBefore) {

					if (oldFile.getName().equals(file.getName())) {

						isNewFile = false;
						break;
					}
				}

				if (isNewFile) {
					return file;
				}
			}

			return null;
		});

		// Read the newly downloaded CSV
		String content = Files.readString(csvFile.toPath());

		System.out.println("New CSV File Name: " + csvFile.getName());

		System.out.println("CSV File Contents:\n" + content);

		// Verify CSV is not empty
		Assert.assertTrue(content.length() > 0, "CSV file is empty!");

		// Verify CSV header
		Assert.assertTrue(content.contains("Name,Email,City,Amount"), "CSV header is incorrect!");

		// Verify Rajesh Kumar row
		Assert.assertTrue(content.contains("Rajesh Kumar,rajesh@email.com,Mumbai,25000"),
				"Rajesh Kumar data is incorrect!");

		// Verify Priya Patel row
		Assert.assertTrue(content.contains("Priya Patel,priya@email.com,Delhi,18000"),
				"Priya Patel data is incorrect!");

		// Verify Amit Verma row
		Assert.assertTrue(content.contains("Amit Verma,amit@email.com,Bangalore,32000"),
				"Amit Verma data is incorrect!");
	}

	@Test(priority = 5)
	public void verifyInvoiceDownloadWithConfirmation() {

		fileDownloadPage.clickDownloadInvoiceButton();

		fileDownloadPage.confirmInvoiceDownload();

		String result = fileDownloadPage.getInvoiceResult();

		System.out.println("Invoice Result: " + result);
	}

	@Test(priority = 6)
	public void verifyInvoiceFileIsDownloaded() {

		// Get the downloads folder
		File downloadFolder = new File("downloads");

		// Get files before download
		File[] filesBefore = downloadFolder.listFiles();

		// Click Download Invoice
		fileDownloadPage.clickDownloadInvoiceButton();

		// Click Confirm Download in the webpage modal
		fileDownloadPage.confirmInvoiceDownload();

		// Wait for a new file
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		File invoiceFile = wait.until(driver -> {

			File[] filesAfter = downloadFolder.listFiles();

			for (File file : filesAfter) {

				// Ignore temporary Chrome download files
				if (file.getName().endsWith(".tmp")) {
					continue;
				}

				boolean isNewFile = true;

				// Check whether this file existed before
				for (File oldFile : filesBefore) {

					if (oldFile.getName().equals(file.getName())) {

						isNewFile = false;
						break;
					}
				}

				if (isNewFile) {
					return file;
				}
			}

			return null;
		});
		System.out.println("Downloaded Invoice File: " + invoiceFile.getName());

		// Verify a new file was downloaded
		Assert.assertTrue(invoiceFile.exists(), "Invoice file was not downloaded!");
	}

	@Test(priority = 7)
	public void verifyInvoiceDownloadCancel() {

		// Click Download Invoice
		fileDownloadPage.clickDownloadInvoiceButton();

		// Click Cancel
		fileDownloadPage.cancelInvoiceDownload();

		System.out.println("Invoice download cancelled successfully");
	}

	@Test(priority = 8)
	public void verifyMultipleFileDownloads() {

		// Select all three reports
		fileDownloadPage.selectAllReports();

		// Download selected reports
		fileDownloadPage.clickDownloadSelected();

		// Get download counter
		String counter = fileDownloadPage.getDownloadCounter();

		System.out.println("Download Counter: " + counter);

		// Verify all three downloads
		Assert.assertEquals(counter, "Downloaded: 3/3");
	}

	@Test(priority = 9)
	public void verifyAllThreeFilesAreDownloaded() {

		File downloadFolder = new File("downloads");

		File q1File = new File(downloadFolder, "report-Q1.csv");

		File q2File = new File(downloadFolder, "report-Q2.csv");

		File q3File = new File(downloadFolder, "report-Q3.csv");

		// Delete old files
		if (q1File.exists()) {
			q1File.delete();
		}

		if (q2File.exists()) {
			q2File.delete();
		}

		if (q3File.exists()) {
			q3File.delete();
		}

		// Select all reports
		fileDownloadPage.selectAllReports();

		// Start downloads
		fileDownloadPage.clickDownloadSelected();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for Q1
		wait.until(driver -> q1File.exists());

		System.out.println("Report Q1 exists: " + q1File.exists());

		// Wait for Q2
		wait.until(driver -> q2File.exists());

		System.out.println("Report Q2 exists: " + q2File.exists());

		// Wait for Q3
		wait.until(driver -> q3File.exists());

		System.out.println("Report Q3 exists: " + q3File.exists());

		Assert.assertTrue(q1File.exists(), "Report Q1 was not downloaded!");

		Assert.assertTrue(q2File.exists(), "Report Q2 was not downloaded!");

		Assert.assertTrue(q3File.exists(), "Report Q3 was not downloaded!");
	}
}