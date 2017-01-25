package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.test.ContactPhoneTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactCreationForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getTestName());
    type(By.name("middlename"), contactData.getTestMiddleName());
    type(By.name("lastname"), contactData.getTestLastName());
    type(By.name("address"), contactData.getTestAddress());
    type(By.name("mobile"), contactData.getTestMobile());
    type(By.name("email"), contactData.getTestEmail());
    attach(By.name("photo"),contactData.getPhoto());

    if (creation) {
      new Select(find(By.name("new_group"))).selectByVisibleText(contactData.getTestGroup());
    } else {
      Assert.assertFalse(IsElementPresent(By.name("new_group")));
    }
  }

  public void submitContactCreation() {
    click(By.xpath("//*[@id='content']/*/input[@value='Enter']"));
  }

  public void select(int index) {
    wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
  }

  public void selectById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public void pressContactEdit(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }


  public void submitContactModification() {
    click(By.xpath("//input[@name='update'][1]"));
  }

  public void create(ContactData contactData, boolean creation) {
    click(By.linkText("add new"));
    fillContactCreationForm(contactData, creation);
    submitContactCreation();
    contactCache = null;
    click(By.linkText("home"));
  }

  public void modify(int index, ContactData contact) {
    pressContactEdit(index);
    fillContactCreationForm(contact, false);
    submitContactModification();
    contactCache = null;
    click(By.linkText("home page"));
  }

  public void modifyById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void viewById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    modifyById(contact.getId());
    String testName = find(By.name("firstname")).getAttribute("value");
    String testLastName = find(By.name("lastname")).getAttribute("value");
    String testMiddleName = find(By.name("middlename")).getAttribute("value");
    String testHome = find(By.name("home")).getAttribute("value");
    String testMobile = find(By.name("mobile")).getAttribute("value");
    String testWork = find(By.name("work")).getAttribute("value");
    String testAddress = find(By.name("address")).getText();
    String testEmail = find(By.name("email")).getAttribute("value");
    String testEmail1 = find(By.name("email2")).getAttribute("value");
    String testEmail2 = find(By.name("email3")).getAttribute("value");
    click(By.linkText("home"));
    return new ContactData().
            withId(contact.getId()).
            withTestName(testName).
            withTestMiddleName(testMiddleName).
            withTestLastName(testLastName).
            withTestHome(testHome).
            withTestMobile(testMobile).
            withTestWork(testWork).
            withTestAddress(testAddress).
            withTestEmail(testEmail).
            withTestEmail1(testEmail1).
            withTestEmail2(testEmail2);
  }

  public void delete(ContactData deletedContact) {
    select(deletedContact);
    delete();
    alertAccept();
    contactCache = null;
    click(By.linkText("home"));
  }

  public void select(ContactData contact) {
    selectById((contact).getId());
  }

  public boolean isThereAContact() {
    return IsElementPresent(By.xpath("//input[@name='selected[]'][1]"));
  }

  public int count() {
    return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
  }

  public int getContactCountEdit() {
    return wd.findElements(By.xpath("//input[@src='icons/pencil.png']")).size();
  }

  private Contacts contactCache = null;

  public List<ContactData> List() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withTestLastName(name));
    }
    return contacts;
  }

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allAddresses = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData().
              withId(id).
              withTestName(firstname).
              withTestLastName(lastname).
              withAllPhones(allPhones).
              withAllAddresses(allAddresses).
              withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public void contactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  private void groupByName(String name) {
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(name);
  }

}

