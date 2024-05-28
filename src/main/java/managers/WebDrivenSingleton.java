package managers;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivenSingleton {
    private static WebDriver driver;
    @Getter
    static final String baseUrl = YamlConfigManager.getInstance().getDictable().getUrl();


    public static WebDriver getInstance(){
        if (driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
        return driver;
    }

    public static void navigateTo(String endpoint) {
        driver.get(baseUrl + endpoint);
    }

    public static void destroy(){
        driver.quit();
        driver = null;
    }
}
