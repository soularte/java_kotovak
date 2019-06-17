package OpenDifferentBrowsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFirefoxESR {

    private WebDriver driver;
    private WebDriverWait wait;
    private String adress = "http://localhost/litecart/en/";

    @Before
    public void start() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
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
