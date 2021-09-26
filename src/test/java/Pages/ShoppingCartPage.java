package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ShoppingCartPage {
    private static WebDriver driver;
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elementy do potwierdzenia zakupu
    @FindBy(css = "[href=\"https://mystore-testlab.coderslab.pl/index.php?controller=order\"]")
    private WebElement proceededToCheckoutButton;

    @FindBy(css = "[name=\"confirm-addresses\"]")
    private WebElement continueButton;

    @FindBy(css = "[name=\"delivery_option[13906]\"]")
    private WebElement deliveryOptionRadio;

    @FindBy(css = "[name=\"confirmDeliveryOption\"]")
    private WebElement deliveryConfirmationButton;

    @FindBy(id ="payment-option-1")
    private WebElement paymentByCheckRadio;

    @FindBy(id="conditions_to_approve[terms-and-conditions]")
    private WebElement termsAndConditionsCheck;

    @FindBy(id = "payment-confirmation")
    private WebElement paymentConfirmationButton;

    //metody do potwierdzenia zakupu
    public void clickProceededToCheckout() {
        proceededToCheckoutButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickDelivery() {
        deliveryOptionRadio.click();
        deliveryConfirmationButton.click();
    }

    public void paymentConfirmation() {
        paymentByCheckRadio.click();
        termsAndConditionsCheck.click();
        paymentConfirmationButton.click();

    }

    public static void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
//Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
        File DestFile = new File(fileWithPath);
//Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
