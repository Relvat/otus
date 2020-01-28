import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class OpenOtusPage{
    public static String browser = System.getProperty("browser").toUpperCase();
    private static final Logger logger = LogManager.getLogger(OpenOtusPage.class);

    WebDriver wd = Browsers.valueOf(browser).create();

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
    public void test() {
        wd.get("https://otus.ru");
    }
}
