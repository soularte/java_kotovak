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
    //   click(By.xpath("//div[@id='content']/form/input[21]"));
    click(By.xpath("//input[@name='submit'][1]"));
  }

  public void selectContact() {
//    click(By.name("selected[]"));
    click(By.xpath("//input[@name='selected[]'][1]"));
  }

  public void delecteSelectedContacts() {
//    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    click(By.xpath("//input[@value='Delete']"));
  }

  public void alertAccept() {
    wd.switchTo().alert().accept();
  }

  public void pressContactEdit() {
//    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    click(By.xpath("//input[@title='Edit']"));
  }

  public void submitContactModification() {
//    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    click(By.xpath("//input[@name='update'][1]"));
  }
}
