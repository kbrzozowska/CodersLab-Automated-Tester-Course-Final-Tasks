package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPopUpPage {
    private static WebDriver driver;
    public ConfirmationPopUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Proceed to checkout")
    private WebElement toCheckoutButton;

    public void goToCheckout(){
        toCheckoutButton.click();
    }
}
