package managers;

import io.qameta.allure.Allure;
import junit.framework.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AssertManager {

    public static void customAssert(boolean assertion, String errorMessage){
        if(!assertion){
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) WebDrivenSingleton.getInstance()).getScreenshotAs(OutputType.BYTES)));
            Assert.assertTrue(errorMessage, assertion);
        }

    }
}
