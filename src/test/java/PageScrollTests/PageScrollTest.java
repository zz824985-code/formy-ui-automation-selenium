package PageScrollTests;

import Base.BaseFormy;
import ForMyProjectPages.PageScroll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PageScrollTest extends BaseFormy {
    @Test
    public void TestPageScroll(){
        PageScroll page = homePage.clickPageScroll();
        page.setNameTextBox("Full Name");
        page.setDateTextBox();

        assertEquals("Full Name", page.getNameValue());

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        assertEquals(expectedDate, page.getDateValue());
    }
}
