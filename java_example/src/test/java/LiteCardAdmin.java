import org.junit.Test;
import org.openqa.selenium.By;

public class LiteCardAdmin extends TestBase {

    private String adress = "http://localhost/litecart/admin/";
    private String credentials = "admin";

    @Test
    public void adminTest() {
        loginAdmin(adress, credentials);
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
}
