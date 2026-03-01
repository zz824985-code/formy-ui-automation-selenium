package RadioButtonTests;

import Base.BaseFormy;
import ForMyProjectPages.RadioButton;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RadioButtonTest extends BaseFormy {
    @Test
    public void testRandomButtonSelection(){
        RadioButton page = homePage.clickRadioButton();
        page.clickRandomRadioButton();
        assertTrue(page.isAnyRadioSelected(), "One radio should be selected");
    }
    @Test
    public void testRadioButtonByIndexSelection(){
        RadioButton page = homePage.clickRadioButton();
        page.clickRadioButtonByIndex(1);
        assertTrue(page.isRadioSelected(1));
    }
}
