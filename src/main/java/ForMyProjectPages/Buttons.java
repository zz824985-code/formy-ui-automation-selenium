package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Buttons extends BasePage{

    private final By primaryButton = By.cssSelector(".btn.btn-lg.btn-primary");
    private final By successButton = By.cssSelector(".btn.btn-lg.btn-success");
    private final By infoButton = By.cssSelector(".btn.btn-lg.btn-info");
    private final By warningButton = By.cssSelector(".btn.btn-lg.btn-warning");
    private final By dangerButton = By.cssSelector(".btn.btn-lg.btn-danger");
    private final By linkButton = By.cssSelector(".btn.btn-lg.btn-link");
    private final By leftButton = By.xpath(
            "//div[@aria-label='Basic example']//button[normalize-space()='Left']");
    private final By middleButton = By.xpath(
            "//div[@aria-label='Basic example']//button[normalize-space()='Middle']");
    private final By rightButton = By.xpath(
            "//div[@aria-label='Basic example']//button[normalize-space()='Right']");
    private final By nestedDropdown = By.id("btnGroupDrop1");
    private final By dropdownItems = By.cssSelector(".dropdown-menu.show .dropdown-item");

    public Buttons(WebDriver driver) {super(driver);}

    public void clickPrimaryButton(){
        click(primaryButton);}
    public void clickSuccessButton(){
        click(successButton);}
    public void clickInfoButton(){
        click(infoButton);}
    public void clickWarningButton(){
        click(warningButton);}
    public void clickDangerButton(){
        find(dangerButton).click();}
    public void clickLinkButton(){
        click(linkButton);}
    public void clickLeftButton(){
        click(leftButton);}
    public void clickMiddleButton(){
        click(middleButton);}
    public void clickRightButton(){
        click(rightButton);}

    public void selectFromNestedDropdown(){
       click(nestedDropdown);
        List<WebElement> options =
                findMany(dropdownItems);
        int optionsCount = options.size();
        int minValue = 1;
        int maxValue = optionsCount - 1;
        int randomValue = minValue + randomIndex(maxValue - minValue + 1);
        System.out.println("I chose this option this time: " + randomValue);
        options.get(randomValue).click();
    }


    public void clickNumberButton(int number){
        driver.findElement(numberButton(String.valueOf(number))).click();
    }

    public boolean isPrimaryButtonVisible(){ return waitVisible(primaryButton).isDisplayed();}
    public boolean isSuccessButtonVisible(){ return waitVisible(successButton).isDisplayed();}
    public boolean isInfoButtonVisible(){ return waitVisible(infoButton).isDisplayed();}
    public boolean isWarningButtonVisible(){ return waitVisible(warningButton).isDisplayed();}
    public boolean isDangerButtonVisible(){ return waitVisible(dangerButton).isDisplayed();}
    public boolean isLinkButtonVisible(){ return waitVisible(linkButton).isDisplayed();}
    public boolean isLeftButtonVisible(){ return waitVisible(leftButton).isDisplayed();}
    public boolean isMiddleButtonVisible(){ return waitVisible(middleButton).isDisplayed();}
    public boolean isRightButtonVisible(){ return waitVisible(rightButton).isDisplayed();}

    public boolean isOnButtonsPage(){ return driver.getCurrentUrl().contains("/buttons"); }

    public int openNestedDropdownAndGetOptionsCount(){
        click(nestedDropdown);
       List <WebElement> options;
       options = findMany(dropdownItems);
       return options.size();
    }





    private By numberButton(String number){ //This is a utility method
        return By.xpath(
                "//div[@aria-label='Button group with nested dropdown']" +
                        "//button[normalize-space()='" + number + "']");
    }

}