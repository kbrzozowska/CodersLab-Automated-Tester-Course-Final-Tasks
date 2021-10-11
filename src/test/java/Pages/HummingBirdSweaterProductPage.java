package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HummingBirdSweaterProductPage {
    private static WebDriver driver;
    public HummingBirdSweaterProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //elementy potrzebne do dodania produktu do koszyka

    @FindBy(id="group_1")
    private WebElement selectSizeField;

    @FindBy(css ="[class=\"material-icons touchspin-up\"]")
    private WebElement quantityUp;

    @FindBy(css = "[class=\"btn btn-primary add-to-cart\"]")
    private WebElement addToCartButton;

    //metody potrzebne do dodania produktu do koszyka

    public void addProductWithParameters(String size, String quantity) {
        Select mySize = new Select(selectSizeField);
        mySize.selectByVisibleText(size);

        int quantityToInt = Integer.parseInt(quantity);
        for (int i = 0; i < quantityToInt; i++) {
            quantityUp.click();
        }
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

}
