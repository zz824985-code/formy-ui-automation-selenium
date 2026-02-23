# Formy UI Automation (Java + Selenium)
This is my first UI autotesting project on a website https://formy-project.herokuapp.com/

---

# Tech Stack 
- Java 17+
- Maven
- Selenium WebDriver 4.x
- Junit 5 (Jupiter)

  All Dependencies are managed via 'pom.xml'.

---

# Project Goals

  - Practise clean Page Object design patterns
  - Practise structuring UI tests in JUnit 5
  - Try implementing basic waits, randomization and small utilities in a test framework
  - Prepare a simple, but "alive" first project for Github portfolio

---

#Project Structure
src
├── main
│   └── java
│       └── ForMyProjectPages
│           ├── BasePage.java          # Common WebDriver helpers
│           ├── HomePage.java          # Entry point, navigation to components
│           ├── CompleteWebForm.java   # Full form page
│           ├── AutoCompletePage.java  # Address autocomplete fields
│           ├── Buttons.java           # Various buttons + nested dropdown
│           ├── CheckBox.java          # Random checkbox selection
│           └── SuccessPage.java       # “Thanks” page after form submit
│
└── test
└── java
├── Base
│   └── BaseFormy.java         # Base test: driver setup / teardown, homePage
├── WebFormTest                # Tests for CompleteWebForm
├── AutoCompleteTests          # URL + field-value tests for autocomplete
├── ButtonsTests               # Visibility / clickability / dropdown tests
└── CheckBoxTests              # Random checkbox index & state tests

> Folder / class names may change slightly as the project will continue to grow.

---

## Page Object Design 

### 'BasePage'

All page classes extend 'BasePage'.
It keeps shared WebDriver utilities:

- 'protected final WebDriver driver'
- 'protected final WebDriverWait wait'
- 'protected final Random random'

  Helper methods:
  - 'find(By locator)' - finds single element
  - 'findMany(By locator)' - finds list of elements
  - 'waitVisible(By locator)' - waits until element is visible
  - 'click(By locator)' - waits and then clicks element
  - 'type(By locator, String text)' - waits, then clears field and sends keys
  - 'getInputValue(By locator)' - reads current value from input
  - 'randomIndex(int size)' - generates random index in '[0, size)'

  This type of method design helps me keep page classes focused on **what** the do, not **how** they they comunicate Selenium.

### Example pages 

 - **HomePage** - has navigation methods like 'clickCompleteWebForm()', 'clickAutoComplete()', 'clickButtons()', etc., each returning the corresponding Page Object.
 - **CompleteWebForm** - methods for filling each field, selecting options, choosing a date, clicking Submit and transitioning to 'SuccessPage'.
 - **AutoCompletePage** - methods like 'SetAddress', 'setCity', 'setZipCode' and corresponding getters that read input values for assertions.
 - **Buttons** - methods to click all main buttons, Left/Middle/Right group, and open a nested dropdown + get its option count.
 - **CheckBox** - select a random checkbox, returns its index, and exposes a method to verify that the checkbox with that index is selected.

---

## Tests

All test classes extend 'BaseFormy', which:

- Creates and configures 'WebDriver'
- Opens the Formy home page before each test
- Exposes a 'homePage' field to start to start navigation
- Handles driver teardown after tests

### Current test coverage 

**Complete Web Form**

- Filling all fields with valid data
- Submitting the form and verifying navigation to the success page

**Autocomplete**

- URL check after navigation to '/autocomplete'
- Field-level assertions using getter to verify that entered data is actually present in inputs

**Buttons**

- Navigates to the checkbox page
- Clicks a random checkbox
- Asserts that the checkbox with the returned index is selected

---

## How to Run the Tests

### Prerequisites

- Installed JDK 17+
- Installed Maven
- Google Chrome
- ChromeDriver available on your 'PATH' **or** configured in 'BaseFormy'
  (update the driver path / WebDriverManager configuration if your setup is different)

### Steps

'''bash
# clone repository
git clone https://github.com/zz824985-code/formy-ui-automation-selenium.git
cd formy-ui-automation-selenium

# run all tests
mvn test
  

  


  
