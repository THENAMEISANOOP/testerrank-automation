package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

	private WebDriver driver;

	public AlertsPage(WebDriver driver) {
		this.driver = driver;
	}

	// ==============================
	// SIMPLE ALERT
	// ==============================

	private By simpleAlertButton = By.id("simpleAlertBtn");

	public void clickSimpleAlert() {

		driver.findElement(simpleAlertButton).click();
	}

	public void acceptAlert() {

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}

	public String getAlertMessage() {

		Alert alert = driver.switchTo().alert();

		return alert.getText();
	}

	// Confirm Dialog

	private By confirmAlertButton = By.id("confirmBtn");

	private By confirmResult = By.id("confirmResult");

	public void clickConfirmAlert() {

		driver.findElement(confirmAlertButton).click();
	}

	public String getConfirmAlertMessage() {

		Alert alert = driver.switchTo().alert();

		return alert.getText();
	}

	public void acceptConfirmAlert() {

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}

	public String getConfirmResult() {

		return driver.findElement(confirmResult).getText();
	}

	// Prompt Dialog

	private By promptAlertButton = By.id("promptBtn");

	private By promptResult = By.id("promptResult");

	public void clickPromptAlert() {

		driver.findElement(promptAlertButton).click();
	}

	public String getPromptAlertMessage() {

		Alert alert = driver.switchTo().alert();

		return alert.getText();
	}

	public void enterPromptText(String text) {

		Alert alert = driver.switchTo().alert();

		alert.sendKeys(text);
	}

	public void acceptPromptAlert() {

		Alert alert = driver.switchTo().alert();

		alert.accept();
	}

	public String getPromptResult() {

		return driver.findElement(promptResult).getText();
	}

	// Custom Components

	private By openModalButton = By.id("openModalBtn");

	private By modal = By.id("customModal");

	private By modalTitle = By.id("modalTitle");

	private By closeModalButton = By.id("closeModalBtn");

	private By modalCloseX = By.id("modalCloseX");

	private By modalOverlay = By.id("modalOverlay");

	public void openModal() {

		WebElement button = driver.findElement(openModalButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getModalTitle() {

		return driver.findElement(modalTitle).getText();
	}

	public boolean isModalDisplayed() {

		return driver.findElement(modal).isDisplayed();
	}

	public void closeModal() {

		WebElement closeButton = driver.findElement(closeModalButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
	}

	public void closeModalUsingX() {

		WebElement closeButton = driver.findElement(modalCloseX);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
	}

	public void closeModalUsingOverlay() {

		WebElement overlay = driver.findElement(modalOverlay);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", overlay);
	}

	// TOAST NOTIFICATIONS

	private By successToastButton = By.id("toastSuccess");

	public void clickSuccessToast() {

		WebElement button = driver.findElement(successToastButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getSuccessToastMessage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement toast = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toastContainer > div")));

		return toast.getText();
	}

	private By errorToastButton = By.id("toastError");

	public void clickErrorToast() {

		WebElement button = driver.findElement(errorToastButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	private By warningToastButton = By.id("toastWarning");

	public void clickWarningToast() {

		WebElement button = driver.findElement(warningToastButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	private By infoToastButton = By.id("toastInfo");

	public void clickInfoToast() {

		WebElement button = driver.findElement(infoToastButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

}