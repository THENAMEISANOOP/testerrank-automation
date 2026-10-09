package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DropdownsPage;
import pages.TopicsPage;

public class DropdownsTest extends BaseTest {

	private TopicsPage topicsPage;
	private DropdownsPage dropdownsPage;

	@BeforeMethod
	public void openDropdownsPage() {

		topicsPage = new TopicsPage(driver);

		topicsPage.clickDropdowns();

		dropdownsPage = new DropdownsPage(driver);
	}

	@Test(priority = 1)
	public void verifyCountryDropdown() {

		dropdownsPage.selectCountry("India");

		System.out.println("Selected Country: " + dropdownsPage.getSelectedCountry());

		Assert.assertEquals(dropdownsPage.getSelectedCountry(), "India");
	}

//
	@Test(priority = 2)
	public void verifyTechnologyDropdown() {

		dropdownsPage.selectTechnology("Java");

		System.out.println("Selected Technology: " + dropdownsPage.getSelectedTechnology());

		Assert.assertEquals(dropdownsPage.getSelectedTechnology(), "Java");

	}

	@Test(priority = 3)
	public void verifyDependentDropdown() {

		dropdownsPage.selectStateCountry("India");

		dropdownsPage.selectState("Karnataka");

		System.out.println("Selected Country: " + dropdownsPage.getSelectedStateCountry());

		System.out.println("Selected State: " + dropdownsPage.getSelectedState());

		Assert.assertEquals(dropdownsPage.getSelectedStateCountry(), "India");

		Assert.assertEquals(dropdownsPage.getSelectedState(), "Karnataka");
	}

	@Test(priority = 4)
	public void verifyMultiSelectDropdown() {

		dropdownsPage.selectSkill("Java");
		dropdownsPage.selectSkill("Selenium");

		System.out.println("Selected Skills: " + dropdownsPage.getSelectedSkills());

		Assert.assertTrue(dropdownsPage.getSelectedSkills().contains("Java"));

		Assert.assertTrue(dropdownsPage.getSelectedSkills().contains("Selenium"));
	}

	@Test(priority = 5)
	public void verifySearchableDropdown() {

		dropdownsPage.searchProgrammingLanguage("Python");

		System.out.println("Selected Programming Language: " + dropdownsPage.getSelectedProgrammingLanguage());

		Assert.assertEquals(dropdownsPage.getSelectedProgrammingLanguage(), "Selected: Python");
	}

	@Test(priority = 6)
	public void verifyDynamicDropdown() {

		dropdownsPage.loadDynamicOptions();

		dropdownsPage.selectDynamicOption("Option Gamma");

		System.out.println("Selected Dynamic Option: " + dropdownsPage.getSelectedDynamicOption());

		Assert.assertEquals(dropdownsPage.getSelectedDynamicOption(), "Option Gamma");
	}

}