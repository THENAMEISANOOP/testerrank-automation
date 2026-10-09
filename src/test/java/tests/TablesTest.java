package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.TablesPage;
import pages.TopicsPage;

public class TablesTest extends BaseTest {

	private TopicsPage topicsPage;
	private TablesPage tablesPage;

	@BeforeMethod
	public void openTablesPage() {

		topicsPage = new TopicsPage(driver);

		topicsPage.clickTables();

		tablesPage = new TablesPage(driver);
	}

	@Test(priority = 1)
	public void verifyBasicTableRowCount() {

		int rowCount = tablesPage.getRowCount();

		System.out.println("Table Row Count: " + rowCount);

		Assert.assertEquals(rowCount, 5);
	}

	@Test(priority = 2)
	public void verifyBasicTableRowCountText() {

		String text = tablesPage.getRowCountText();

		System.out.println("Row Count Text: " + text);

		Assert.assertEquals(text, "Rows: 5");
	}

	@Test(priority = 3)
	public void verifyBasicTableCellValues() {

		String name = tablesPage.getCellValue(1, 1);

		String department = tablesPage.getCellValue(1, 2);

		String salary = tablesPage.getCellValue(1, 3);

		String location = tablesPage.getCellValue(1, 4);

		System.out.println("Name: " + name);
		System.out.println("Department: " + department);
		System.out.println("Salary: " + salary);
		System.out.println("Location: " + location);

		Assert.assertEquals(name, "Aarav Sharma");
		Assert.assertEquals(department, "Engineering");
		Assert.assertEquals(salary, "12,00,000");
		Assert.assertEquals(location, "Bangalore");
	}

	@Test(priority = 4)
	public void verifyNameColumnSortingBothWays() {

		// First click → descending
		tablesPage.clickNameHeader();

		String descendingState = tablesPage.getSortState();

		String firstNameDescending = tablesPage.getFirstSortableTableName();

		System.out.println("After First Click: " + descendingState);

		System.out.println("First Name: " + firstNameDescending);

		Assert.assertEquals(descendingState, "Sorted by: name (desc)");

		Assert.assertEquals(firstNameDescending, "Sanya Bose");

		// Second click → ascending
		tablesPage.clickNameHeader();

		String ascendingState = tablesPage.getSortState();

		String firstNameAscending = tablesPage.getFirstSortableTableName();

		System.out.println("After Second Click: " + ascendingState);

		System.out.println("First Name: " + firstNameAscending);

		Assert.assertEquals(ascendingState, "Sorted by: name (asc)");

		Assert.assertEquals(firstNameAscending, "Arjun Mehta");
	}

	@Test(priority = 5)
	public void verifyAgeColumnSortingBothWays() {

		// First click → ascending
		tablesPage.clickAgeHeader();

		String ascendingState = tablesPage.getSortState();

		String firstAgeAscending = tablesPage.getFirstSortableTableAge();

		System.out.println("After First Click: " + ascendingState);

		System.out.println("First Age: " + firstAgeAscending);

		Assert.assertEquals(ascendingState, "Sorted by: age (asc)");

		Assert.assertEquals(firstAgeAscending, "25");

		// Second click → descending
		tablesPage.clickAgeHeader();

		String descendingState = tablesPage.getSortState();

		String firstAgeDescending = tablesPage.getFirstSortableTableAge();

		System.out.println("After Second Click: " + descendingState);

		System.out.println("First Age: " + firstAgeDescending);

		Assert.assertEquals(descendingState, "Sorted by: age (desc)");

		Assert.assertEquals(firstAgeDescending, "35");
	}

	@Test(priority = 6)
	public void verifyDepartmentColumnSortingBothWays() {

		// First click → ascending
		tablesPage.clickDepartmentHeader();

		String ascendingState = tablesPage.getSortState();

		String firstDepartmentAscending = tablesPage.getFirstSortableTableDepartment();

		System.out.println("After First Click: " + ascendingState);

		System.out.println("First Department: " + firstDepartmentAscending);

		Assert.assertEquals(ascendingState, "Sorted by: department (asc)");

		Assert.assertEquals(firstDepartmentAscending, "Design");

		// Second click → descending
		tablesPage.clickDepartmentHeader();

		String descendingState = tablesPage.getSortState();

		String firstDepartmentDescending = tablesPage.getFirstSortableTableDepartment();

		System.out.println("After Second Click: " + descendingState);

		System.out.println("First Department: " + firstDepartmentDescending);

		Assert.assertEquals(descendingState, "Sorted by: department (desc)");

		Assert.assertEquals(firstDepartmentDescending, "Marketing");
	}

