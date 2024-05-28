package pagesObjects;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

@Getter
public class RegisterPage extends Page {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passInput;
    @FindBy(id = "re_password")
    private WebElement confPassInput;
    @FindBy(css = "form .MuiButton-containedPrimary")
    private WebElement subRegisterBtn;

    @FindBy(css = "#root > main > div > div.MuiBox-root.css-1eqs618 > p")
    private WebElement confirmationMsgPlaceholder;

    private WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */
    public void clickOnSubRegisterBtn(){
        super.clickOn(this.subRegisterBtn);
    }

    /****
     *
     * Write Section in input WebElement
     */

    public void writeEmail(String email){
        super.writeText(this.emailInput, email);
    }
    public void writePassword(String pass){
        super.writeText(this.passInput, pass);
    }
    public void writeConfPassword(String pass){
        super.writeText(this.confPassInput, pass);
    }

    public void fillRegisterForm(String email, String pass, String confPass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.writeConfPassword(confPass);
        this.clickOnSubRegisterBtn();
    }

    public void fillRegisterForm(String email, String pass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.writeConfPassword(pass);
        super.waitVisibility(this.subRegisterBtn);
        this.clickOnSubRegisterBtn();
    }

    public void visibilityConfirmationMsg(){
        super.waitVisibility(this.confirmationMsgPlaceholder);
    }

}
