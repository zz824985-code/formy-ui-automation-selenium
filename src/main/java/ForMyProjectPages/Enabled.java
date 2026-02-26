package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enabled extends BasePage{
    private final By disabledTextBox = By.id("disabledInput");
    private final By enabledTextBox = By.id("input");
    public Enabled(WebDriver driver){
        super(driver);
    }

    public boolean checkDisabledTextBox(){
        WebElement element = waitVisible(disabledTextBox);
        boolean enabled = element.isEnabled();
        String attribute =  element.getDomAttribute("disabled");
        return !enabled && attribute != null;
    }
    public void setEnabledTextBox(String testData){type(enabledTextBox, testData);}
    public String getEnabledTextBoxValue(){ return getInputValue(enabledTextBox);}
}
