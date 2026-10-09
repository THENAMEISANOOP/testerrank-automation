package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {

	private WebDriver driver;

	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
	}

	// BASIC CHECKBOXES

	private By readingCheckbox = By.id("hobbyReading");

	private By cookingCheckbox = By.id("hobbyCooking");

	private By gamingCheckbox = By.id("hobbyGaming");

	private By travelingCheckbox = By.id("hobbyTraveling");

	private By musicCheckbox = By.id("hobbyMusic");

	// CLICK CHECKBOXES

	public void selectReading() {
		driver.findElement(readingCheckbox).click();
	}

	public void selectCooking() {
		driver.findElement(cookingCheckbox).click();
	}

	public void selectGaming() {
		driver.findElement(gamingCheckbox).click();
	}

	public void selectTraveling() {
		driver.findElement(travelingCheckbox).click();
	}

	public void selectMusic() {
		driver.findElement(musicCheckbox).click();
	}

	// CHECK SELECTED STATE

	public boolean isReadingSelected() {
		return driver.findElement(readingCheckbox).isSelected();
	}

	public boolean isCookingSelected() {
		return driver.findElement(cookingCheckbox).isSelected();
	}

	public boolean isGamingSelected() {
		return driver.findElement(gamingCheckbox).isSelected();
	}

	public boolean isTravelingSelected() {
		return driver.findElement(travelingCheckbox).isSelected();
	}

	public boolean isMusicSelected() {
		return driver.findElement(musicCheckbox).isSelected();
	}

	// select all-----

	private By selectAllCheckbox = By.id("selectAll");

	private By item1Checkbox = By.id("item1");

	private By item2Checkbox = By.id("item2");

	private By item3Checkbox = By.id("item3");

	private By item4Checkbox = By.id("item4");

	private By item5Checkbox = By.id("item5");

	private By item6Checkbox = By.id("item6");

	private By selectionCount = By.id("selectionCount");

	public void clickSelectAll() {
		driver.findElement(selectAllCheckbox).click();
	}

	public boolean isItem1Selected() {
		return driver.findElement(item1Checkbox).isSelected();
	}

	public boolean isItem2Selected() {
		return driver.findElement(item2Checkbox).isSelected();
	}

	public boolean isItem3Selected() {
		return driver.findElement(item3Checkbox).isSelected();
	}

	public boolean isItem4Selected() {
		return driver.findElement(item4Checkbox).isSelected();
	}

	public boolean isItem5Selected() {
		return driver.findElement(item5Checkbox).isSelected();
	}

	public boolean isItem6Selected() {
		return driver.findElement(item6Checkbox).isSelected();
	}

	// count
	public String getSelectionCount() {
		return driver.findElement(selectionCount).getText();
	}

	// individual select-----

	public void clickItem1() {
		WebElement item = driver.findElement(item1Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	public void clickItem2() {
		WebElement item = driver.findElement(item2Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	public void clickItem3() {
		WebElement item = driver.findElement(item3Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	public void clickItem4() {
		WebElement item = driver.findElement(item4Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	public void clickItem5() {
		WebElement item = driver.findElement(item5Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	public void clickItem6() {
		WebElement item = driver.findElement(item6Checkbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
	}

	// GENDER RADIO BUTTONS

	private By maleRadio = By.id("genderMale");

	private By femaleRadio = By.id("genderFemale");

	private By otherRadio = By.id("genderOther");

	// SELECT GENDER

	public void selectMale() {

		WebElement radio = driver.findElement(maleRadio);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
	}

	public void selectFemale() {

		WebElement radio = driver.findElement(femaleRadio);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
	}

	public void selectOther() {

		WebElement radio = driver.findElement(otherRadio);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
	}

	// CHECK SELECTED STATE

	public boolean isMaleSelected() {
		return driver.findElement(maleRadio).isSelected();
	}

	public boolean isFemaleSelected() {
		return driver.findElement(femaleRadio).isSelected();
	}

	public boolean isOtherSelected() {
		return driver.findElement(otherRadio).isSelected();
	}

	// TOGGLE SWITCHES

	private By notificationsToggle = By.xpath("//input[@id='toggleNotifications']/parent::button");

	private By darkModeToggle = By.xpath("//input[@id='toggleDarkMode']/parent::button");

	private By autoSaveToggle = By.xpath("//input[@id='toggleAutoSave']/parent::button");

	private By emailAlertsToggle = By.xpath("//input[@id='toggleEmailAlerts']/parent::button");

	// TOGGLE NOTIFICATIONS

	public void toggleNotifications() {

		WebElement toggle = driver.findElement(notificationsToggle);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
	}

	// TOGGLE DARK MODE

	public void toggleDarkMode() {

		WebElement toggle = driver.findElement(darkModeToggle);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
	}

	// TOGGLE AUTO-SAVE

	public void toggleAutoSave() {

		WebElement toggle = driver.findElement(autoSaveToggle);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
	}

	// TOGGLE EMAIL ALERTS

	public void toggleEmailAlerts() {

		WebElement toggle = driver.findElement(emailAlertsToggle);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", toggle);
	}

	// CHECK TOGGLE STATE

	public boolean isNotificationsEnabled() {

		WebElement toggle = driver.findElement(notificationsToggle);

		return toggle.getAttribute("aria-checked").equals("true");
	}

	public boolean isDarkModeEnabled() {

		WebElement toggle = driver.findElement(darkModeToggle);

		return toggle.getAttribute("aria-checked").equals("true");
	}

	public boolean isAutoSaveEnabled() {

		WebElement toggle = driver.findElement(autoSaveToggle);

		return toggle.getAttribute("aria-checked").equals("true");
	}

	public boolean isEmailAlertsEnabled() {

		WebElement toggle = driver.findElement(emailAlertsToggle);

		return toggle.getAttribute("aria-checked").equals("true");
	}
}