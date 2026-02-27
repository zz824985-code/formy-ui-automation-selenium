package FileUploadTests;

import Base.BaseFormy;
import ForMyProjectPages.FileUpload;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FileUploadTest extends BaseFormy {
    @Test
    public void visibleURL(){
        FileUpload page = homePage.clickFileUpload();
        assertTrue(page.isOnFileUploadPage(), "URL should contain /fileupload");
    }
    @Test
    public void visibleResetButton(){
        FileUpload page = homePage.clickFileUpload();
        assertTrue(page.isResetButtonVisible(), "Reset button should be visible");
    }
    @Test
    public void visibleAndReadablePlaceholder(){
        FileUpload page = homePage.clickFileUpload();
        assertTrue(page.isChooseTextboxVisible(), "Textbox should be both visible and readable");
    }
}
