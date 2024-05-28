package pagesObjects;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class InitPage extends Page {

    @FindBy(css = "input[name='pseudo']")
    private WebElement pseudo;
    @FindBy(css = "input[name='first_name']")
    private WebElement fname;
    @FindBy(css = "input[name='last_name']")
    private WebElement lname;
    @FindBy(xpath = "//*[@id=\"root\"]/main/form/fieldset/div/label[1]/span[1]/input")
    private WebElement inputMan;
    @FindBy(xpath = "//*[@id=\"root\"]/main/form/fieldset/div/label[2]/span[1]/input")
    private WebElement inputWoman;
    @FindBy(id = "academic_level")
    private WebElement academicLevel;
    @FindBy(xpath = "//*[@id=\"menu-academic_level\"]/div[3]/ul/li[1]")
    private WebElement primary;
    @FindBy(id = "language")
    private WebElement language;
    @FindBy(xpath = "//*[@id=\"menu-language\"]/div[3]/ul/li[1]")
    private WebElement frenchLang;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div[1]/button")
    private WebElement profileBtn;



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


    public void fillInitProfilForm(String pseudo, String fname, String lname, String genre, String language, String level, String country) throws InterruptedException {
        super.waitVisibility(this.pseudo);
        clearInputText(this.pseudo);
        super.writeText(this.pseudo,pseudo);
        super.writeText(this.fname, fname);
        super.writeText(this.lname, lname);

        if (genre == "Homme"){
            this.inputMan.click();
        }else {
            this.inputWoman.click();
        }

        //A traiter language
        super.clickOn(this.language);
        super.clickOn(this.frenchLang);

        //A traiter niveau
        super.clickOn(this.academicLevel);
        super.clickOn(this.primary);

        //
        clearInputText(this.country);
        super.writeText(this.country, country);
        this.country.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        this.clickOnSubmtBtn();
    }
    public void goToMainProfile(){
        super.waitVisibility(this.profileBtn);
        super.clickOn(this.profileBtn);
    }

    private static void clearInputText(WebElement webElement){
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
    }

}
