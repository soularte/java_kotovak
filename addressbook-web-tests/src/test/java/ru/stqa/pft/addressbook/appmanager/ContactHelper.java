package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactCreationForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getTestName());
    type(By.name("middlename"), contactData.getTestMiddleName());
    type(By.name("lastname"), contactData.getTestLastName());
    type(By.name("address"), contactData.getTestAddress());
    type(By.name("mobile"), contactData.getTestMobile());
    type(By.name("email"), contactData.getTestEmail());
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
}
