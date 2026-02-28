package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyAndMouse extends BasePage{

    private final By fullNameTextbox = By.id("name");
    private final By submitButton = By.id("button");

    public KeyAndMouse(WebDriver driver){
        super(driver);
        waitVisible(fullNameTextbox);
    }
    public void setFullNameTextbox(String fullName){ type(fullNameTextbox, fullName);}
    public String getFullNameValue(){ return getInputValue(fullNameTextbox);}
    public void clickSubmitButton(){ click(submitButton);}
    public boolean isTextBoxEmpty(){
        String inputValue = getInputValue(fullNameTextbox);
        return inputValue == null || inputValue.isEmpty();
    }
}
