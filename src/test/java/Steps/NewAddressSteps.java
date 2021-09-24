package Steps;

import Pages.AddressPage;
import Pages.MainPage;
import Pages.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class NewAddressSteps {
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
    public void enterLoginAndPassword(String email, String password){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.logIn(email,password);
    }
    @When("user clicks \"add first address\" button")
    public void clickAddFirstAddress(){
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickAddAddress();
    }
    @And ("user add new alias (.*), firstname (.*), surname (.*), address (.*), zip code (.*), city (.*), country (.*) and phone (.*)")
    public void fillForm(String firstname, String lastname, String alias, String address, String code, String city, String country, String phone){
        AddressPage addressPage = new AddressPage(driver);
        addressPage.fillAddressForm(firstname, lastname, alias, address, code, city, country, phone);
        addressPage.submitAddress();
    }
    @Then ("user sees confirmation (.*)")
    public void userIsRegistered(String message){
        AddressPage addressPage = new AddressPage(driver);
        Assert.assertEquals("Address successfully added!", addressPage.getAddressAdded());
    }
    @And("browser is closed")
    public void browserClosing(){
        driver.quit();
    }
}
