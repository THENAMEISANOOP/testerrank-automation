
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public FormsPage(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// TEXT FIELDS

	private By fullName = By.id("fullName");

	private By fullNameSubmit = By.id("submitName");

	private By email = By.id("emailInput");

	private By password = By.id("passwordField");

	private By togglePassword = By.id("togglePassword");

	private By currentAddress = By.id("messageBox");

	// TEXT FIELD METHODS

	public void enterFullName(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).sendKeys(value);
	}

	public void clickFullNameSubmit() {

		wait.until(ExpectedConditions.elementToBeClickable(fullNameSubmit)).click();
	}

	public void enterEmail(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(value);
	}

	public void enterPassword(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(value);
	}

	public void clickPasswordShowHide() {

		wait.until(ExpectedConditions.elementToBeClickable(togglePassword)).click();
	}

	public void enterCurrentAddress(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddress)).sendKeys(value);
	}

	public String getFullName() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(fullName)).getAttribute("value");
	}

	public String getEmail() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(email)).getAttribute("value");
	}

	public String getPassword() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(password)).getAttribute("value");
	}

	public String getCurrentAddress() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(currentAddress)).getAttribute("value");
	}

	// SPECIAL INPUTS

	private By birthDate = By.id("birthDate");

	private By disabledField = By.id("disabledField");

	private By readonlyField = By.id("readonlyField");

	private By cityInput = By.id("cityInput");

	public void enterBirthDate(String date) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(birthDate)).sendKeys(date);
	}

	public String getBirthDate() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(birthDate)).getAttribute("value");
	}

	public boolean isDisabledFieldDisabled() {

		return !wait.until(ExpectedConditions.presenceOfElementLocated(disabledField)).isEnabled();
	}

	public String getDisabledFieldValue() {

		return wait.until(ExpectedConditions.presenceOfElementLocated(disabledField)).getAttribute("value");
	}

	public boolean isReadonlyFieldReadonly() {

		return wait.until(ExpectedConditions.presenceOfElementLocated(readonlyField)).getAttribute("readonly") != null;
	}

	public String getReadonlyFieldValue() {

		return wait.until(ExpectedConditions.presenceOfElementLocated(readonlyField)).getAttribute("value");
	}

	public void enterCity(String city) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput)).sendKeys(city);
	}

	public String getCity() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput)).getAttribute("value");
	}

	// STUDENT REGISTRATION

	private By firstName = By.id("firstName");

	private By lastName = By.id("lastName");

	private By registrationEmail = By.id("regEmail");

	private By phone = By.id("phone");

	private By genderMale = By.id("genderMale");

	private By genderFemale = By.id("genderFemale");

	private By genderOther = By.id("genderOther");

	private By registrationAddress = By.id("address");

	private By agreeTerms = By.id("agreeTerms");

	private By registerButton = By.id("registerBtn");

	public void enterFirstName(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(value);
	}

	public void enterLastName(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(value);
	}

	public void enterRegistrationEmail(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(registrationEmail)).sendKeys(value);
	}

	public void enterPhone(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(phone)).sendKeys(value);
	}

	public void selectMale() {

		WebElement maleRadio = wait.until(ExpectedConditions.presenceOfElementLocated(genderMale));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleRadio);
	}

	public void selectFemale() {

		WebElement femaleRadio = wait.until(ExpectedConditions.presenceOfElementLocated(genderFemale));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", femaleRadio);
	}

	public void selectOther() {

		WebElement otherRadio = wait.until(ExpectedConditions.presenceOfElementLocated(genderOther));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", otherRadio);
	}

	public void enterRegistrationAddress(String value) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(registrationAddress)).sendKeys(value);
	}

	public void selectTerms() {

		WebElement termsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(agreeTerms));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);
	}

	public void clickRegister() {

		WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(registerButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	private By registrationSuccess = By.id("registrationSuccess");

	public String getRegistrationSuccessMessage() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationSuccess)).getText();
	}

	// error

	private By firstNameError = By.id("firstNameError");

	private By lastNameError = By.id("lastNameError");

	private By registrationEmailError = By.id("regEmailError");

	private By phoneError = By.id("phoneError");

	private By genderError = By.id("genderError");

	private By addressError = By.id("addressError");

	private By termsError = By.id("termsError");

	public String getFirstNameError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameError)).getText();
	}

	public String getLastNameError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameError)).getText();
	}

	public String getRegistrationEmailError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(registrationEmailError)).getText();
	}

	public String getPhoneError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneError)).getText();
	}

	public String getGenderError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(genderError)).getText();
	}

	public String getAddressError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(addressError)).getText();
	}

	public String getTermsError() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(termsError)).getText();
	}
}