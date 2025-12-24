
# DemoQA - Selenium Automation

This project is a Selenium WebDriver automation suite built in Java. It tests various functionalities of the DemoQA website
including BookStore features, Widgets and Accordion menus. 

The project uses TestNG for test execution and reporting, and WebDriverManager to handle browser drivers automatically.

## System requirements / Environment SetUp

* **Operating System**: Windows 11

* **IDE**:  IntelliJ IDEA Community Edition 2025.2.3

* **Browser**: Google Chrome

* **WebDriver**: ChromeDriver (compatible with installed Chrome version)
* **Java Version**: JDK 25

* **Maven Version**: 3.8+

## Installation

1. **Open terminal in IDE and git clone the repository**

* ```git clone https://github.com/AleksandraJahic/DemoQA---Selenium-Automation.git```

2. **Open the project in IntelliJ IDEA**:

* File → Open → select project folder.

* IntelliJ will automatically detect the Maven project and download dependencies.

3. **Ensure Java is installed**

4. **Install required browser- Chrome**

5. **Download Maven dependencies:**

* ```mvn clean install```

## Executing the Program
**1. Run tests from IntelliJ:**

- Navigate to the Tests package → right-click on the test class → Run.

**2. Run tests via Maven command line:**

- ```mvn test```


**3. Test Reports:**

- TestNG generates a report in test-output folder.

- Open index.html to view results.
## Framework Walkthrough

The project follows a Page Object Model (POM) structure with Selenium and TestNG:

**Project Structure:**

- ```Base```: 
    - Contains BaseTest class with setup and teardown methods.

- ```Pages```
    - Contains page classes (e.g., AccordianPage, BookStore) encapsulating web elements and actions.

- ```Tests```

    - Contains test classes organized by feature.


* ```pom.xml```

    - Maven dependencies for Selenium, WebDriverManager, TestNG, Apache POI.

**Key Features**

* **Page Object Model (POM)**: Separates page elements and test logic.

* **WebDriverManager**: Automatically manages browser drivers.


* **Reusable Methods**: For clicking, scrolling, counting rows, verifying elements.

* **Assertions**: TestNG assertions validate UI behavior and element visibility.
## Notes

* Ensure Chrome is up-to-date to avoid driver compatibility issues.

* Banner elements or modals may interfere with tests; project handles some using JavaScript scroll or removal.

* Tests are designed to be independent; each test opens its own page context.
## Files

```.gitignore``` – Specifies files and folders to be ignored by Git (e.g., target/, .idea/, credentials).

```credentials.xlsx```- Excel file containing test data, such as login credentials or other inputs for tests. 

```pom.xml``` – Maven configuration file that manages project dependencies, plugins, and build settings.

```README.md``` – Project documentation file explaining setup, usage, and framework details.
## Author
**Name:** Aleksandra Jahić

**GitHub:** ```https://github.com/AleksandraJahic```

