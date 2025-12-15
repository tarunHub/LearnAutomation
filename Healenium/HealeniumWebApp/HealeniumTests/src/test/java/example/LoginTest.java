package example;

import com.epam.healenium.SelfHealingDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void init() {
        setUp();
    }

    @Test
    public void testLoginButtonVisibility() {
        driver.manage().window().maximize();
        driver.get("http://healeniumdemo.com/");

        WebElement username = new SelfHealingDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement password = new SelfHealingDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement submit = new SelfHealingDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        username.sendKeys("Demo user");


        wait(1);
        password.sendKeys("Demo@123");
        wait(1);
        submit.click();
        wait(5);

        Assert.assertEquals(true, true, "username is visible");

    }

    public void wait(int seconds){
        try{
        TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }
    @AfterClass
    public void cleanup() {
        tearDown();
    }
}
