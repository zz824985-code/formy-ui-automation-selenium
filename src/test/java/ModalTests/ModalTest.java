package ModalTests;

import Base.BaseFormy;
import ForMyProjectPages.Modal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ModalTest extends BaseFormy {
    @Test
    public void testModal(){
        Modal page = homePage.clickModal();
        page.clickModalButton();
       assertEquals("Some text here", page.getSomeTextMessage(), "Texts should match");
        page.clickOkButton();
        assertFalse(page.isModalStillUp());
       page.clickCrossButton();
       assertFalse(page.isModalStillUp());
    }
    @Test
    public void testModalCloseButton(){
        Modal page = homePage.clickModal();
        page.clickModalButton();
        assertEquals("Some text here", page.getSomeTextMessage(), "Texts should match");
        page.clickOkButton();
        assertTrue(page.isModalStillUp());
        page.clickCloseButton();
        assertFalse(page.isModalStillUp());
    }
}
