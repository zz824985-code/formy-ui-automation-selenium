package EnabledPageTests;

import Base.BaseFormy;
import ForMyProjectPages.Enabled;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IsEnabledTest extends BaseFormy {

    @Test
    public void EnabledTest(){
        Enabled enabled = homePage.clickEnabled();
        assertTrue(enabled.checkDisabledTextBox(),
                "Disabled input should be disabled");

        enabled.setEnabledTextBox("Ding-Dong");
       assertEquals("Ding-Dong", enabled.getEnabledTextBoxValue());
    }
}
