package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {

  private WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    WebElement e = find(locator);
    e.click();
  }

  public WebElement find(By locator) {
    return wd.findElement(locator);
  }

  public void type(By locator, String text) {
    WebElement e = find(locator);
    e.clear();
    e.sendKeys(text);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void alertAccept() {
    wd.switchTo().alert().accept();
    find(By.tagName("body"));
  }
}
