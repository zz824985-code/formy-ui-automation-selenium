package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessPage extends BasePage{
    private final By successMessage = By.cssSelector("div.alert.alert-success");


    public SuccessPage(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }
    public String getSuccessMessage(){
        return find(successMessage).getText().trim();
    }
}
