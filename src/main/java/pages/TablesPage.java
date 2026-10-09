package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TablesPage {

	private WebDriver driver;

	public TablesPage(WebDriver driver) {
		this.driver = driver;
	}

	// BASIC TABLE

	// All rows inside the table body
	private By tableRows = By.cssSelector("#basicTable tbody tr");

	// Row count displayed below the table
	private By rowCount = By.id("basicTableRowCount");

	public int getRowCount() {

		return driver.findElements(tableRows).size();
	}

	public String getRowCountText() {

		return driver.findElement(rowCount).getText();
	}

	public String getCellValue(int row, int column) {

		By cell = By.cssSelector("#basicTable tbody tr:nth-child(" + row + ") td:nth-child(" + column + ")");

		return driver.findElement(cell).getText();
	}

	// SORTABLE TABLE

	private By nameHeader = By.cssSelector("#sortableTable thead th:nth-child(1)");

	private By sortState = By.id("sortState");

	public void clickNameHeader() {

		WebElement header = driver.findElement(nameHeader);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", header);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", header);
	}

	public String getSortState() {

		return driver.findElement(sortState).getText();
	}

	public String getFirstSortableTableName() {

		return driver.findElement(By.cssSelector("#sortableTable tbody tr:first-child td:first-child")).getText();
	}

	private By ageHeader = By.cssSelector("#sortableTable thead th:nth-child(2)");

	public void clickAgeHeader() {

		WebElement header = driver.findElement(ageHeader);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", header);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", header);
	}

	public String getFirstSortableTableAge() {

		return driver.findElement(By.cssSelector("#sortableTable tbody tr:first-child td:nth-child(2)")).getText();
	}

	// sorTable---department---
	private By departmentHeader = By.cssSelector("#sortableTable thead th:nth-child(3)");

	public void clickDepartmentHeader() {

		WebElement header = driver.findElement(departmentHeader);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", header);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", header);
	}

	public String getFirstSortableTableDepartment() {

		return driver.findElement(By.cssSelector("#sortableTable tbody tr:first-child td:nth-child(3)")).getText();
	}

	// salary-----------

	private By salaryHeader = By.cssSelector("#sortableTable thead th:nth-child(4)");

	public void clickSalaryHeader() {

		WebElement header = driver.findElement(salaryHeader);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", header);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", header);
	}

	public String getFirstSortableTableSalary() {

		return driver.findElement(By.cssSelector("#sortableTable tbody tr:first-child td:nth-child(4)")).getText();
	}

	// FILTERABLE TABLE

	private By tableSearch = By.id("tableSearch");

	public void searchProduct(String text) {

		WebElement searchBox = driver.findElement(tableSearch);

		searchBox.clear();
		searchBox.sendKeys(text);
	}

	private By filterResultCount = By.id("filterResultCount");

	public String getFilterResultCount() {

		return driver.findElement(filterResultCount).getText();
	}

	// TABLE ACTIONS

	private By editButtons = By.cssSelector("#actionTable .edit-btn");

	public void clickFirstEditButton() {

		WebElement editButton = driver.findElements(editButtons).get(0);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", editButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
	}

	private By firstRowInputs = By.cssSelector("#actionTable tbody tr:first-child input");

	public void updateFirstRowData(String name, String email, String role) {

		java.util.List<WebElement> inputs = driver.findElements(firstRowInputs);

		inputs.get(0).clear();
		inputs.get(0).sendKeys(name);

		inputs.get(1).clear();
		inputs.get(1).sendKeys(email);

		inputs.get(2).clear();
		inputs.get(2).sendKeys(role);
	}

	private By firstRowSaveButton = By.cssSelector("#actionTable tbody tr:first-child .save-btn");

	public void clickFirstRowSaveButton() {

		WebElement saveButton = driver.findElement(firstRowSaveButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
	}

	public String getFirstActionRowData() {

		return driver.findElement(By.cssSelector("#actionTable tbody tr:first-child")).getText();
	}

	private By actionRowCount = By.id("actionRowCount");

	public String getActionRowCount() {

		return driver.findElement(actionRowCount).getText();
	}

//	cancel-btn
	private By firstRowCancelButton = By.cssSelector("#actionTable tbody tr:first-child .cancel-btn");

	public void clickFirstRowCancelButton() {

		WebElement cancelButton = driver.findElement(firstRowCancelButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", cancelButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelButton);
	}

	// dlt -btn

	private By deleteButtons = By.cssSelector("#actionTable .delete-btn");

	public void clickFirstDeleteButton() {

		WebElement deleteButton = driver.findElements(deleteButtons).get(0);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", deleteButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton);
	}

//	Delete — verify the actual row is removed

	private By firstActionRowName = By.cssSelector("#actionTable tbody tr:first-child td:first-child");

	public String getFirstActionRowName() {

		return driver.findElement(firstActionRowName).getText();
	}

	public boolean isActionRowPresent(String name) {

		return driver
				.findElements(By.xpath("//table[@id='actionTable']//tbody//td[1][normalize-space()='" + name + "']"))
				.size() > 0;
	}

//	Page-navigations-----

	private By previousPageButton = By.id("prevPageBtn");

	private By nextPageButton = By.id("nextPageBtn");

	private By pageIndicator = By.id("pageIndicator");

	public String getPageIndicator() {

		return driver.findElement(pageIndicator).getText();
	}

	public boolean isPreviousPageDisabled() {

		return !driver.findElement(previousPageButton).isEnabled();
	}

	public boolean isNextPageEnabled() {

		return driver.findElement(nextPageButton).isEnabled();
	}

	public void clickNextPage() {

		WebElement nextButton = driver.findElement(nextPageButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", nextButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
	}

	private By firstPaginatedRowName = By.cssSelector("#paginatedTable tbody tr:first-child td:first-child");

	public String getFirstPaginatedRowName() {

		return driver.findElement(firstPaginatedRowName).getText();
	}

//	previouspage
	public void clickPreviousPage() {

		WebElement previousButton = driver.findElement(previousPageButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", previousButton);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", previousButton);
	}

//	last page boundary.---
	public boolean isNextPageDisabled() {

		return !driver.findElement(nextPageButton).isEnabled();
	}

}