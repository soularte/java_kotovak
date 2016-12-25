package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPersonalDataTests extends TestBase {

  @Test
  public void testContactPersonalData() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditedForm = app.contact().infoFromEditForm(contact);
    String mergedContactInfoFromEditedForm = mergeData(contactInfoFromEditedForm);
    app.contact().viewById(contact.getId());
    String allText = cleaned(app.contact().find(By.id("content")).getText());
    assertThat(allText, equalTo(mergedContactInfoFromEditedForm));
  }

  private String mergeData(ContactData contact) {
    return Arrays.asList(
            contact.getTestName(),
            contact.getTestMiddleName(),
            contact.getTestLastName(),
            contact.getTestAddress(),
            contact.getTestHome(),
            contact.getTestMobile(),
            contact.getTestWork(),
            contact.getTestEmail(),
            contact.getTestEmail1(),
            contact.getTestEmail2())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPersonalDataTests::cleaned)
            .collect(Collectors.joining(""));
  }

  public static String cleaned(String cleaned) {
    return cleaned.replaceAll("\\s", "").replaceAll("[-()HMW:]", "").replaceAll("\n", "");
  }

}
