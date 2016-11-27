package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().selectContact();
    app.getContactHelper().delecteSelectedContacts();
    app.getContactHelper().alertAccept();
  }


}
