package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (!app.contact().isThereAContact()) {
      app.contact().create(new ContactData().
              withTestLastName("TestLastName1").
              withTestGroup("Test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    int index = before.size() - 1;
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).
            withTestLastName("TestLastName1").
            withTestGroup("Test1");
    app.contact().modify(index, contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
