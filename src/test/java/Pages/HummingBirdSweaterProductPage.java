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

    @FindBy(id="quantity_wanted")
    private WebElement selectQuantityField;

    @FindBy(css = "[class=\"btn btn-primary add-to-cart\"]")
    private WebElement addToCartButton;

    //metody potrzebne do dodania produktu do koszyka

    public void addProductWithParameters(String size, String quantity) {
        Select mySize = new Select(selectSizeField);
        mySize.selectByVisibleText(size);

        selectQuantityField.clear();
        selectQuantityField.sendKeys("value", quantity);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

}
