package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Random random = new Random();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }
    protected List<WebElement> findMany(By locator){
        return driver.findElements(locator);
    }

    protected List<WebElement> waitVisibleAll(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
      waitVisible(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitVisible(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected void uploadFile(By locator, String absolutePath){
        WebElement fileInput = waitVisible(locator);
        fileInput.sendKeys(absolutePath);
    }
    protected int randomIndex(int size){return random.nextInt(size);}
    protected String getInputValue(By locator){
        WebElement element = waitVisible(locator);
        return element.getDomProperty("value");
    }
}