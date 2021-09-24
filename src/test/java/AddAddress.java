import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Położenie (ścieżka), w którym znajdują się pliki *.features
        features = "src/test/java/Features/",
        //Położenie (pakiet), w którym są klasy z krokami
        glue = {"Steps"},
        plugin = {"pretty","html:out"})

public class AddAddress {
    private WebDriver driver;
}
