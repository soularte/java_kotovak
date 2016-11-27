package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().goToContactCreationPage();
    app.getContactHelper().fillContactCreationForm(new ContactData("TestName1", "TestMiddleName1", "TestLastName1", "TestAddress1", "TestMobile1", "TestEmail1"));
    app.getContactHelper().submitContactCreation();
  }


}
