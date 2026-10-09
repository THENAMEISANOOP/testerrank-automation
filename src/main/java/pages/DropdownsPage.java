package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownsPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public DropdownsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By countryDropdown = By.id("countrySelect");
	private By technologyDropdown = By.id("groupedSelect");
	private By stateCountryDropdown = By.id("stateCountry");
	private By stateDropdown = By.id("stateSelect");
	private By skillsDropdown = By.id("skillsSelect");
	private By programmingLanguageSearch = By.id("searchDropdown");
	private By programmingLanguageOption = By.cssSelector("#dropdownOptions li[role='option']");
	private By programmingLanguageOutput = By.id("searchDropdownOutput");
	private By loadOptionsButton =
	        By.id("loadOptionsBtn");

	private By dynamicDropdown =
	        By.id("dynamicSelect");

	// country

	public void selectCountry(String country) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown)));

		select.selectByVisibleText(country);
	}

	public String getSelectedCountry() {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown)));

		return select.getFirstSelectedOption().getText();
	}

	// technoloogy

	public void selectTechnology(String technology) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(technologyDropdown)));

		select.selectByVisibleText(technology);
	}

	public String getSelectedTechnology() {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(technologyDropdown)));

		return select.getFirstSelectedOption().getText();

	}

	public void selectStateCountry(String country) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateCountryDropdown)));

		select.selectByVisibleText(country);
	}

	public void selectState(String state) {

		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(stateDropdown)));

		select.selectByVisibleText(state);
	}

	public String getSelectedStateCountry() {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateCountryDropdown)));

		return select.getFirstSelectedOption().getText();
	}

	public String getSelectedState() {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown)));

		return select.getFirstSelectedOption().getText();
	}

	public void selectSkill(String skill) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(skillsDropdown)));

		select.selectByVisibleText(skill);
	}

	public String getSelectedSkills() {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(skillsDropdown)));

		StringBuilder skills = new StringBuilder();

		for (org.openqa.selenium.WebElement option : select.getAllSelectedOptions()) {

			if (skills.length() > 0) {
				skills.append(", ");
			}

			skills.append(option.getText());
		}

		return skills.toString();
	}

	public void searchProgrammingLanguage(String language) {

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(programmingLanguageSearch));

		searchBox.clear();
		searchBox.sendKeys(language);

		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(programmingLanguageOption));

		System.out.println("Option found: " + option.getText());

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", option);

		((JavascriptExecutor) driver)
				.executeScript("arguments[0].dispatchEvent(new MouseEvent('mousedown', {bubbles:true}));"
						+ "arguments[0].dispatchEvent(new MouseEvent('mouseup', {bubbles:true}));"
						+ "arguments[0].dispatchEvent(new MouseEvent('click', {bubbles:true}));", option);
	}

	public String getSelectedProgrammingLanguage() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(programmingLanguageOutput)).getText();
	}
	
	public void loadDynamicOptions() {

	    WebElement button = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            loadOptionsButton
	        )
	    );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});",
	        button
	    );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].click();",
	        button
	    );
	}
	
	public void selectDynamicOption(String option) {

	    WebElement dropdown = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            dynamicDropdown
	        )
	    );

	    Select select = new Select(dropdown);

	    select.selectByVisibleText(option);
	}
	
	public String getSelectedDynamicOption() {

	    Select select = new Select(
	        wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                dynamicDropdown
	            )
	        )
	    );

	    return select.getFirstSelectedOption().getText();
	}
}