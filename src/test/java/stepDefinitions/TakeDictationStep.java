package stepDefinitions;

import config.JSONReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.AssertManager;
import pagesObjects.DictationPage;

public class TakeDictationStep {
    private DictationPage dictationPage = new DictationPage();
    private final JSONReader dictationJDD = new JSONReader("src/test/resources/jdd/dictationJDD.json");




    @Given("Je suis connecté et sur la page details d'une dictée")
    public void jeSuisConnectéEtSurLaPageDeLaDictée() {
        this.dictationPage.getDriver().get("https://dictable.org/dictation/l-e-sport/attempt");
    }

    @When("J écoutes la dictée et je réponds avec le paragraphe")
    public void jÉcoutesLaDictéeEtJeRépondsAvecLeParagraphe() {

        this.dictationPage.doDictaction(dictationJDD.readJSONValue("answer"));
    }

    @And("Je soumets cette reponse pour la correction")
    public void jeSoumetsCetteReponsePourLaCorrection() {
    }

    @Then("La dictée est corrigé, aucune faute n'est detectée")
    public void laDictéeEstCorrigéAucuneFauteNEstDetectée() throws InterruptedException {
        this.dictationPage.confirmationAndSubmitDictation();
    }

    @And("J'obtiens une note correcte")
    public void jObtiensUneNoteDe() {
        AssertManager.customAssert(this.dictationPage.seeNote(dictationJDD.readJSONValue("note")),"La note obtenue ne correspond pas à la note attendue");
    }
}
