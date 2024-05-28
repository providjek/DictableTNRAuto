package stepDefinitions;

import config.JSONReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.AssertManager;
import org.testng.Assert;
import pagesObjects.InitPage;
import pagesObjects.LoginPage;

public class LoginStep {

    private LoginPage loginPage = new LoginPage();
    private InitPage initPage = new InitPage();
    private final JSONReader authJDD = new JSONReader("src/test/resources/jdd/authJDD.json");


    @When("Je me connecte avec mes accès")
    public void jeMeConnecteAvecMesAccèsEt() {
        this.loginPage.fillLoginForm(authJDD.readJSONValue("email"), authJDD.readJSONValue("pass"));
    }

    @And("Je remplie les informations de mon profil")
    public void jeRemplieLesInformations() throws InterruptedException {
        Thread.sleep(4000);
        this.initPage.fillInitProfilForm(authJDD.readJSONValue("pseudo"), authJDD.readJSONValue("fname"), authJDD.readJSONValue("lname"), authJDD.readJSONValue("genre"), authJDD.readJSONValue("language"), authJDD.readJSONValue("level"), authJDD.readJSONValue("country"));
    }

    @Then("Je suis connecté et sur la page d'accueil")
    public void jeSuisConnectéEtSurLaPageDAccueil() {
        this.initPage.goToMainProfile();
        AssertManager.customAssert(this.initPage.currentUrlContains("https://dictable.org/browse"),"Les URL ne correspondent pas");
    }


}
