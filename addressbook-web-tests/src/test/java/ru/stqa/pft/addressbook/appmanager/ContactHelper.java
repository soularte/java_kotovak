package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
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
    //   click(By.xpath("//div[@id='content']/form/input[21]"));
    //click(By.xpath("//input[@name='submit'][1]"));
    click(By.xpath("//*[@id='content']/*/input[@value='Enter']"));
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
  }

  public void delecteSelectedContacts() {
//    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    click(By.xpath("//input[@value='Delete']"));
  }

  public void pressContactEdit(int index) {
    wd.findElements(By.xpath("//input[@title='Edit']")).get(index).click();
//    click(By.xpath("//input[@title='Edit']"));
  }

  public void submitContactModification() {
//    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    click(By.xpath("//input[@name='update'][1]"));
  }

  public void createContact(ContactData contactData, boolean creation) {
    click(By.linkText("add new"));
    fillContactCreationForm(contactData, true);
    submitContactCreation();
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return IsElementPresent(By.xpath("//input[@name='selected[]'][1]"));
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
  }

  public int getContactCountEdit() {return wd.findElements(By.xpath("//input[@src='icons/pencil.png']")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("selected[]"));
    for (WebElement element : elements ) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, null, null, name, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
