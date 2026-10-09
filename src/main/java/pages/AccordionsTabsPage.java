package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccordionsTabsPage {

	private WebDriver driver;

	public AccordionsTabsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By accordion1 = By.id("accordionToggle1");

	private By accordion2 = By.id("accordionToggle2");

	private By accordion3 = By.id("accordionToggle3");

	private By accordion4 = By.id("accordionToggle4");

	private By exercise1Output = By.id("exercise1Output");

	public void clickAccordion1() {

		WebElement button = driver.findElement(accordion1);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		button.click();
	}

	public void clickAccordion2() {

		WebElement button = driver.findElement(accordion2);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		button.click();
	}

	public void clickAccordion3() {

		WebElement button = driver.findElement(accordion3);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

		button.click();
	}

	public void clickAccordion4() {

		WebElement button = driver.findElement(accordion4);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getExercise1Output() {

		return driver.findElement(exercise1Output).getText();
	}

	private By exclusiveAccordion1 = By.id("exclusiveAccordionToggle1");

	private By exclusiveAccordion2 = By.id("exclusiveAccordionToggle2");

	private By exclusiveAccordion3 = By.id("exclusiveAccordionToggle3");

	private By exclusiveAccordion4 = By.id("exclusiveAccordionToggle4");

	private By exercise2Output = By.id("exercise2Output");

	public void clickExclusiveAccordion1() {

		WebElement button = driver.findElement(exclusiveAccordion1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickExclusiveAccordion2() {

		WebElement button = driver.findElement(exclusiveAccordion2);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickExclusiveAccordion3() {

		WebElement button = driver.findElement(exclusiveAccordion3);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickExclusiveAccordion4() {

		WebElement button = driver.findElement(exclusiveAccordion4);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getExercise2Output() {

		return driver.findElement(exercise2Output).getText();
	}

	private By tab1 = By.id("tab1");

	private By tab2 = By.id("tab2");

	private By tab3 = By.id("tab3");

	private By tab4 = By.id("tab4");

	private By exercise3Output = By.id("exercise3Output");

	public void clickTab1() {

		WebElement button = driver.findElement(tab1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickTab2() {

		WebElement button = driver.findElement(tab2);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickTab3() {

		WebElement button = driver.findElement(tab3);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickTab4() {

		WebElement button = driver.findElement(tab4);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getExercise3Output() {

		return driver.findElement(exercise3Output).getText();
	}

	public String getTabSelectedState(int tabNumber) {

		By tab = By.id("tab" + tabNumber);

		return driver.findElement(tab).getAttribute("aria-selected");
	}

	private By verticalTab1 = By.id("verticalTab1");

	private By verticalTab2 = By.id("verticalTab2");

	private By verticalTab3 = By.id("verticalTab3");

	private By verticalTab4 = By.id("verticalTab4");

	private By exercise4Output = By.id("exercise4Output");

	public void clickVerticalTab1() {

		WebElement button = driver.findElement(verticalTab1);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickVerticalTab2() {

		WebElement button = driver.findElement(verticalTab2);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickVerticalTab3() {

		WebElement button = driver.findElement(verticalTab3);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public void clickVerticalTab4() {

		WebElement button = driver.findElement(verticalTab4);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	public String getExercise4Output() {

		return driver.findElement(exercise4Output).getText();
	}

	public String getVerticalTabSelectedState(int tabNumber) {

		By tab = By.id("verticalTab" + tabNumber);

		return driver.findElement(tab).getAttribute("aria-selected");
	}
}