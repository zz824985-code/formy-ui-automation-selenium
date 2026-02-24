package DragAndDropTests;

import Base.BaseFormy;
import ForMyProjectPages.DragAndDropPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DragAndDropTest extends BaseFormy {
    @Test
    @Disabled("Formy drag&drop page is flaky in modern ChromeDriver: " +
              "manual drag in the WebDriver window also fails, sp the test " +
               " is kept as an example but not executed.")
    public void imageDroppedSuccessfully(){
        DragAndDropPage page = homePage.clickDragAndDrop();

        page.dragImageToBox();

        String droppedSuccessMessage = page.getDroppedMessage();
        assertEquals("Dropped!", droppedSuccessMessage);
    }
}
