package base;

import com.thoughtworks.gauge.BeforeScenario;
import helper.ElementHelper;
import helper.StoreHelper;
import model.ElementInfo;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    WebDriverWait wait;


    @BeforeScenario
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebElement findElement(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }

    public List<WebElement> findElements(String key){
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        return driver.findElements(infoParam);
    }


    public void clickElement(String key){
        findElement(key).click();
    }

    public void hoverElement(String key) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(key)).build().perform();
    }

    public void sendKeys(String key, String text){
        findElement(key).sendKeys(text);
    }

    public void assertElementText(String key, String expectedText){
        String actualText = findElement(key).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    public void assertTwoElementText(String key1, String key2){
        String actualText = findElement(key1).getText();
        String expectedText = findElement(key2).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    public void assertText(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }
}
