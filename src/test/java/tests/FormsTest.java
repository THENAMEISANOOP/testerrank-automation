
package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FormsPage;
import pages.TopicsPage;

public class FormsTest extends BaseTest {

	private TopicsPage topicsPage;
	private FormsPage formsPage;

	@BeforeMethod
	public void openFormsPage() {

		topicsPage = new TopicsPage(driver);

		topicsPage.clickForms();

		formsPage = new FormsPage(driver);
	}

	@Test(priority = 1)
	public void verifyTextFields() {

		formsPage.enterFullName("Anoop");

		formsPage.clickFullNameSubmit();

		formsPage.enterEmail("anoop123@gmail.com");

		formsPage.enterPassword("Test@123");

		formsPage.clickPasswordShowHide();

		formsPage.enterCurrentAddress("Kerala, India");

		Assert.assertEquals(formsPage.getFullName(), "Anoop");

		Assert.assertEquals(formsPage.getEmail(), "anoop123@gmail.com");

		Assert.assertEquals(formsPage.getPassword(), "Test@123");

		Assert.assertEquals(formsPage.getCurrentAddress(), "Kerala, India");
	}

	@Test(priority = 2)
	public void verifySpecialInputs() {

		formsPage.enterBirthDate("05152000");

		Assert.assertEquals(formsPage.getBirthDate(), "2000-05-15");

		Assert.assertTrue(formsPage.isDisabledFieldDisabled());

		Assert.assertEquals(formsPage.getDisabledFieldValue(), "This field is disabled");

		Assert.assertTrue(formsPage.isReadonlyFieldReadonly());

		Assert.assertEquals(formsPage.getReadonlyFieldValue(), "This field is readonly");

		formsPage.enterCity("Delhi");

		Assert.assertEquals(formsPage.getCity(), "Delhi");
	}

	@Test(priority = 3)
	public void verifyStudentRegistration() {

		formsPage.enterFirstName("Anoop");

		formsPage.enterLastName("S");

		formsPage.enterRegistrationEmail("anoop123@gmail.com");

		formsPage.enterPhone("9656081913");

		formsPage.selectMale();

		formsPage.enterRegistrationAddress("Kerala, India");

		formsPage.selectTerms();

		formsPage.clickRegister();

		Assert.assertEquals(formsPage.getRegistrationSuccessMessage(), "Registration successful!");
	}

	@Test(priority = 4)
	public void verifyEmptyRegistrationValidation() {

		formsPage.clickRegister();

		Assert.assertEquals(formsPage.getFirstNameError(), "First name is required");

		Assert.assertEquals(formsPage.getLastNameError(), "Last name is required");

		Assert.assertEquals(formsPage.getRegistrationEmailError(), "Email is required");

		Assert.assertEquals(formsPage.getPhoneError(), "Phone number is required");

		Assert.assertEquals(formsPage.getGenderError(), "Please select a gender");

		Assert.assertEquals(formsPage.getAddressError(), "Address is required");

		Assert.assertEquals(formsPage.getTermsError(), "You must agree to the terms");
	}
}
