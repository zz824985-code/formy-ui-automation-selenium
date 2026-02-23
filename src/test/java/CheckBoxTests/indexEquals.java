package CheckBoxTests;

import Base.BaseFormy;
import ForMyProjectPages.CheckBox;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class indexEquals extends BaseFormy {

    @Test
    public void radioButtonIndexEquals(){
        CheckBox page = homePage.clickCheckBox();


        System.out.println("Checkboxes found:" + page.getCheckboxesCount());
       int optionChecked =  page.clickCheckBox();
       assertTrue(page.isCheckBoxSelected(optionChecked), "Checkbox with index" + optionChecked +
               "should be selected");
    }



}
