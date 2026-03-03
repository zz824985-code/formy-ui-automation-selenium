# Formy UI Automation (Java + Selenium)
Small UI test framework for the Formy demo website.
Uses Page Object pattern, JUnit 5 and Selenium 4.
Covers navigation and interactions for most components: forms, buttons, drag-and-drop, modals, alerts, multi-window, etc.
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

```text
src
 └── main
     └── java
         └── ForMyProjectPages
             ├── BasePage.java         # Common WebDriver helpers
             ├── HomePage.java         # Entry point, navigation
             ├── CompleteWebForm.java  # Full form page
             ├── AutoCompletePage.java # Address autocomplete
             ├── Buttons.java          # Various buttons + nested dropdown
             ├── CheckBox.java         # Random checkbox selection
             └── SuccessPage.java      # "Thanks" page

test
 └── java
     ├── Base
     │   └── BaseFormy.java            # Driver setup / teardown, homePage
     └── ...
     ├── WebFormTest                # Tests for CompleteWebForm
     ├── AutoCompleteTests          # URL + field-value tests for autocomplete
     ├── ButtonsTests               # Visibility / clickability / dropdown tests
     └── CheckBoxTests              # Random checkbox index & state tests

> Folder / class names may change slightly as the project will continue to grow.
 
```

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

- HomePage
  - Used as an entry point for all tests.
  - Navigation methods (`clickCompleteWebForm()`, clickAutoComplete(), clickButtons(), etc.) are exercised across the whole suite.

- CompleteWebForm
  - Fills all fields with valid data (name, email, date, radio, checkboxes, select, etc.).
  - Submits the form and verifies navigation to SuccessPage.
  - Uses getters to assert that the data shown in inputs matches what test code entered.

- AutoCompletePage
  - Types address into the autocomplete field.
  - Verifies that city / state / zip fields are populated with expected values.
  - Asserts that browser URL contains /autocomplete.

- Buttons
  - Verifies visibility and clickability of the main buttons.
  - Checks left / middle / right button behavior.
  - Opens the nested dropdown and validates that options are present.

- CheckBox
  - Selects a random checkbox by index from the list.
  - Returns this index to the test and asserts that the checkbox with this index is selected.
  - Covers both state (`isSelected`) and index consistency.

- Datepicker
  - Opens the datepicker widget and selects a date.
  - Asserts that the input contains the expected formatted date value.
  - Optionally covers clearing / re-entering a new date (depending on test implementation).

- DragAndDropPage
  - Performs drag-and-drop between two blocks on the page.
  - Asserts that their labels/text are swapped after the operation.
  - Uses a more reliable drag-and-drop approach instead of the flaky default one.

- DropdownPage
  - Opens the top dropdown menu and clicks items by locator.
  - Each click returns a specific Page Object (`AutoCompletePage`, Buttons, CompleteWebForm, etc.).
  - Example scenario: navigate via dropdown to CompleteWebForm and complete a full form submission flow.

- Enabled (Enabled and Disabled Elements)
  - Types into the enabled input and verifies that the value is stored.
  - Asserts that the disabled input is present but not editable.
  - Optionally checks that disabled input has the expected disabled attribute.

- FileUpload
  - Verifies that the "Choose a file…" textbox is visible.
  - Checks that the Reset button is visible and clickable.
  - Confirms that the URL contains /fileupload.
  - (No real file upload is performed because the page exposes only a type="text" input.)

- FileDownload (broken link from dropdown)
  - Navigates to the page via dropdown item.
  - Asserts that the error message “The page you were looking for doesn't exist.” is displayed.
  - Verifies that the application shows a proper error state instead of a blank page.

- KeyAndMouse (Keyboard and Mouse Input)
  - Types a full name into the input field.
  - Uses a getter to assert that the typed name is present in the textbox.
  - Clicks Submit and verifies that the textbox is cleared afterwards.

- Modal
  - Opens the modal dialog via the main button.
  - Reads and verifies the modal body text (e.g. “Some text here”).
  - Closes the modal using the “X” and/or “Close” button and asserts that the header is no longer visible.

- PageScroll
  - Scrolls the long page until the form fields become visible.
  - Fills in the Full Name field.
  - Inserts today’s date in the Date field using a `LocalDate`-based formatter.
  - Asserts that both fields contain the expected values.

- RadioButton
  - Selects a radio button by a fixed index and verifies that it is selected.
  - Selects a random radio button using a helper method and asserts that the returned index is actually checked.
  - Ensures only one option in the group is active.

- SuccessPage
  - Verifies that the success message is displayed after form submission.
  - Asserts that the message text matches the expected “form was successfully submitted” copy.

- SwitchWindow
  - Clicks “Open new tab”, switches to the new tab and verifies that the URL points to the Formy homepage.
  - Switches back to the original tab and asserts that the URL is /switch-window.
  - Clicks “Open alert”, reads the alert text (e.g. “This is a test alert!”) and accepts the alert.
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
  

  


  
