package Steps;

import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NewOrderSteps {
    private WebDriver driver;
    @Given("user opens https://prod-kurs.coderslab.pl/ page")
    public void openMyStore() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //Ustaw czas oczekiwania na ładowanie elementów
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Przejdź do strony
        driver.get("https://prod-kurs.coderslab.pl/");

        MainPage mainPage = new MainPage(driver);
    }
    @And("user clicks on SingIn button")
    public void clickSingIn(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSingInButton();
    }

    @And ("user enters email (.*) and password (.*) and click Signin button")
    public void enterLoginAndPassword(String email, String password) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.logIn(email, password);

        myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickMyStoreButton();

    }
    @When ("user finds Hummingbird Printed Sweater")
    public void userFindsProduct(){
        //przejscie do strony głownej po logowaniu
        MainPage mainPage = new MainPage(driver);
        //znalezienie produktu
        mainPage.addSweater();
    }

    @And("user choose (.*), (.*), add product to the basket and goes to checkout")
    public void addProduct(String size, String quantity) {
        //strona produktu
        HummingBirdSweaterProductPage productPage = new HummingBirdSweaterProductPage(driver);
        //wybór rozmiaru i ilości z parametru
        productPage.addProductWithParameters("M", "5");
        productPage.clickAddToCart();

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));

        ConfirmationPopUpPage confirmationPopUpPage = new ConfirmationPopUpPage(driver);
        confirmationPopUpPage.goToCheckout();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickProceededToCheckout();

    }
    @And("user confirms address")
    public void addressConfirmation(){
    }

    @And("user choose delivery method Pick up in store, choose pay by Check and confirms order")
    public void paymentAndDeliveryMethods() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickContinueButton();
        shoppingCartPage.clickDelivery();
        shoppingCartPage.paymentConfirmation();
    }

    @Then("user sees order confirmation")
    public void orderConfirmation() {

    }

    @And("screenshot is taken")
    public void takeScreenShoot() throws Exception {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        shoppingCartPage.takeSnapShot(driver, "c://test.png");

    }

    @And("browser is closed")
    public void browserClosing() {
        driver.quit();
    }

}
