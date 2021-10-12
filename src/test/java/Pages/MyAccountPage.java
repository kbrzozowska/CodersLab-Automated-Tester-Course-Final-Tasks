package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private static WebDriver driver;

    //kontruktor obiektu dla strony konta
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //elementy potrzebne do zalogowania
    @FindBy(css = "[type=\"email\"]")
    private WebElement emailField;

    @FindBy(css = "[type=\"password\"]")
    private WebElement passwordField;

    @FindBy(id = "submit-login")
    private WebElement submitButton;

    //elementy potrzebne do dodania adresu
    @FindBy(id = "address-link")
    private WebElement addAddressButton;

    //elementy do przejścia na stronę główną
    @FindBy(css = "[class=\"logo img-responsive\"]")
    private WebElement myStoreButton;

    //elemety do sprawdzenia statusu zamowienia
    @FindBy(id = "history-link")
    private WebElement orderHistoryButton;

    //metody potrzebne do zalogowania
    public void logIn(String email,String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    //metody potrzebne do dodania adresu
    public void clickAddAddress(){
        addAddressButton.click();
    }

    //metody potrzebne do przejscia na stronę główną
    public void clickMyStoreButton(){
        myStoreButton.click();
    }

    //metoda do przejcia do historii zamówień
    public void toOrderHistory(){
        orderHistoryButton.click();
    }
}
