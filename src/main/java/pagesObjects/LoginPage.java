package pagesObjects;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class LoginPage extends Page {
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passInput;
    @FindBy(css = "form .MuiButton-containedPrimary")
    private WebElement subLoginBtn;


    private final WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));



    /*
    * Click On Section
    * */
    public void clickOnSubRegisterBtn(){
        super.clickOn(this.subLoginBtn);
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

    public void fillLoginForm(String email, String pass){
        this.writeEmail(email);
        this.writePassword(pass);
        this.clickOnSubRegisterBtn();
    }

}
