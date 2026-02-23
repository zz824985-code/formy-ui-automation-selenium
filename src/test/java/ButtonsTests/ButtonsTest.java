package ButtonsTests;

import Base.BaseFormy;
import ForMyProjectPages.Buttons;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonsTest extends BaseFormy {
    @Test
    public void testButtonsPageOpened(){
        Buttons page = homePage.clickButtons();
        assertAll("Buttons page should be opened",
                () -> assertTrue(page.isOnButtonsPage(),
                        "Current URL should contain /buttons"),
                () -> assertTrue(page.isPrimaryButtonVisible(),
                        "Primary button should be visible"),
                () -> assertTrue(page.isSuccessButtonVisible(),
                        "Success button should be visible"),
                () -> assertTrue(page.isInfoButtonVisible(),
                        "Info button should be visible"),
                () -> assertTrue(page.isWarningButtonVisible(),
                        "Warning button should be visible"),
                () -> assertTrue(page.isDangerButtonVisible(),
                        "Danger button should be visible"),
                () -> assertTrue(page.isLinkButtonVisible(),
                        "Link button should be visible")
                );
    }
    @Test
    public void testMainButtonsClickable(){
        Buttons page = homePage.clickButtons();
        page.clickPrimaryButton();
        page.clickSuccessButton();
        page.clickInfoButton();
        page.clickWarningButton();
        page.clickDangerButton();
        page.clickLinkButton();
        page.clickLeftButton();
        page.clickMiddleButton();
        page.clickRightButton();
        page.clickNumberButton(1);
        page.clickNumberButton(2);

        assertTrue(page.isOnButtonsPage(),
                "After clicking all buttons we still should be on /buttons page");
    }
    @Test
    public void testNestedDropdownHasOptions(){
        Buttons page = homePage.clickButtons();

        int optionsCount = page.openNestedDropdownAndGetOptionsCount();

        assertEquals(2, optionsCount, "Nested dropdown should contain 2 options");
    }
}
