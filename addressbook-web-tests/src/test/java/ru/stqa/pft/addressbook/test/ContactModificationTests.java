package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().pressContactEdit();
    app.getContactHelper().fillContactCreationForm(new ContactData("TestName2", "TestMiddleName2", "TestLastName2", "TestAddress2", "TestMobile2", "TestEmail2"));
    app.getContactHelper().submitContactModification();
  }

}
