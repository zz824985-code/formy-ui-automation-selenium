package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBox extends BasePage{
    private final By checkBoxes = By.cssSelector("input[type='checkbox']");

    public CheckBox(WebDriver driver){super(driver);
    }

    public int clickCheckBox(){
        List<WebElement> options = findMany(checkBoxes);
       if (options.isEmpty()){
           throw new IllegalStateException("No checkboxes found on the page");
       }
        int option = randomIndex(options.size());
        options.get(option).click();
        return option;
    }
    public int getCheckboxesCount(){
        return waitVisibleAll(checkBoxes).size();
    }
    public boolean isCheckBoxSelected(int index){
        return waitVisibleAll(checkBoxes).get(index).isSelected();
    }

}
