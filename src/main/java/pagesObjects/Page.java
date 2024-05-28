package pagesObjects;

import managers.WebDrivenSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.refreshed;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {
    protected  WebDriver driver = WebDrivenSingleton.getInstance();
    private WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
    private static final Logger LOGGER = LoggerFactory.getLogger(Page.class);


    protected Page(){
        PageFactory.initElements(this.driver, this);
    }
    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void clickOn(WebElement element) {
            element.click();
    }

    //Wait tools
    public void waitVisibility(WebElement element) {
        wait.until(refreshed(visibilityOf(element)));
    }

    public void waitTextElementToBeVisible(WebElement webElement,String text ){
        this.wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    public void waitUrlContains(String url){
        wait.until(ExpectedConditions.urlContains(url));
    }
    public void waitUrlMacthes(String url){
        wait.until(ExpectedConditions.urlMatches(url));
    }

    public void openAndUseNewTab(String url){
         /*
        /   *Caster l'objet driver en JsExecutor, qui permet d'executer des script JS et executer le script
        /       la methode executeScript().
        /   *Naviguer entre les differents onglets
         */
        ((JavascriptExecutor) this.driver).executeScript("window.open()");
        // Récuperation des identifiants de tous les onglets
        Set<String> idTabsSet = this.driver.getWindowHandles();

        //Recuperation de l'actuel identifiant
        String oldTabId = driver.getWindowHandle();
        String newTabid;

        // Naviguer vers le nouvel onglet
        for (String idTab : idTabsSet) {
            if (!idTab.equals(oldTabId)) {
                newTabid = idTab;
                driver.switchTo().window(newTabid);
                break;
            }
        }
        this.driver.get(url);
    }

    public boolean isElementAbsent(By by) {
        try {
            driver.findElement(by);
            return false; // Element is present
        } catch (NoSuchElementException e) {
            LOGGER.info(e.getMessage());
            return true; // Element is absent
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return true;
        }
    }

    public boolean currentUrlContains(String val){
        return this.driver.getCurrentUrl().contains(val);
    }
    public boolean currentUrlMatches(String val){
        return this.driver.getCurrentUrl().matches(val);
    }

}
