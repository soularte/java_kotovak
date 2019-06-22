import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.io.IOException;
import java.util.List;


public class LiteCardCategory extends TestBase {

    private String address = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
    private String credentials = "admin";

    @Test
    public void itemCategoryTest() throws IOException {
        loginAdmin(address, credentials);
        int itemsStart = driver.findElements(By.xpath("//img[contains(@src, 'fwb.png')]")).size();
        System.out.println(itemsStart);
        List<WebElement> rows = driver.findElements(By.xpath("//tr/td[3]"));
        int itemEnd = 0;
        for (int i = 2; i <= rows.size(); i++) {
            try {
                WebElement element = driver.findElement(By.xpath("//tr[" + i + "]/td[3]/img[contains(@src, 'fwb.png')]"));
                driver.findElement(By.xpath("//tr[" + i + "]/td[3]/a")).click();
                for (LogEntry l : driver.manage().logs().get("browser")) {
                    String msg = l.getMessage();
                    System.out.println("browser log contains" + msg);
                    Assert.assertEquals(msg, "");
                }
                isElementPresent(By.xpath("//*[@id='content']/h1"));
                itemEnd++;
                driver.findElement(By.xpath("//button[@name='cancel']")).click();
            } catch (NoSuchElementException e) { }
        }
        Assert.assertEquals(itemsStart, itemEnd);
    }
}

