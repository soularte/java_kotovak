import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LiteCardNewUser extends TestBase {

    private String address = "http://localhost/litecart/en/";
    private String firstName = "FirstName";
    private String lastName = "LastName";
    private String streetAddress = "Street";
    private String postcode = "12345";
    private String city = "City";
    private String code = "AL";
    private String country = "United States";
    private String phone = "+19114457732";
    private String password = "12ASD!";

    @Test
    public void loginWithNew() {
        driver.get(address);
        String email = createRandomEmail(5, "ABCDEFJHIJKLMNOPQRSTUVWXYZ") + "@test.com";
        createUser(email);
        loginUser(address, email, password);
        driver.findElement(By.xpath(("//div[@id='box-account']/div/ul/li[4]/a"))).click();
    }

    public void createUser(String email) {
        driver.findElement(By.xpath("//form[@name='login_form']/table/tbody/tr[5]/td/a")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(streetAddress);
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(postcode);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
        driver.findElement(By.xpath("//span[@class='select2-selection__rendered']")).click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(country + Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys(password);
        WebElement zones = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='zone_code']")));
        Select zone = new Select(zones);
        zone.selectByValue(code);
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath(("//div[@id='box-account']/div/ul/li[4]/a"))).click();
    }

    public String createRandomEmail(int codeLength, String id) {
        List<Character> temp = id.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Collections.shuffle(temp, new SecureRandom());
        return temp.stream()
                .map(Object::toString)
                .limit(codeLength)
                .collect(Collectors.joining());
    }
}
