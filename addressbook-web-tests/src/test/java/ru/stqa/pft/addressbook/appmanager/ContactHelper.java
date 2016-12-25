package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

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
    fillContactCreationForm(contactData, true);
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

  public int getContactCount() {
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
    if (contactCache !=null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withTestLastName(name));
    }
    return new Contacts(contactCache);
  }

}

