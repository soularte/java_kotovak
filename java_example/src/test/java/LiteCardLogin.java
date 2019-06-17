import org.junit.Test;
import org.openqa.selenium.By;

public class LiteCardLogin extends TestBase {

    private String adress = "http://localhost/litecart/en/";

    @Test
    public void firstTest() {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='loginAdmin']")).click();
    }

}
