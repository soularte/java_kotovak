package OpenDifferentBrowsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class LoginFirefox {

    private WebDriver driver;
    private WebDriverWait wait;
    private String adress = "http://localhost/litecart/en/";

    @Before
    public void start() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest() {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='loginAdmin']")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
