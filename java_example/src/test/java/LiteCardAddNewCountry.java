import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

public class LiteCardAddNewCountry extends TestBase {

    private String adress = "http://localhost/litecart/admin/?app=countries&doc=countries";
    private String credentials = "admin";

    @Test
    public void addNewContryTest() {
        loginAdmin(adress, credentials);
        driver.findElement(By.xpath("//a[contains(@href, 'edit_country')][1]")).click();
        List<WebElement> links = driver.findElements(By.xpath("//i[@class='fa fa-external-link']"));
        for (WebElement link : links) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            link.click();
            String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }

    public ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handels = driver.getWindowHandles();
                handels.removeAll(oldWindows);
                return handels.size() > 0 ? handels.iterator().next() : null;
            }
        };
    }
}






