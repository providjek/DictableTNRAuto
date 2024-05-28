package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.AssertManager;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagesObjects.home.HomePage;

public class LogoutStep {

    private  HomePage homePage = new HomePage();
    private WebDriver driver = WebDrivenSingleton.getInstance();
    @Given("Je suis connecté à la plateforme et j'ai une session en court")
    public void jeSuisConnectéÀLaPlateformeEtJAiUneSessionEnCourt() {
            this.driver.get("https://dictable.org/");
    }

    @When("Je me deconnecte  grâce à l'option déconnexion")
    public void jeMeDeconnecteGrâceÀLOptionDéconnexion() {
        this.homePage.logout();
    }


    @Then("Je suis deconnecté et redirigé à la page d'accueil public")
    public void jeSuisDeconnectéEtRedirigéÀLaPageDAccueilPublic() {
        AssertManager.customAssert(this.homePage.currentUrlContains("https://dictable.org/browse"),"Les URLs ne correspondent pas !");
    }
}
