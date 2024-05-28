package stepDefinitions;

import config.JSONReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pagesObjects.YopmailPage;
import pagesObjects.RegisterPage;


public class RegisterSteps {
    private final RegisterPage registerPage = new RegisterPage();
    private YopmailPage yopmailPage = new YopmailPage();
    private final JSONReader jsonReader = new JSONReader("src/test/resources/jdd/authJDD.json");




    @When("Je renseigne mes informations correctes")
    public void jeRenseigneMesInformationsCorrectesEt() {
        this.registerPage.fillRegisterForm(jsonReader.readJSONValue("email"), jsonReader.readJSONValue("pass"));
    }


    @And("Je confirme mon inscription grâce au lien reçu par mail")
    public void jeConfirmeMonInscriptionGrâceAuLienReçuParMailDeÀLAdresse() throws InterruptedException {
        Thread.sleep(2000);
        this.yopmailPage.goToYopmail();
        this.yopmailPage.writeEmailYp(jsonReader.readJSONValue("email"));
        this.yopmailPage.clickBtnConfYp();
        this.yopmailPage.openAMessageInYp(jsonReader.readJSONValue("pass"));
        this.yopmailPage.confirmeMailYp();
    }

    @Then("Mon compte devrait être activé")
    public void monCompteDevraitÊtreActivé() {
        this.registerPage.waitVisibility(this.registerPage.getConfirmationMsgPlaceholder());
        Assert.assertEquals(this.registerPage.getConfirmationMsgPlaceholder().getText(), "Adresse e-mail validée, connectez-vous maintenant avec vos identifiants.");
    }
}
