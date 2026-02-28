package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Modal extends BasePage{

    private final By modalButton = By.id("modal-button");
    private final By someTextMessage = By.cssSelector("div.modal-body");
    private final By modalHeading = By.id("exampleModalLabel");
    private final By crossButton = By.cssSelector("button[class=close]");
    private final By closeButton = By.id("close-button");
    private final By okButton = By.id("ok-button");

    public Modal(WebDriver driver){
        super(driver);
        waitVisible(modalButton);
    }

    public void clickModalButton(){ click(modalButton);}
    public String getSomeTextMessage(){ return  waitVisible(someTextMessage).getText().trim();}
    public void clickCrossButton(){ click(crossButton);}
    public void clickCloseButton(){ click(closeButton);}
    public void clickOkButton(){ click(okButton);}
    public boolean isModalStillUp(){
           var text = driver.findElements(modalHeading);
          if(text.isEmpty()){
              return false;
          }

           return !text.getFirst().isDisplayed();
       }


}
