package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import  org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PageScroll extends BasePage{
    private final By nameTextBox = By.id("name");
    private final By dateTextBox = By.id("date");

    public PageScroll(WebDriver driver) {
        super(driver);
        waitVisible(nameTextBox);
    }
    public void setNameTextBox(String name){
        WebElement nameBox = find(nameTextBox);
        Actions action = new Actions(driver);
        action
               .scrollToElement(nameBox)
                       .perform();
        type(nameTextBox, name);
    }
    public void setDateTextBox(){
        LocalDate todayDateTest = LocalDate.now();

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = todayDateTest.format(timeFormatter);
        System.out.println("Today's date: " + formattedDate);
        find(dateTextBox).sendKeys(formattedDate);
    }
    public String getNameValue(){
        return getInputValue(nameTextBox);
    }
    public String getDateValue(){
        return getInputValue(dateTextBox);
    }
}