	@Test(priority = 7)
	public void verifySalaryColumnSortingBothWays() {

		// First click → ascending
		tablesPage.clickSalaryHeader();

		String ascendingState = tablesPage.getSortState();

		String firstSalaryAscending = tablesPage.getFirstSortableTableSalary();

		System.out.println("After First Click: " + ascendingState);

		System.out.println("First Salary: " + firstSalaryAscending);

		Assert.assertEquals(ascendingState, "Sorted by: salary (asc)");

		Assert.assertEquals(firstSalaryAscending, "6,80,000");

		// Second click → descending
		tablesPage.clickSalaryHeader();

		String descendingState = tablesPage.getSortState();

		String firstSalaryDescending = tablesPage.getFirstSortableTableSalary();

		System.out.println("After Second Click: " + descendingState);

		System.out.println("First Salary: " + firstSalaryDescending);

		Assert.assertEquals(descendingState, "Sorted by: salary (desc)");

		Assert.assertEquals(firstSalaryDescending, "13,50,000");
	}

	@Test(priority = 8)
	public void verifyFilterByProductName() {

		tablesPage.searchProduct("Laptop");

		String result = tablesPage.getFilterResultCount();

		System.out.println("Filter Result: " + result);

		Assert.assertEquals(result, "Showing 1 of 10 products");
	}

	@Test(priority = 9)
	public void verifyFilterByCategory() {

		tablesPage.searchProduct("Accessories");

		String result = tablesPage.getFilterResultCount();

		System.out.println("Filter Result: " + result);

		Assert.assertEquals(result, "Showing 3 of 10 products");
	}

	@Test(priority = 10)
	public void verifyFilterByPrice() {

		tablesPage.searchProduct("89999");

		String result = tablesPage.getFilterResultCount();

		System.out.println("Filter Result: " + result);

		Assert.assertEquals(result, "Showing 1 of 10 products");
	}

	@Test(priority = 11)
	public void verifyAllProductsDisplayed() {

		String result = tablesPage.getFilterResultCount();

		System.out.println("Filter Result: " + result);

		Assert.assertEquals(result, "Showing 10 of 10 products");
	}

	@Test(priority = 12)
	public void verifyEditAction() {

		tablesPage.clickFirstEditButton();

		tablesPage.updateFirstRowData("Amit Updated", "amit.updated@example.com", "Senior Developer");

		tablesPage.clickFirstRowSaveButton();

		String result = tablesPage.getFirstActionRowData();

		String rowCount = tablesPage.getActionRowCount();

		System.out.println("Updated Row Data: " + result);

		System.out.println("Row Count: " + rowCount);

		Assert.assertTrue(result.contains("Amit Updated"));

		Assert.assertTrue(result.contains("amit.updated@example.com"));

		Assert.assertTrue(result.contains("Senior Developer"));

		Assert.assertEquals(rowCount, "Rows: 5 | Editing: None");
	}

	@Test(priority = 13)
	public void verifyCancelAction() {

		tablesPage.clickFirstEditButton();

		tablesPage.updateFirstRowData("Changed Name", "changed@example.com", "Changed Role");

		tablesPage.clickFirstRowCancelButton();

		String result = tablesPage.getFirstActionRowData();

		String rowCount = tablesPage.getActionRowCount();

		System.out.println("Row Data After Cancel: " + result);

		System.out.println("Row Count: " + rowCount);

		Assert.assertTrue(result.contains("Amit Kumar"));

		Assert.assertTrue(result.contains("amit@example.com"));

		Assert.assertTrue(result.contains("Developer"));

		Assert.assertEquals(rowCount, "Rows: 5 | Editing: None");
	}

