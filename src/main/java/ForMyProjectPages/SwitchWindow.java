package ForMyProjectPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SwitchWindow extends BasePage{
    private final By openNewTabButton = By.id("new-tab-button");
    private final By openAlertButton = By.id("alert-button");
    private String originalTabHandle;

    public SwitchWindow(WebDriver driver) {
        super(driver);
        waitVisible(openNewTabButton);
    }
    public void rememberCurrentTab(){
        originalTabHandle = driver.getWindowHandle();
    }
    public void clickOpenNewTabButton(){
        click(openNewTabButton);
    }
    public void switchToNewTab(){
        wait.until(d -> d.getWindowHandles().size() > 1);
        for (String handle : driver.getWindowHandles()){
            if (!handle.equals(originalTabHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    public void switchBackToOriginalTab(){
        driver.switchTo().window(originalTabHandle);
    }

    public void clickOpenAlertButton(){
        click(openAlertButton);
    }
    public String getAlertMessage(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
    public void AcceptAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
