package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class DropdownPage extends BasePage{
    private final By dropdown = By.id("dropdownMenuButton");
    private final By dropdownItemAutocomplete = By.cssSelector("a[href='/autocomplete']");
    private final By dropdownItemButtons = By.cssSelector("a[href='/buttons']");
    private final By dropdownItemCheckBox = By.cssSelector("a[href='/checkbox']");
    private final By dropdownItemDatepicker = By.cssSelector("a[href='/datepicker']");
    private final By dropdownItemDragDrop = By.cssSelector("a[href='/dragdrop']");
    private final By dropdownItemDropdown = By.cssSelector("a[href='/dropdown']");
    private final By dropdownItemEnabled = By.cssSelector("a[href='/enabled']");
    private final By dropdownItemFileUpload = By.cssSelector("a[href='/fileupload']");
    private final By dropdownItemFileDownload = By.cssSelector("a[href='/filedownload']");
    private final By dropdownItemKeyMouse = By.cssSelector("a[href='/keypress']");
    private final By dropdownItemModal = By.cssSelector("a[href='/modal']");
    private final By dropdownItemPageScroll = By.cssSelector("a[href='/scroll']");
    private final By dropdownItemRadioButton = By.cssSelector("a[href='/radiobutton']");
    private final By dropdownItemSwitchWindow = By.cssSelector("a[href='/switch-window']");
    private final By dropdownItemWebForm = By.cssSelector("a[href='/form']");

    public DropdownPage(WebDriver driver){
        super(driver);
    }

    public void selectFromDropdown(){click(dropdown);}
    public AutoCompletePage clickAutocomplete(){
        click(dropdownItemAutocomplete);
        return new AutoCompletePage(driver);
    }
    public Buttons clickButtons(){
        click(dropdownItemButtons);
        return new Buttons(driver);
    }
    public CheckBox clickCheckbox(){
        click(dropdownItemCheckBox);
        return new CheckBox(driver);
    }
    public Datepicker clickDatepicker(){
        click(dropdownItemDatepicker);
        return new Datepicker(driver);
    }
    public DragAndDropPage clickDragDrop(){
        click(dropdownItemDragDrop);
        return new DragAndDropPage(driver);
    }
    public void clickDropdown(){
        click(dropdownItemDropdown);
    }
    public Enabled clickEnabled(){
        click(dropdownItemEnabled);
        return new Enabled(driver);
    }
    public FileUpload clickFileUpload(){
        click(dropdownItemFileUpload);
        return new FileUpload(driver);
    }
    public FileDownload clickFileDownload(){
        click(dropdownItemFileDownload);
        return new FileDownload(driver);
    }
    public KeyAndMouse clickKeyMouse(){
        click(dropdownItemKeyMouse);
        return new KeyAndMouse(driver);
    }
    public Modal clickModal(){
        click(dropdownItemModal);
        return new Modal(driver);
    }
    public PageScroll clickPageScroll(){
        click(dropdownItemPageScroll);
        return new PageScroll(driver);
    }
    public RadioButton clickRadioButton(){
        click(dropdownItemRadioButton);
        return new RadioButton(driver);
    }
    public SwitchWindow clickSwitchWindow(){
        click(dropdownItemSwitchWindow);
        return new SwitchWindow(driver);
    }
    public CompleteWebForm clickCompleteWebForm(){
        click(dropdownItemWebForm);
        return new CompleteWebForm(driver);
    }

}
