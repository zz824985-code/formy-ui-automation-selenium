package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {
    private final By image = By.id("image");
    private final By box = By.id("box");


    public DragAndDropPage(WebDriver driver){
        super(driver);
        waitVisible(image);
    }
    public void dragImageToBox(){
        WebElement dropImage = find(image);
        WebElement dropBox = find(box);

        Actions action = new Actions(driver);
        action
                .clickAndHold(dropImage)
                .moveToElement(dropBox, 10, 10)
                .release()
                .build()
                .perform();
    }
    public String getDroppedMessage(){

        return waitVisible(box).getText().trim();}

}
