package example;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
         driver = new ChromeDriver(options);
       // driver = SelfHealingDriver.create(delegate);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}