package step;

import base.BaseTest;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class StepImplementation extends BaseTest {

    @Step("Urune tıkla")
    public void clickProduct() {

    }

    @Step("<url> sayfasina git")
    public void navigate(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Step("Sayfanin acildiğindan emin ol")
    public void check() {
        String title = driver.getTitle();
        String expectedText = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        assertText(expectedText, title);
    }

    @Step("<int> saniye bekle")
    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("<key> elementine tikla")
    public void clickLogin(String key) {
        clickElement(key);
    }

    @Step("<key> elementinin üzerine gel")
    public void hover(String key) {
        hoverElement(key);
    }

    @Step("<key> elementine <sifre> gir")
    public void setText(String key, String sifre) {
        sendKeys(key, sifre);
    }

    @Step("<key> elementi var mi")
    public void checkElement(String key) {
        try {
            findElement(key);
        } catch (Exception e) {
            Assert.fail("Element bulunamadı.");
        }
    }

    @Step("<key> elementinde yazan isim ile <hesapSahibi>'ni karşılaştır")
    public void checkName(String key, String hesapSahibi) {
        assertElementText(key, hesapSahibi);
    }

    @Step("<key> elementinde enter'a tikla")
    public void sendEnter(String key) {
        findElement(key).sendKeys(Keys.ENTER);
    }

    @Step("<key> element listesindeki ilk elemente tıkla")
    public void clickProduct(String key) {
        findElements(key).get(0).click();
    }

    @Step("<key> element listesi var mi")
    public void checkElements(String key) {
        try {
            findElements(key);
        } catch (Exception e) {
            Assert.fail("Elementler bulunamadı.");
        }
    }

    @Step("<key> urun adedini kontrol et")
    public void checkPrice(String key) {
        String expectedText = "Sepetim (1 Ürün)";
        assertElementText(key,expectedText);
    }
}