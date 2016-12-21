package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("TestName1",
                      "TestMiddleName1",
                      "TestLastName1",
                      "TestAddress1",
                      "TestMobile1",
                      "TestEmail1",
                      "Test1"),
              true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().delecteSelectedContacts();
    app.getContactHelper().alertAccept();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() -  1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    }
  }

