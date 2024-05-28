package stepDefinitions;

import enums.EndpointEnums;
import io.cucumber.java.en.Given;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;

public class PageNavigationSteps {
    protected WebDriver driver = WebDrivenSingleton.getInstance();

    @Given("Je suis sur la page de ([^\"]*)$")
    public void jeSuisSurLaPageDeCréationDeCompte(EndpointEnums endpoint) {
        WebDrivenSingleton.navigateTo(endpoint.getEndpoint());

    }

}
