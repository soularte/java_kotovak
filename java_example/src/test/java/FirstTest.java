import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends TestBase {

    @Test
    public void firstTest() {
        driver.get("http://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

}
