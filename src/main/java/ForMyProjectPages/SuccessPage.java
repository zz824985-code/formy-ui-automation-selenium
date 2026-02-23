package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage extends BasePage{
    private By successMessage = By.cssSelector("div.alert.alert-success");


    public SuccessPage(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
    }
    public String getSuccessMessage(){
        return find(successMessage).getText().trim();
    }
}
