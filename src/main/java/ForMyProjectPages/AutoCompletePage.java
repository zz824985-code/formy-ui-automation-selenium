package ForMyProjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoCompletePage extends BasePage{

    private final By addressField = By.id("autocomplete");
    private final By streetAddressField = By.id("street_number");
    private final By streetField = By.id("route");
    private final By cityField = By.id("locality");
    private final By stateField = By.id("administrative_area_level_1");
    private final By zipCodeField = By.id("postal_code");
    private final By countryField = By.id("country");


    public AutoCompletePage(WebDriver driver){super(driver);}

    public void setAddress(String address){
        type(addressField, address);
    }
    public void setStreetAddress(String address) {
        type(streetAddressField, address);
    }
    public void setStreetAddress2(String address){
        type(streetField, address);
    }
    public void setCity(String city){
        type(cityField, city);
    }
    public void setState(String state){
        type(stateField, state);
    }
    public void setZipCode(String postcode){type(zipCodeField,postcode);}
    public void setCountry(String country){
        type(countryField, country);
    }


    public String getAddress(){ return getInputValue(addressField);}
    public String getStreetAddress(){ return getInputValue(streetAddressField);}
    public String getStreetAddress2(){ return getInputValue(streetField);}
    public String getCity(){ return getInputValue(cityField);}
    public String getState(){ return getInputValue(stateField);}
    public String getZipCode(){ return getInputValue(zipCodeField);}
    public String getCountry(){ return getInputValue(countryField);}

}
