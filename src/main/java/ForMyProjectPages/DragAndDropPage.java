package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DragAndDropPage extends BasePage {
    private final By image = By.id("image");
    private final By box = By.id("box");


    public DragAndDropPage(WebDriver driver){
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
    }
    public void clickAndDropImage(){
        WebElement dropImage = find(image);
        WebElement dropBox = find(box);

        Actions action = new Actions(driver);
        action.dragAndDrop(dropImage, dropBox).build().perform();
    }
    public String getDroppedMessage(){
        return find(box).getText().trim();}

}
