package pagesObjects;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class ProfilPage extends Page {

    @FindBy(css = "input[name='pseudo']")
    private WebElement pseudo;
    @FindBy(css = "input[name='first_name']")
    private WebElement fname;
    @FindBy(css = "input[name='last_name']")
    private WebElement lname;
    @FindBy(css = "input[value=\"f\"]")
    private WebElement inputWoman;

    @FindBy(css = "input[value=\"m\"]")
    private WebElement inputMan;
    @FindBy(id = "academic_level")
    private WebElement academicLevel;
    @FindBy(css = "li[data-value=\"primarySchool\"]")
    private WebElement primary;
    @FindBy(css = "")
    private WebElement middle;


    @FindBy(id = "language")
    private WebElement language;
    @FindBy(css = "li[data-value=\"fr-fr\"]")
    private WebElement frenchLang;

    @FindBy(css = "li[data-value=\"en-gb\"]")
    private WebElement englishLang;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[1]/button")
    private WebElement profileBtn;

    @FindBy(id = "notistack-snackbar")
    private WebElement notificationAlerte;



    private final WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */
    public void clickOnSubmtBtn(){
        super.clickOn(this.btnSubmit);
    }

    /****
     *
     * Write Section in input WebElement
     */


    public void fillAddProfilForm(String pseudo, String fname, String lname, String genre, String language, String level, String country) throws InterruptedException {
        super.waitVisibility(this.pseudo);
        clearInputText(this.pseudo);
        super.writeText(this.pseudo,pseudo);
        super.writeText(this.fname, fname);
        super.writeText(this.lname, lname);

        if (genre.contains("Homme")){
            this.inputMan.click();
        }else {
            this.inputWoman.click();
        }

        //A traiter language
        super.clickOn(this.language);

        if (genre.contains("Anglais")){
            super.clickOn(this.englishLang);
        }else {
            super.clickOn(this.frenchLang);
        }

        //A traiter niveau
        waitVisibility(this.academicLevel);
        super.clickOn(this.academicLevel);
        super.clickOn(this.primary);

        this.clickOnSubmtBtn();
    }

    public String getNotifText(){
      return this.notificationAlerte.getText();
    }
    public void waitNotif(){
        super.waitVisibility(this.notificationAlerte);
    }
/*    public void ckeckProfilCreated(String msg){
        super.waitVisibility(this.notificationAlerte);
         Assert.assertEquals(this.getNotifText(), msg);

    }*/

    private static void clearInputText(WebElement webElement){
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
    }


}
