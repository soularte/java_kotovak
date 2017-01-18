package ru.stqa.pft.addressbook.test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validСontactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
    }.getType()); // List<ContactData>.class
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
  }
}

  @Test(enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

  @Test(dataProvider = "validСontactsFromJson")
  public void testContactCreation(ContactData contact) {
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/photo.jpeg");
    app.contact().create(contact, true);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().
            withTestName("'''").
            withTestGroup("Test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
