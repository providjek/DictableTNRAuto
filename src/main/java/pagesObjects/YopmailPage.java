package pagesObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yaml.snakeyaml.Yaml;
import java.util.List;


public class YopmailPage extends Page{
    private Yaml yaml = new Yaml();

    private String YOPMAIL_BASE_URL = "https://yopmail.com/fr/";
    @FindBy(id = "login")
    private WebElement emailInputYp;
    @FindBy(css = "button[class=md]")
    private WebElement btnConfYp;
    @FindBy(css = "iframe#ifinbox")
    private WebElement iframeElement;
    @FindBy(className = "lmf")
    private List<WebElement> email_msg_all;


    public void goToYopmail(){
        this.driver.get(YOPMAIL_BASE_URL);
    }
    public void writeEmailYp(String emailYp){
        super.writeText(this.emailInputYp, emailYp);
    }
    public void clickBtnConfYp(){
        super.clickOn(this.btnConfYp);
    }
    public void openAMessageInYp(String sender){
        this.driver.switchTo().frame(this.iframeElement);
        for (WebElement element : this.email_msg_all) {
            if (element.getText().contains(sender)){
                element.click();
                break;
            }
        }
        //email_msg.stream().map(element -> element )).forEach(element -> System.out.println(System.out.println(element.getText()));

        // Revenir au contexte par défaut (la page principale)
        this.driver.switchTo().defaultContent();

    }

    public void confirmeMailYp(){

        //NNaviguer vers le contexte du message selectionné
        WebElement iframeMessage = driver.findElement(By.cssSelector("iframe#ifmail"));
        driver.switchTo().frame(iframeMessage);
        this.driver.findElement(By.cssSelector("#mail a")).click();
    }

}
