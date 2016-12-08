package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

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
    if (text != null) {
      String existingText = e.getAttribute("value");
      if (!text.equals(existingText)) {
        e.clear();
        e.sendKeys(text);
      }
    }
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

  public boolean IsElementPresent(By locator) {
    try {
      find(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
