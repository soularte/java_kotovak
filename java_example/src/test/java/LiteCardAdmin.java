import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

public class LiteCardAdmin extends TestBase {

    private String adress = "http://localhost/litecart/admin/";
    private String login = "admin";

    @Test
    public void adminTest() {
        login();
        int numberOfLinks = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li")).size();
        try {
            for (int i = 1; i <= numberOfLinks; i++) {
                driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/a")).click();
                int numberOfInnerLinks = driver.findElements(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/ul/li/a")).size();
                try {
                    for (int a = 1; a <= numberOfInnerLinks; a++) {
                        driver.findElement(By.xpath("//*[@id='box-apps-menu']/li[" + i + "]/ul/li[" + a + "]/a")).click();
                        isElementPresent(By.xpath("//*[@id='content']/h1"));
                    }
                } catch (StaleElementReferenceException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (StaleElementReferenceException ex) {
            ex.printStackTrace();
        }
    }

    public void login() {
        driver.get(adress);
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys(login);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(login);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }
}