	@Test(priority = 14)
	public void verifyDeleteAction() {

		String deletedName = tablesPage.getFirstActionRowName();

		tablesPage.clickFirstDeleteButton();

		String result = tablesPage.getActionRowCount();

		boolean rowStillPresent = tablesPage.isActionRowPresent(deletedName);

		System.out.println("Deleted Row: " + deletedName);
		System.out.println("Action Result: " + result);
		System.out.println("Row Still Present: " + rowStillPresent);

		Assert.assertEquals(result, "Rows: 4 | Editing: None");

		Assert.assertFalse(rowStillPresent);
	}

	// pagination--tabel--
	@Test(priority = 15)
	public void verifyInitialPaginationState() {

		String page = tablesPage.getPageIndicator();

		boolean previousDisabled = tablesPage.isPreviousPageDisabled();

		boolean nextEnabled = tablesPage.isNextPageEnabled();

		System.out.println("Page: " + page);

		System.out.println("Previous Disabled: " + previousDisabled);

		System.out.println("Next Enabled: " + nextEnabled);

		Assert.assertEquals(page, "Page 1 of 5");

		Assert.assertTrue(previousDisabled);

		Assert.assertTrue(nextEnabled);
	}

	@Test(priority = 16)
	public void verifyNextPage() {

		String page1Name = tablesPage.getFirstPaginatedRowName();

		tablesPage.clickNextPage();

		String page = tablesPage.getPageIndicator();

		String page2Name = tablesPage.getFirstPaginatedRowName();

		System.out.println("Page 1 First Row: " + page1Name);

		System.out.println("Current Page: " + page);

		System.out.println("Page 2 First Row: " + page2Name);

		Assert.assertEquals(page1Name, "Aditi Sharma");

		Assert.assertEquals(page, "Page 2 of 5");

		Assert.assertNotEquals(page2Name, page1Name);
	}

	@Test(priority = 17)
	public void verifyPreviousPage() {

		String page1Name = tablesPage.getFirstPaginatedRowName();

		tablesPage.clickNextPage();

		tablesPage.clickPreviousPage();

		String page = tablesPage.getPageIndicator();

		String currentFirstRow = tablesPage.getFirstPaginatedRowName();

		System.out.println("Current Page: " + page);

		System.out.println("First Row After Previous: " + currentFirstRow);

		Assert.assertEquals(page, "Page 1 of 5");

		Assert.assertEquals(currentFirstRow, page1Name);
	}

//	last page boundary.--

	@Test(priority = 18)
	public void verifyLastPage() {

		tablesPage.clickNextPage();
		tablesPage.clickNextPage();
		tablesPage.clickNextPage();
		tablesPage.clickNextPage();

		String page = tablesPage.getPageIndicator();

		boolean nextDisabled = tablesPage.isNextPageDisabled();

		boolean previousEnabled = !tablesPage.isPreviousPageDisabled();

		String firstRow = tablesPage.getFirstPaginatedRowName();

		System.out.println("Current Page: " + page);

		System.out.println("Next Disabled: " + nextDisabled);

		System.out.println("Previous Enabled: " + previousEnabled);

		System.out.println("First Row on Last Page: " + firstRow);

		Assert.assertEquals(page, "Page 5 of 5");

		Assert.assertTrue(nextDisabled);

		Assert.assertTrue(previousEnabled);

		Assert.assertNotEquals(firstRow, "Aditi Sharma");
	}

//	Page 5 → Page 4 validation.---

	@Test(priority = 19)
	public void verifyPreviousFromLastPage() {

		tablesPage.clickNextPage();
		tablesPage.clickNextPage();
		tablesPage.clickNextPage();
		tablesPage.clickNextPage();

		tablesPage.clickPreviousPage();

		String page = tablesPage.getPageIndicator();

		String firstRow = tablesPage.getFirstPaginatedRowName();

		System.out.println("Current Page: " + page);

		System.out.println("First Row on Page 4: " + firstRow);

		Assert.assertEquals(page, "Page 4 of 5");

		Assert.assertNotEquals(firstRow, "Umesh Tiwari");
	}
}