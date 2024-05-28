package pagesObjects;

import enums.EndpointEnums;
import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class DictationPage extends Page {

    @FindBy(css = "body > div.MuiDialog-root.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollPaper.css-ekeie0 > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-14b29qc > button")
    private WebElement closeListenBtn;
    @FindBy(id = "dictation")
    private WebElement dictationTextarea;
    @FindBy(css = "#root > div.MuiBox-root.css-mikc7i > div.MuiContainer-root.MuiContainer-maxWidthMd.css-1c0cfyw > div > form > div.MuiBox-root.css-1gte0kt > div.MuiBox-root.css-0 button:first-child")
    private WebElement correctBtn;

    @FindBy(css = "body > div.MuiDialog-root.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollPaper.css-ekeie0 > div > div.MuiDialogActions-root.MuiDialogActions-spacing.css-14b29qc > button.MuiButtonBase-root.MuiButton-root.MuiButton-text.MuiButton-textError.MuiButton-sizeSmall.MuiButton-textSizeSmall.MuiButton-root.MuiButton-text.MuiButton-textError.MuiButton-sizeSmall.MuiButton-textSizeSmall.css-1eolt79")
    private WebElement confCorrectionBtn;
    @FindBy(css = ".MuiBox-root.css-rjlnb4 p")
    private WebElement notationFrame;


    private final WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void doDictaction(String answer){
        super.waitVisibility(this.closeListenBtn);
        super.clickOn(this.closeListenBtn);
        super.writeText(this.dictationTextarea, answer);
        super.waitVisibility(this.correctBtn);
        super.clickOn(this.correctBtn);
    }

    public void confirmationAndSubmitDictation() throws InterruptedException {
        super.waitVisibility(this.confCorrectionBtn);
        super.clickOn(this.confCorrectionBtn);

        Thread.sleep(4000);

        //WebDrivenSingleton.navigateTo(EndpointEnums.HOME.getEndpoint());
    }

    public boolean seeNote(String note){
        super.waitVisibility(this.notationFrame);
        return this.notationFrame.getText().contains(note);
    }

}
