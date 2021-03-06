package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    if (format.equals("csv") ) {
      saveAsCsv(groups, new File(file));
    } else if (format.equals ("xml")){
      saveAsXml(groups, new File(file));
    } else if (format.equals ("json")){
      saveAsJson(groups);
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander JCommander = new JCommander(generator);
    try {
    JCommander.parse(args);
    } catch (ParameterException ex) {
      JCommander.usage();
      return;
    }
    generator.run();
  }

  private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (GroupData group : groups) {
        writer.write(String.format("%s;%s;%s\n", group.getGroupName(), group.getGroupHeader(), group.getGroupFooter()));
      }
    }
  }

  private void saveAsXml(List<GroupData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    String xml = xstream.toXML(groups);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsJson(List<GroupData> groups) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData()
              .withName(String.format("test %s", i))
              .withHeader(String.format("heaader %s", i))
              .withFooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
