package DropdownTests;

import Base.BaseFormy;
import ForMyProjectPages.CompleteWebForm;
import ForMyProjectPages.DropdownPage;
import ForMyProjectPages.SuccessPage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DropdownCompleteWebPageTest extends BaseFormy {

    @Test
    public void TestDropdownNavigation(){
        DropdownPage page = homePage.clickDropdownPage();
        page.selectFromDropdown();
        CompleteWebForm complete = page.clickCompleteWebForm();
        System.out.println(driver.getCurrentUrl());
        complete.setFirstNameField("John");
        complete.setLastNameField("Doe");
        complete.setJobTitleField("Programmer");
        complete.clickEduButton();
        complete.clickCheckBox();
        complete.selectFromDropDown();
        complete.setDatePickerField();
        SuccessPage success = complete.clickSubmitButton();
        System.out.println(driver.getCurrentUrl());
        String message = success.getSuccessMessage();
        assertEquals("The form was successfully submitted!", message);
    }
}
