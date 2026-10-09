# TesterRank Automation Testing Project

## Project Overview

This project automates the testing of different features available on the [TesterRank website](https://www.testerrank.com/topics) using Selenium WebDriver, Java, TestNG, and Maven.

The main goal of this project is to practice UI automation testing, validate application functionality, and identify potential issues through automated test cases.

## Technologies Used

- **Programming Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Testing Framework:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **IDE:** Eclipse
- **Browser:** Google Chrome
- **Version Control:** Git and GitHub

## Features Automated

The following website features are covered by automated test cases:

- Forms and Inputs
- Dropdowns
- Checkboxes and Radio Buttons
- Alerts and Pop-ups
- Tables
- File Upload
- File Download
- Accordions and Tabs

## Framework Structure

The project follows the Page Object Model (POM) design pattern to separate page locators and actions from test methods.

- `src/main/java/pages` – Page classes containing locators and page actions.
- `src/main/java/utils` – Reusable utility classes.
- `src/test/java/base` – Base test setup and teardown.
- `src/test/java/tests` – Test classes containing automated test cases.
- `test-data` – Files used during testing.
- `testng.xml` – TestNG suite configuration.
- `pom.xml` – Maven dependencies and project configuration.
- `.gitignore` – Excludes generated files and folders from Git.

## How to Run the Tests

1. Clone or download this repository.
2. Import the project into Eclipse as an existing Maven project.
3. Allow Maven to download the required dependencies.
4. Ensure Google Chrome is installed.
5. Open `testng.xml`.
6. Right-click the file and select **Run As → TestNG Suite**.

## Test Results

The test suite has completed successfully with the following results in the current test run:

- **Total Tests:** 75
- **Passed:** 75
- **Failed:** 0
- **Skipped:** 0

*Results may vary when tests are executed again.*

## Learning Objectives

This project demonstrates practical experience with:

- Writing and executing Selenium automation scripts.
- Organizing automation code using the Page Object Model.
- Creating and executing TestNG test suites.
- Using Maven to manage project dependencies.
- Validating web elements and application behavior.
- Managing automation projects using Git and GitHub.

## Author

**Anoop**

GitHub: [THENAMEISANOOP](https://github.com/THENAMEISANOOP)

---

*This is a learning and portfolio project created to develop practical skills in software testing and test automation.*
