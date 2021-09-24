package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
    private static WebDriver driver;

    //konstruktor dla obiektu strony wprowadzania adresu

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //elementy potrzebne do wypełnienia formularza

    @FindBy(css = "[name=\"alias\"]")
    private WebElement aliasField;

    @FindBy(css = "[name=\"firstname\"]")
    private WebElement firstNameField;

    @FindBy(css = "[name=\"lastname\"]")
    private WebElement lastNameField;

    @FindBy(css = "[name=\"address1\"]")
    private WebElement addressField;

    @FindBy(css = "[name=\"postcode\"]")
    private WebElement postCodeField;

    @FindBy(css = "[name=\"city\"]")
    private WebElement cityField;

    @FindBy(css = "[name=\"id_country\"]")
    private WebElement countrySelect;

    @FindBy(css = "[name=\"phone\"]")
    private WebElement phoneField;

    //elementy potrzebne do wysłania formularza

    @FindBy(css = "[class=\"btn btn-primary float-xs-right\"]")
    private WebElement addressSubmitButton;

    //metody potrzebne do wypełnienia formularza
    public void fillAddressForm(String alias, String firstname, String lastname, String street, String code, String city, String country, String mobile) {
        aliasField.clear();
        aliasField.sendKeys(alias);

        firstNameField.clear();
        firstNameField.sendKeys(firstname);

        lastNameField.clear();
        lastNameField.sendKeys(lastname);

        addressField.sendKeys(street);
        postCodeField.sendKeys(code);
        cityField.sendKeys(city);

        Select myCountry = new Select(countrySelect);
        myCountry.selectByVisibleText(country);

        phoneField.sendKeys(mobile);
    }

    //metody potrzebne do wysłania formularza
    public void submitAddress() {
        addressSubmitButton.click();
    }

    //elementy do sprawdzenia adresu

    @FindBy(css = "[class=\"alert alert-success\"]")
    private WebElement successAlert;

    //metody do sprawdzenia adresu

    public String getAddressAdded() {
        return successAlert.getText();
    }
}
