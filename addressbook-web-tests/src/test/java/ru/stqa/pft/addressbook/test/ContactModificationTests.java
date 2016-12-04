package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("TestName1",
                      "TestMiddleName1",
                      "TestLastName1",
                      "TestAddress1",
                      "TestMobile1",
                      "TestEmail1",
                      "Test1"),
              true);}
    app.getContactHelper().pressContactEdit();
    app.getContactHelper().fillContactCreationForm(new ContactData("TestName2",
            "TestMiddleName2",
            "TestLastName2",
            "TestAddress2",
            "TestMobile2",
            "TestEmail2",
            null),
            false);
    app.getContactHelper().submitContactModification();
  }

}
