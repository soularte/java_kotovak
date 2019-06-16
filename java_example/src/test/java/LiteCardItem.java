import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LiteCardItem extends TestBase {

    private String adress = "http://localhost/litecart/en/";
    private String itemName;

    public static String[] getStrArray(String item) {
        String[] colors = item.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(colors[0].trim());
        int g = Integer.parseInt(colors[1].trim());
        int b = Integer.parseInt(colors[2].trim());
        return colors;
    }

    @Test
    public void checkItemName() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        String itemName1 = element.getText();
        element.click();
        String itemName2 = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(itemName1, itemName2);
    }

    @Test
    public void checkItemPrice() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        String itemPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/s")).getText();
        String itemSale = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/strong")).getText();
        element.click();
        String itemPriceNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getText();
        String itemSaleNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getText();
        Assert.assertEquals(itemPrice, itemPriceNew);
        Assert.assertEquals(itemSale, itemSaleNew);
    }

    @Test
    public void checkItemPriceStyle() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        String itemPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/s")).getTagName();
        String itemSale = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/strong")).getTagName();
        element.click();
        String itemPriceNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getTagName();
        String itemSaleNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getTagName();
        Assert.assertEquals(itemPrice, itemPriceNew);
        Assert.assertEquals(itemPriceNew, "s");
        Assert.assertEquals(itemSale, itemSaleNew, "strong");
        Assert.assertEquals(itemSaleNew, "strong");
    }

    @Test
    public void checkItemPriceHeight() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        int itemPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/s")).getSize().getHeight();
        int itemSale = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/strong")).getSize().getHeight();
        Assert.assertTrue(itemPrice < itemSale);
        element.click();
        int itemPriceNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getSize().getHeight();
        int itemSaleNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getSize().getHeight();
        Assert.assertTrue(itemPriceNew < itemSaleNew);
    }

    @Test
    public void checkItemPriceColor() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        String itemPrice = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/s")).getCssValue("color");
        String[] colors = itemPrice.replace("rgba(", "").replace(")", "").split(",");
        int r1 = Integer.parseInt(colors[0].trim());
        int g1 = Integer.parseInt(colors[1].trim());
        int b1 = Integer.parseInt(colors[2].trim());
        System.out.println("red " + r1 + " green " + g1 + " blue " + b1);
        Assert.assertEquals(r1, g1);
        Assert.assertEquals(g1, b1);
        element.click();
        String itemPriceNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/s")).getCssValue("color");
        String[] colorsNew = itemPrice.replace("rgba(", "").replace(")", "").split(",");
        int r2 = Integer.parseInt(colorsNew[0].trim());
        int g2 = Integer.parseInt(colorsNew[1].trim());
        int b2 = Integer.parseInt(colorsNew[2].trim());
        System.out.println("red " + r2 + " green " + g2 + " blue " + b2);
        Assert.assertEquals(r2, g2);
        Assert.assertEquals(g2, b2);
    }

    @Test
    public void checkItemSaleColor() {
        driver.get(adress);
        WebElement element = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[@class='name']"));
        String itemSale = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[1]/div[4]/strong")).getCssValue("color");
        String[] colors = itemSale.replace("rgba(", "").replace(")", "").split(",");
        int r1 = Integer.parseInt(colors[0].trim());
        int g1 = Integer.parseInt(colors[1].trim());
        int b1 = Integer.parseInt(colors[2].trim());
        System.out.println("red " + r1 + " green " + g1 + " blue " + b1);
        Assert.assertEquals(0, g1);
        Assert.assertEquals(g1, b1);
        element.click();
        String itemSaleNew = driver.findElement(By.xpath("//div[@class='price-wrapper']/strong")).getCssValue("color");
        String[] colorsNew = itemSaleNew.replace("rgba(", "").replace(")", "").split(",");
        int r2 = Integer.parseInt(colorsNew[0].trim());
        int g2 = Integer.parseInt(colorsNew[1].trim());
        int b2 = Integer.parseInt(colorsNew[2].trim());
        System.out.println("red " + r2 + " green " + g2 + " blue " + b2);
        Assert.assertEquals(0, g2);
        Assert.assertEquals(g2, b2);
    }

}