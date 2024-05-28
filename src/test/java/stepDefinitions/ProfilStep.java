package stepDefinitions;

import config.JSONReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.AssertManager;
import org.junit.Assert;
import pagesObjects.ProfilPage;

public class ProfilStep {
    private ProfilPage profilPage = new ProfilPage();
    private final JSONReader newProfilJDD = new JSONReader("src/test/resources/jdd/newProfilJDD.json");
    @When("Je crée un nouveau profil avec les informations")
    public void jeCréeUnNouveauProfilAvecLesInformations() throws InterruptedException {
        this.profilPage.fillAddProfilForm(newProfilJDD.readJSONValue("pseudo"), newProfilJDD.readJSONValue("fname"), newProfilJDD.readJSONValue("lname"), newProfilJDD.readJSONValue("genre"), newProfilJDD.readJSONValue("language"), newProfilJDD.readJSONValue("level"), newProfilJDD.readJSONValue("country"));
    }

    @Then("Le nouveau profil est créé avec succès")
    public void leNouveauProfilEstCrééAvecSuccès() {
        this.profilPage.waitNotif();
        //Assert.assertEquals(this.profilPage.getNotifText(), newProfilJDD.readJSONValue("msgSuccessProfCreat")).;
        AssertManager.customAssert(this.profilPage.getNotifText().equals(newProfilJDD.readJSONValue("msgSuccessProfCreat")), "La création du compte a échouée");
    }
}
