import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LiteCardStikers extends TestBase {

    private String adress = "http://localhost/litecart/en/";
    private Object items;

    @Test
    public void stikersTest() {
        driver.get(adress);
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='image-wrapper']"));
        for ( WebElement item: items ) {
            int numberOfStikers = item.findElements(By.xpath("./div[starts-with(@class, 'sticker')]")).size();
            Assert.assertEquals(1, numberOfStikers);
        }
    }
}