import config.serverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class mainPageTitleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(mainPageTitleTest.class);
    private serverConfig cfg = ConfigFactory.create(serverConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.get(cfg.url());
        logger.info("Открыта страница отус");
    }

    @Test
    public void titleEquals() {
        assertEquals(cfg.title(), driver.getTitle());
        logger.info("Проверка title");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
