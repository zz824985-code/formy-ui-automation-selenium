package Base;

import ForMyProjectPages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFormy {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");

        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
