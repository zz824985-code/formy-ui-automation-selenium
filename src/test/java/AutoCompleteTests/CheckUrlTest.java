package AutoCompleteTests;

import Base.BaseFormy;
import ForMyProjectPages.AutoCompletePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckUrlTest extends BaseFormy{
    @Test
    public void CheckUrl(){
        System.out.println(driver.getCurrentUrl());
        AutoCompletePage autoCompletePage = homePage.clickAutoComplete();
        System.out.println(driver.getCurrentUrl());
        autoCompletePage.setAddress("21354");
        autoCompletePage.setStreetAddress("000th");
        autoCompletePage.setStreetAddress2("QA Ave");
        autoCompletePage.setCity("QA town");
        autoCompletePage.setState("Hardware state");
        autoCompletePage.setZipCode("00000");
        autoCompletePage.setCountry("NVidia");
        Assertions.assertEquals("https://formy-project.herokuapp.com/autocomplete", driver.getCurrentUrl());


    }

}
