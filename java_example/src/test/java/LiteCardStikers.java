import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LiteCardStikers extends TestBase {

    private String adress = "http://localhost/litecart/en/";

    @Test
    public void stikersTest() {
        driver.get(adress);
        List<WebElement> items = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));
        System.out.println(items.size());
        for (WebElement item : items) {
            int numberOfStikers = item.findElements(By.xpath("./a[1]/div[1]/div[starts-with(@class, 'sticker')]")).size();
            Assert.assertEquals(1, numberOfStikers);
        }
    }
}