package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

//  private void run() throws IOException {
//    List<ContactData> contacts = generateContacts(count);
//    saveAsJson(contacts);
//  }

  private void saveAsJson(List<ContactData> contacts) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander JCommander = new JCommander(generator);
    try {
      JCommander.parse(args);
    } catch (ParameterException ex) {
      JCommander.usage();
      return;
    }
//    generator.run();
  }

//  private List<ContactData> generateContacts(int count) {
//    List<ContactData> contacts = new ArrayList<ContactData>();
//    for (int i = 0; i < count; i++) {
//      contacts.add(new ContactData()
//              .withTestName(String.format("TestName %s", i))
//              .withTestLastName(String.format("TestLastName %s", i))
//              .withTestGroup(String.format("TestGroup %s", i)));
//    }
//    return contacts;
//  }
}
