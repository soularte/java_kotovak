package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void GroupPage() {
    if (IsElementPresent(By.tagName("h1"))
            && find(By.tagName("h1")).getText().equals("Groups")
            && IsElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void homePage() {
    if (IsElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void goToContactCreationPage() {
    click(By.linkText("add new"));
  }
}
