import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class LiteCardNewItem extends TestBase {

    private String address = "http://localhost/litecart/admin/?app=catalog&doc=catalog";
    private String credentials = "admin";
    private String itemName = "ItemName";
    private String code = "Code";
    private String quantity = "1";
    private String datefrom = "10.12.18";
    private String dateto = "20.12.2018";
    private String purchasePrice = "120";
    private String curr = "EUR";
    private String keywords = "keywords";
    private String itemDescription = "Description of Item";

    @Test
    public void addNewItem() throws IOException {
        loginAdmin(address, credentials);
        driver.findElement(By.xpath("//a[contains(@href, 'edit_product')]")).click();
        fillGeneral();
        driver.findElement(By.xpath("//a[contains(@href, 'tab-prices')]")).click();
        fillPrices();
        driver.findElement(By.xpath("//a[contains(@href, 'tab-information')]")).click();
        fillInformation();
        driver.findElement(By.xpath("//button[@name='save']")).click();
        isElementPresent(By.xpath("//*[text()='" + itemName + "']"));
    }

    public void fillGeneral() throws IOException {
        driver.findElement(By.xpath("//label/input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys(itemName);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys(code);
        driver.findElement(By.xpath("//input[@data-name='Root']")).click();
        driver.findElement(By.xpath("//input[@data-name='Rubber Ducks']")).click();
        driver.findElement(By.xpath("//input[@value='1-3']")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quantity);
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys(datefrom);
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys(dateto);
        driver.findElement(By.xpath("//input[@name='new_images[]']")).sendKeys(toAbsolutePath(filePath, "item.jpg"));
    }

    public void fillPrices() {
        driver.findElement(By.xpath("//input[@name='purchase_price']")).clear();
        driver.findElement(By.xpath("//input[@name='purchase_price']")).sendKeys(purchasePrice);
        Select currency = new Select(driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']")));
        currency.selectByValue(curr);
        driver.findElement(By.xpath("//input[@name='gross_prices[USD]']")).clear();
        driver.findElement(By.xpath("//input[@name='gross_prices[USD]']")).sendKeys(purchasePrice);
        driver.findElement(By.xpath("//input[@name='gross_prices[EUR]']")).clear();
        driver.findElement(By.xpath("//input[@name='gross_prices[EUR]']")).sendKeys(purchasePrice);
    }

    public void fillInformation() {
        Select id = new Select(driver.findElement(By.xpath("//select[@name='manufacturer_id']")));
        id.selectByValue("1");
        driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys(keywords);
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys(itemDescription);
        driver.findElement(By.xpath("//textarea[@name='description[en]']")).sendKeys(itemDescription);
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys(itemName);
        driver.findElement(By.xpath("//input[@name='meta_description[en]']")).sendKeys(itemName);
    }

    @After
    public void remove() {
        driver.findElement(By.xpath("//*[text()='" + itemName + "']")).click();
        driver.findElement(By.xpath("//button[@name='delete']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
