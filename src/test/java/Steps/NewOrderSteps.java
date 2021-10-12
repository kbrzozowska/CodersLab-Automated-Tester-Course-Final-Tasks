//package Steps;
//
//import Pages.*;
//import com.sun.org.apache.xpath.internal.operations.Or;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.concurrent.TimeUnit;
//
//public class NewOrderSteps {
//    private WebDriver driver;
//    @Given("user opens https://mystore-testlab.coderslab.pl/ page")
//    public void openMyStore() {
//        // Skonfiguruj sterownik przeglądarki
//        System.setProperty("webdriver.chrome.driver",
//                "src/main/resources/chromedriver");
//        driver = new ChromeDriver();
//        // Zmaksymalizuj okno przeglądarki
//        driver.manage().window().maximize();
//        //Ustaw czas oczekiwania na ładowanie elementów
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        // Przejdź do strony
//        driver.get("https://mystore-testlab.coderslab.pl/");
//
//        MainPage mainPage = new MainPage(driver);
//    }
//    @And("user clicks on SingIn button")
//    public void clickSingIn(){
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickSingInButton();
//    }
//
//    @And ("user enters email (.*) and password (.*) and click Signin button")
//    public void enterLoginAndPassword(String email, String password) {
//        MyAccountPage myAccountPage = new MyAccountPage(driver);
//        myAccountPage.logIn(email, password);
//
//        myAccountPage = new MyAccountPage(driver);
//        myAccountPage.clickMyStoreButton();
//
//    }
//    @When ("user finds Hummingbird Printed Sweater")
//    public void userFindsProduct(){
//        //przejscie do strony głownej po logowaniu
//        MainPage mainPage = new MainPage(driver);
//        //znalezienie produktu
//        mainPage.addSweater();
//    }
//
//    @And("user choose (.*), (.*), add product to the basket and goes to checkout")
//    public void addProduct(String size, String quantity) {
//        //strona produktu
//        HummingBirdSweaterProductPage productPage = new HummingBirdSweaterProductPage(driver);
//
//        //wybór rozmiaru i ilości z parametru (L i 2 szt)
//        productPage.addProductWithParameters("L", "2");
//        productPage.clickAddToCart();
//        ConfirmationPopUpPage confirmationPopUpPage = new ConfirmationPopUpPage(driver);
//
//        //czekam na pojawienie się popUpa z potwierdzeniem
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModalLabel")));
//
//        //potwierdzenie w popUpie
//
//        confirmationPopUpPage.goToCheckout();
//
//        //potwierdzenie w koszyku
//        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
//        shoppingCartPage.clickProceededToCheckout();
//
//    }
//
//    @And("user confirms address alias (.*)")
//    public void addressConfirmation(String alias) {
//        OrderPage orderPage = new OrderPage(driver);
//
//        Assert.assertEquals(alias, orderPage.getAddressAlias());
//
//    }
//
//    @And("user choose delivery method Pick up in store, choose pay by Check and confirms order")
//    public void paymentAndDeliveryMethods() {
//        OrderPage orderPage = new OrderPage(driver);
//        orderPage.clickContinueButton();
//
//        OrderPage orderPageDelivery = new OrderPage(driver);
//
//        //wait dla radio buttonów dostawy
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/div/span/span")));
//
//        orderPageDelivery.clickDelivery();
//
//        OrderPage orderPagePayment = new OrderPage(driver);
//
//        //wait dla płatności
//        //WebDriverWait anotherWait = new WebDriverWait(driver, 20);
//        //anotherWait.until(ExpectedConditions.elementToBeClickable (By.id("payment-option-1")));
//        orderPagePayment.paymentConfirmation();
//    }
//
//    @Then("user sees order confirmation")
//    public void orderConfirmation() {
//        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
//
//        Assert.assertEquals("\uE876YOUR ORDER IS CONFIRMED", orderConfirmationPage.getOrderConfirmation());
//    }
//
//    @And("screenshot is taken")
//    public void takeScreenShoot() throws Exception {
//        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
//
//        //screenshot test.png
//        orderConfirmationPage.takeSnapShot(driver, "screenshot//test.png");
//
//    }
//
//    @And("user goes back to account page and goes to order history")
//    public void toOrderHistory(){
//        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
//        orderConfirmationPage.clickMyAccount();
//
//        MyAccountPage myAccountPage = new MyAccountPage(driver);
//        myAccountPage.toOrderHistory();
//    }
//
//    @And("browser is closed")
//    public void browserClosing() {
//        driver.quit();
//    }
//
//}
