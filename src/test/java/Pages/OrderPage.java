package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private static WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elementy do potwierdzenia zakupu
    @FindBy(css = "[name=\"confirm-addresses\"]")
    private WebElement continueButton;

    //@FindBy(css = "[#js-delivery > div > div.delivery-options > div:nth-child(1) > div > span > span]")
    //private WebElement deliveryOptionRadio;

    @FindBy(css = "[name=\"confirmDeliveryOption\"]")
    private WebElement deliveryConfirmationButton;

    @FindBy(id ="payment-option-1")
    private WebElement paymentByCheckRadio;

    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsCheck;

    @FindBy(id = "payment-confirmation")
    private WebElement paymentConfirmationButton;

    @FindBy(css = "[class=\"address-alias h4\"]")
    private WebElement aliasInformation;

    //metody do potwierdzenia zakupu
    public void clickContinueButton() {

        continueButton.click();
    }

    public void clickDelivery() {
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")).click();
        deliveryConfirmationButton.click();
    }

    public void paymentConfirmation() {
        paymentByCheckRadio.click();
        termsAndConditionsCheck.click();
        paymentConfirmationButton.click();

    }

    public String getAddressAlias(){
        return aliasInformation.getText();
    }
}
