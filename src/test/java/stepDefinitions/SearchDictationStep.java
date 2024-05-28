package stepDefinitions;

import config.JSONReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.AssertManager;
import pagesObjects.home.HomePage;

public class SearchDictationStep {

    private HomePage homePage = new HomePage();
    private final JSONReader dictationJDD = new JSONReader("src/test/resources/jdd/dictationJDD.json");


    @When("Je recherche une dictée")
    public void jeRechercheLaDictée() throws InterruptedException {
        this.homePage.searchADictation(dictationJDD.readJSONValue("title"));
    }

    @Then("Je peux accéder aux détails de cette dictée")
    public void jePeuxAccéderAuxDétailsDeCetteDictée() {
        AssertManager.customAssert(this.homePage.currentUrlContains("https://dictable.org/dictation/l-e-sport/"),"La dictée n'a pas été rétrouvée");

    }
}
