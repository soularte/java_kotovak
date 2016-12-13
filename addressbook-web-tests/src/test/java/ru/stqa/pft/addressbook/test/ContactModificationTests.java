package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("TestName1",
              "TestMiddleName1",
              "TestLastName1",
              "TestAddress1",
              "TestMobile1",
              "TestEmail1",
              "Test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "TestName2",
            "TestMiddleName2",
            "TestLastName2",
            "TestAddress2",
            "TestMobile2",
            "TestEmail2",
            "Test2");
    app.getContactHelper().pressContactEdit(before.size() - 1);
    app.getContactHelper().fillContactCreationForm(contact, false);
    app.getContactHelper().submitContactModification();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
