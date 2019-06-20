import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiteCardSHoppingCart extends TestBase {

    private String adress = "http://litecart.stqa.ru/en/";
    private String code = "Small";

    @Test
    public void checkItemInShoppingCart() {
        driver.get(adress);
        fillCart();
        WebElement checkout = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'checkout')][3]")));
        checkout.click();
        clearCart();
        WebElement text = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='There are no items in your cart.']")));
    }

    public void fillCart() {
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.xpath("//a[contains(@href, 'yellow-duck-p-1')]")).click();
            WebElement sizes = driver.findElement(By.xpath("//select[@name='options[Size]']"));
            Select size = new Select(sizes);
            size.selectByValue(code);
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            WebElement quantity = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + i + "']")));
            driver.findElement(By.xpath("//a[contains(@href, '" + adress + "')]")).click();
        }
    }

    public void clearCart() {
        for (int i = 3; i >= 0; i--) {
            String quantuty = Integer.toString(i);
            driver.findElement(By.xpath("//input[@name='quantity']")).clear();
            driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(quantuty);
            driver.findElement(By.xpath("//button[@name='update_cart_item']")).click();
            WebElement summaryTable = driver.findElement(By.xpath("//table[@class='dataTable rounded-corners']"));
            wait.until(ExpectedConditions.stalenessOf(summaryTable));
        }
    }
}