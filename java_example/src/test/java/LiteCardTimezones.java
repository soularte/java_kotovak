import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;

public class LiteCardTimezones extends TestBase {

    private String adress = "http://localhost/litecart/admin/?app=countries&doc=countries";
    private String geo = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";
    private String credentials = "admin";

    @Test
    public void timeZonesOrderTest() {
        login(adress, credentials);
        String temp = null;
        List<WebElement> timezones = driver.findElements(By.xpath("//tr/td[4]"));
        String[] strArray = new String[timezones.size()];
        for (int i = 0; i < timezones.size(); i++) {
            timezones = driver.findElements(By.xpath("//tr/td[4]"));
            strArray[i] = timezones.get(i).getText();
        }
        check(strArray);
    }

    @Test
    public void timeZonesNotNullTest() {
        login(adress, credentials);
        List<WebElement> rows = driver.findElements(By.xpath("//tr/td[6]"));
        for (int i = 2; i < rows.size(); i++) {
            WebElement element = driver.findElement(By.xpath("//tr[" + i + "]/td[6]"));
            int value = Integer.parseInt(element.getAttribute("textContent"));
            if (value > 0) {
                driver.findElement(By.xpath("//tr[" + i + "]/td[7]")).click();
                List<WebElement> timezones = driver.findElements(By.xpath("//input[contains(@name, 'code')]"));
                System.out.println(timezones.size());
                String[] strArraу = new String[timezones.size()];
                for (int a = 0; a < timezones.size(); a++) {
                    timezones = driver.findElements(By.xpath("//input[contains(@name, 'code')]"));
                    strArraу[a] = timezones.get(a).getAttribute("value");
                }
                check(strArraу);
                driver.get(adress);
            }
        }
    }

    @Test
    public void timeGeoZonesTest() {
        login(geo, credentials);
        List<WebElement> rows = driver.findElements(By.xpath("//tr/td[3]/a"));
        driver.findElement(By.xpath("//tr[2]/td[3]/a")).click();
        List<WebElement> timezones = driver.findElements(By.xpath("//select[contains(@name, 'zone_code')]"));
        String[] strArray = new String[timezones.size()];
        for (int a = 0; a < timezones.size(); a++) {
            timezones = driver.findElements(By.xpath("//select[contains(@name, 'zone_code')]/option[contains(@selected, 'selected')]"));
            strArray[a] = timezones.get(a).getAttribute("value");
        }
        check(strArray);
        driver.get(geo);
    }

    public void check(String[] strArray) {
        String[] before = strArray;
        System.out.println("Before set" + before);
        Arrays.sort(strArray);
        System.out.println("After set" + strArray);
        Assert.assertArrayEquals(before, strArray);
    }
}






