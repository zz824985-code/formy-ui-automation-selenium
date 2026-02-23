package WebFormTest;

import Base.BaseFormy;import ForMyProjectPages.CompleteWebForm;
import ForMyProjectPages.SuccessPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class webForm extends BaseFormy {
    @Test
    public void testSuccessfulCompletion(){
        System.out.println(driver.getCurrentUrl());
        CompleteWebForm completeWebForm = homePage.clickWebForm();
        System.out.println(driver.getCurrentUrl());
        completeWebForm.setFirstNameField("Zheka");
        completeWebForm.setLastNameField("Zhekanenko");
        completeWebForm.setJobTitleField("Itishnik");
        completeWebForm.clickEduButton();
        completeWebForm.clickCheckBox();
        completeWebForm.selectFromDropDown();
        completeWebForm.setDatePickerField();
        SuccessPage successPage = completeWebForm.clickSubmitButton();
        System.out.println(driver.getCurrentUrl());
        String message = successPage.getSuccessMessage();
        Assertions.assertEquals("The form was successfully submitted!", message);
    }

}
