package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;


@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@e2e",
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
public class AuthRunner extends AbstractTestNGCucumberTests {

    //private static final Logger LOGGER = LoggerFactory.getLogger(AuthRunner.class);


    @BeforeMethod
    public void setup(){
        //LOGGER.info("Starting @Before scenario hook");
        WebDriver driver = WebDrivenSingleton.getInstance();
    }

    //@AfterMethod
    public void teardown(){
        WebDrivenSingleton.destroy();
    }
}
