package SwitchWindowTests;

import Base.BaseFormy;
import ForMyProjectPages.SwitchWindow;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestSwitchWindow extends BaseFormy {
    @Test
    public void testOpenNewTab(){
        SwitchWindow page = homePage.clickSwitchWindow();
        page.rememberCurrentTab();
        page.clickOpenNewTabButton();
        page.switchToNewTab();

        assertEquals("https://formy-project.herokuapp.com/", driver.getCurrentUrl());
        page.switchBackToOriginalTab();
        assertEquals("https://formy-project.herokuapp.com/switch-window", driver.getCurrentUrl());
    }
    @Test
    public void testOpenAlert(){
        SwitchWindow page = homePage.clickSwitchWindow();
        page.clickOpenAlertButton();
       assertEquals("This is a test alert!", page.getAlertMessage());
        page.AcceptAlert();
    }
}
