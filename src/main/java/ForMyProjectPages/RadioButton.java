package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButton extends BasePage {
    private final By radioButtonsGroup = By.cssSelector("input[type='radio'][name='exampleRadios']");


    public RadioButton(WebDriver driver) {
        super(driver);
        waitVisible(radioButtonsGroup);
    }
    public void clickRandomRadioButton(){
        List<WebElement> options = findMany(radioButtonsGroup);
        int option = randomIndex(options.size());
        System.out.println("Radio Button option: " + option);
        options.get(option).click();
    }
    public boolean isAnyRadioSelected(){
        List<WebElement> options = findMany(radioButtonsGroup);
        for (WebElement radio : options){
            if (radio.isSelected()){
                return true;
            }
        }
        return false;
    }
    public void clickRadioButtonByIndex(int index){
        List<WebElement> options = findMany(radioButtonsGroup);
        options.get(index).click();
    }

    public boolean isRadioSelected(int index){
        List<WebElement> options = findMany(radioButtonsGroup);
        return options.get(index).isSelected();
    }
}
