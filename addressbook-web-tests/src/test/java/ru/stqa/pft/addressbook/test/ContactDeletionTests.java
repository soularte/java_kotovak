package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactCreation() {
    if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("TestName1",
                            "TestMiddleName1",
                            "TestLastName1",
                            "TestAddress1",
                            "TestMobile1",
                            "TestEmail1",
                            "Test1"),
                    true);}
    app.getContactHelper().selectContact();
    app.getContactHelper().delecteSelectedContacts();
    app.getContactHelper().alertAccept();
  }


}
