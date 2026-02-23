package AutoCompleteTests;

import Base.BaseFormy;
import ForMyProjectPages.AutoCompletePage;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AutoCompleteFormFields extends BaseFormy {
    @Test
    public void testAutocompleteFormFields(){
        AutoCompletePage page = homePage.clickAutoComplete();


        String address = "123 ";
        String street1 = "117th";
        String street2 = "QA Ave";
        String city = "Kcity2";
        String state = "State";
        String zip = "00000";
        String country = "LalaLand";

        page.setAddress(address);
        page.setStreetAddress(street1);
        page.setStreetAddress2(street2);
        page.setCity(city);
        page.setState(state);
        page.setZipCode(zip);
        page.setCountry(country);

        assertAll("Autocomplete fields should contain entered values",
                () -> assertEquals(address, page.getAddress(), "Address mismatch"),
                () -> assertEquals(street1, page.getStreetAddress(), "Street address 1 mismatch"),
                () -> assertEquals(street2, page.getStreetAddress2(), "Street address 2 mismatch"),
                () -> assertEquals(city, page.getCity(), "City mismatch"),
                () -> assertEquals(state, page.getState(), "State mismatch"),
                () -> assertEquals(zip, page.getZipCode(), "Zip code mismatch"),
                () -> assertEquals(country, page.getCountry(), "Country mismatch")
                );

    }
}
