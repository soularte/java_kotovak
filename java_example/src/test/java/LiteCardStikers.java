import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

public class LiteCardStikers extends TestBase {

    private String adress = "http://localhost/litecart/admin/";
    private String login = "admin";

    @Test
    public void adminTest() {
        login();
        int numberOfLinks = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li")).size();
            for (int i = 1; i <= numberOfLinks; i++) {
                driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/a")).click();
                int numberOfInnerLinks = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/ul/li/a")).size();
                    for (int a = 1; a <= numberOfInnerLinks; a++) {
                        driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/ul/li[" + a + "]/a")).click();
                        isElementPresent(By.xpath("//*[@id='content']/h1"));
                    }
                }
    }

    public void login() {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(login);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(login);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }
}
