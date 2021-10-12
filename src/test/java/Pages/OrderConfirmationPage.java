package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class OrderConfirmationPage {
    private static WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elementy do potwierdzenia zamówienia
    @FindBy(css = "[class=\"h1 card-title\"]")
    private WebElement orderConfirmation;

    //do powrotu do main page
    @FindBy(className = "account")
    private WebElement myAccountButton;

    //metody do potwiedzenia zamówienia

    //tekst z nagłówka powtwierdzenia
    public String getOrderConfirmation(){
        return orderConfirmation.getText();
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

    //metody do powrotu do strony użytkownika
    public void clickMyAccount(){
        myAccountButton.click();
    }
}
