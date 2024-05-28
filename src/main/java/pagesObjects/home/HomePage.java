package pagesObjects.home;

import lombok.Getter;
import managers.WebDrivenSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesObjects.Page;

import java.time.Duration;

@Getter
public class HomePage extends Page {

    @FindBy(css = "button[aria-label='search']")
    private WebElement searchBtn;
    @FindBy(id = "outlined-start-adornment")
    private WebElement inputSearch;
    @FindBy(css = "body > div.MuiDialog-root.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollPaper.css-ekeie0 > div > div > div > div > div > div")
    private WebElement result;
    @FindBy(css = ".MuiButtonBase-root.MuiIconButton-root.MuiIconButton-sizeMedium.css-1epzq7y")
    private WebElement menuIcon;
    @FindBy(css = "#demo-positioned-menu > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-rounded.MuiPaper-elevation8.MuiMenu-paper.MuiPopover-paper.MuiMenu-paper.css-19hbzgt > ul > li:nth-child(16)")
    private WebElement logoutBtn;



    private final WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void clickOnSearchBtn(){
        super.clickOn(this.searchBtn);
    }

    public void writeInputSearch(String text){
        super.writeText(this.inputSearch, text);
    }

    public void searchADictation(String dictationTitle) throws InterruptedException {
        this.clickOnSearchBtn();
        this.writeInputSearch(dictationTitle);
        Thread.sleep(3000);
        super.waitVisibility(this.result);
        super.clickOn(this.result);
    }

    public void logout(){
        super.waitVisibility(this.menuIcon);
        super.clickOn(this.menuIcon);
        super.waitVisibility(this.logoutBtn);

        super.clickOn(this.logoutBtn);
    }

    public void goTohome() {
        super.driver.get("https://dictable.org");
    }
}
