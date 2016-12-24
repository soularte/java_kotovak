package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData().
              withTestLastName("TestLastName1").
              withTestgroup("Test1"), true);
    }
  }

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().select(deletedContact);
    app.contact().delete();
    app.contact().alertAccept();
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}

