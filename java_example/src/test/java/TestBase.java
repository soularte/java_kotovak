import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public String filePath = "C:/_project./java_kotovak/java_example/src/test/resources/";
    public String id = "C:/_project./java_kotovak/java_example/src/test/resources/";

    public static String toAbsolutePath(String filePath, String maybeRelative) {
        Path path = Paths.get(maybeRelative);
        Path effectivePath = path;
        if (!path.isAbsolute()) {
            Path base = Paths.get(filePath);
            effectivePath = base.resolve(path).toAbsolutePath();
        }
        return effectivePath.normalize().toString();
    }

    public boolean isElementPresent(By locator) {
        try {
            wait.until((WebDriver d) -> d.findElement(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }

    public void loginAdmin(String adress, String credentials) {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(credentials);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(credentials);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    public void loginUser(String adress, String email, String password) {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    public String createRandomEmail(int codeLength, String id) {
        List<Character> temp = id.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Collections.shuffle(temp, new SecureRandom());
        return temp.stream()
                .map(Object::toString)
                .limit(codeLength)
                .collect(Collectors.joining());
    }
}
