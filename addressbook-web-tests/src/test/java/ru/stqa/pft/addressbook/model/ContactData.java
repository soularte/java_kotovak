package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String testName;
  private String testMiddleName;
  private String testLastName;
  private String testAddress;
  private String testMobile;
  private String testEmail;
  private String testGroup;

  public void id(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getTestName() {
    return testName;
  }

  public String getTestMiddleName() {
    return testMiddleName;
  }

  public String getTestLastName() {
    return testLastName;
  }

  public String getTestAddress() {
    return testAddress;
  }

  public String getTestMobile() {
    return testMobile;
  }

  public String getTestEmail() {
    return testEmail;
  }

  public String getTestGroup() {
    return testGroup;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withTestName(String testName) {
    this.testName = testName;
    return this;
  }

  public ContactData withTestMiddleName(String testMiddleName) {
    this.testMiddleName = testMiddleName;
    return this;
  }

  public ContactData withTestLastName(String testLastName) {
    this.testLastName = testLastName;
    return this;
  }

  public ContactData withTestAddress(String testAddress) {
    this.testAddress = testAddress;
    return this;
  }

  public ContactData withTestMobile(String testMobile) {
    this.testMobile = testMobile;
    return this;
  }

  public ContactData withTestEmail(String testEmail) {
    this.testEmail = testEmail;
    return this;
  }

  public ContactData withTestgroup(String testgroup) {
    this.testGroup = testgroup;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    return testLastName != null ? testLastName.equals(that.testLastName) : that.testLastName == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (testLastName != null ? testLastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", testLastName='" + testLastName + '\'' +
            '}';
  }
}
