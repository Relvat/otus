import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class YaMarketTest{

    private static final Logger logger = LogManager.getLogger(YaMarketTest.class);

    WebDriver wd = Browsers.CHROME.create();
    WebDriverWait wait = new WebDriverWait(wd, 55);
    public static final By SEARCH_FIELD = By.cssSelector("#header-search");

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @After
    public void tearDown() {
        if (wd != null) {
            wd.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        logger.info("Открываем страницу яндекс маркета");
        wd.get("https://market.yandex.ru/catalog--mobilnye-telefony/54726/list?hid=91491&track=pieces&local-offers-first=0&onstock=1");
        logger.info("Фильтруем по списку Redmi и Xiaomi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_FIELD)).sendKeys("Xiaomi");
    }
}
