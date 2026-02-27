package KeyAndMouseTests;

import Base.BaseFormy;
import ForMyProjectPages.KeyAndMouse;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SubmissionTest extends BaseFormy {
    @Test
    public void SubmissionTest1(){
        KeyAndMouse page = homePage.clickKeyAndMouse();
        page.setFullNameTextbox("Zubenko Mihail Petrovich");
        assertEquals("Zubenko Mihail Petrovich", page.getFullNameValue(), "Input mismatch");
        page.clickSubmitButton();
        assertFalse(page.isTextBoxEmpty());
    }
}
