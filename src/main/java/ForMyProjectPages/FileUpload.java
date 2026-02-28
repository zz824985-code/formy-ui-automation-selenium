package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload extends BasePage{
    private final By chooseTextBox = By.id("file-upload-field");
    private final By resetButton = By.cssSelector(".btn.btn-warning.btn-reset");

    public FileUpload(WebDriver driver){
        super(driver);
    }

    public boolean isOnFileUploadPage(){
       return driver.getCurrentUrl().contains("/fileupload");
    }
    public boolean isChooseTextboxVisible(){
        WebElement textbox = waitVisible(chooseTextBox);
        String placeholder = textbox.getDomAttribute("placeholder");
        return textbox.isDisplayed() && "Choose a file...".equals(placeholder);
    }
    public boolean isResetButtonVisible(){
        WebElement reset = waitVisible(resetButton);
        return reset.isDisplayed();
    }
}
