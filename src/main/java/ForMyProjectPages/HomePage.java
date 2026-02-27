package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);}

    public AutoCompletePage clickAutoComplete(){
        clickPageLink("Autocomplete");
        return new AutoCompletePage(driver);
    }
    public Buttons clickButtons(){
        clickPageLink("Buttons");
        return new Buttons(driver);
    }
    public CheckBox clickCheckBox(){
        clickPageLink("Checkbox");
        return new CheckBox(driver);
    }
    public DragAndDropPage clickDragAndDrop(){
        clickPageLink("Drag and Drop");
        return new DragAndDropPage(driver);
    }
    public DropdownPage clickDropdownPage(){
        clickPageLink("Dropdown");
        return new DropdownPage(driver);
    }
    public Enabled clickEnabled(){
        clickPageLink("Enabled and disabled elements");
        return new Enabled(driver);
    }
    public FileUpload clickFileUpload(){
        clickPageLink("File Upload");
        return new FileUpload(driver);
    }
    public KeyAndMouse clickKeyAndMouse(){
        clickPageLink("Key and Mouse Press");
        return new KeyAndMouse(driver);
    }




    public CompleteWebForm clickWebForm(){
        clickPageLink("Complete Web Form");
        return new CompleteWebForm(driver);
    }
    private void clickPageLink(String linkText){
        find(By.linkText(linkText)).click();
    }
}
