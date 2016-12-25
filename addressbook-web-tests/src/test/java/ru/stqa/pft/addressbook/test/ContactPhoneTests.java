package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfroFromEditedForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfroFromEditedForm)));
    assertThat(contact.getAllAddresses(), equalTo(contactInfroFromEditedForm.getTestAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfroFromEditedForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTestHome(), contact.getTestMobile(), contact.getTestWork())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeAdresses(ContactData contact) {
    return Arrays.asList(contact.getTestAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getTestEmail(), contact.getTestEmail1(), contact.getTestEmail2())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
