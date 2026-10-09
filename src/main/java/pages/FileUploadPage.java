package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadPage {

	private WebDriver driver;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
	}

	private By fileInput = By.id("singleFileInput");

	private By fileName = By.id("fileName");

	private By fileSize = By.id("fileSize");

	public void selectFile(String filePath) {

		driver.findElement(fileInput).sendKeys(filePath);
	}

	public String getSelectedFilePath() {

		return driver.findElement(fileInput).getAttribute("value");
	}

	public String getFileName() {

		return driver.findElement(fileName).getText();
	}

	public String getFileSize() {

		return driver.findElement(fileSize).getText();
	}

	// upload btn

	private By uploadButton = By.id("uploadBtn");

	private By uploadResult = By.id("exercise1Result");

	public boolean isUploadButtonEnabled() {

		return driver.findElement(uploadButton).isEnabled();
	}

	public void clickUploadButton() {

		driver.findElement(uploadButton).click();
	}

	public String getUploadResult() {

		return driver.findElement(uploadResult).getText();
	}

	// reset-btn

	public void clickResetButton() {

		driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
	}

	public boolean isUploadButtonDisabled() {

		return !driver.findElement(uploadButton).isEnabled();
	}

//	Verify Multiple File Selection

	private By multiFileInput = By.id("multiFileInput");

	private By fileCount = By.id("fileCount");

	public void selectMultipleFiles(String file1, String file2) {

		driver.findElement(multiFileInput).sendKeys(file1 + System.lineSeparator() + file2);
	}

	public String getFileCount() {

		return driver.findElement(fileCount).getText();
	}

	public String getFileListText() {

		return driver.findElement(By.id("fileList")).getText();
	}

	// remove
	public void clickFirstRemoveButton() {

		driver.findElements(By.cssSelector("#fileList .remove-file")).get(0).click();
	}

//	clear-all

	public void clickClearAll() {

		driver.findElement(By.xpath("//div[@id='exercise-2']//button[normalize-space()='Clear All']")).click();
	}

//	Drag Upload with Multiple Files

	private By hiddenFileInput = By.id("hiddenFileInput");

	private By dragUploadResult = By.id("exercise3Result");

	public void selectDragUploadFiles(String file1, String file2) {

		driver.findElement(hiddenFileInput).sendKeys(file1 + System.lineSeparator() + file2);
	}

	public String getDragUploadResult() {

		return driver.findElement(dragUploadResult).getText();
	}

	private By uploadedFileInfo = By.id("uploadedFileInfo");

	public String getUploadedFileInfo() {

		return driver.findElement(uploadedFileInfo).getText();
	}

	public void clickDragUploadClear() {

		WebElement clearButton = driver
				.findElement(By.xpath("//div[@id='exercise-3']//button[normalize-space()='Clear']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clearButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearButton);
	}
}