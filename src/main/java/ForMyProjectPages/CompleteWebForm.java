package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class CompleteWebForm extends BasePage{
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By jobTitleField = By.id("job-title");
    private final By eduButton = By.cssSelector("input[type='radio'][id^='radio-button-']");
    private final By sexCheckBox = By.cssSelector("input[type='checkbox'][id^='checkbox-'");
    private final By experienceDropdown = By.id("select-menu");
    private final By datePickerField = By.id("datepicker");
    private final By submitButton = By.cssSelector("a[href='/thanks']");

    public CompleteWebForm(WebDriver driver){super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    public void setFirstNameField(String John){
        find(firstNameField).sendKeys(John);}
    public void setLastNameField(String Pork){
        find(lastNameField).sendKeys(Pork);}
    public void setJobTitleField(String ProjectManager){
        find(jobTitleField).sendKeys(ProjectManager);}
    public void clickEduButton(){
        List<WebElement> options = findMany(eduButton);
        int option = randomIndex(options.size());
        System.out.println("Education option: " + option);
        options.get(option).click();}
    public void clickCheckBox(){
        List<WebElement> options = findMany(sexCheckBox);
        int option = randomIndex(options.size());
        System.out.println("Sex option:" + option);
        options.get(option).click();}
    public void selectFromDropDown(){
        Select dropdownOptions = new Select(find(experienceDropdown));
        int optionsCount = dropdownOptions.getOptions().size();
        int minValue = 1;
        int maxValue = optionsCount - 1;
        int randomValue = minValue + randomIndex(maxValue - minValue + 1);
        System.out.println("I chose this option this time: " + randomValue);
        dropdownOptions.selectByIndex(randomValue);
    }
    public void setDatePickerField(){
        LocalDate todayDateTest = LocalDate.now();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = todayDateTest.format(timeFormatter);
        System.out.println("Today's date: " + formattedDate);
        find(datePickerField).sendKeys(formattedDate);
    }
    public SuccessPage clickSubmitButton(){
        find(submitButton).click();
        return new SuccessPage(driver);
    }

}
