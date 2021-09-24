package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static WebDriver driver;
    //konstruktor dla obiektu strony głównej

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //wyszukiwanie elementów potrzebnych do zalogowanania

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement singInButton;

    //metody potrzebne do zalogowania

    public void clickSingInButton() {
        singInButton.click();
    }
}
