package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String testName;
  private final String testMiddleName;
  private final String testLastName;
  private final String testAddress;
  private final String testMobile;
  private final String testEmail;
  private String testgroup;

  public ContactData(int id,
          String testName,
                     String testMiddleName,
                     String testLastName,
                     String testAddress,
                     String testMobile1,
                     String testEmail,
                     String testgroup) {
   this.id = id;
    this.testName = testName;
    this.testMiddleName = testMiddleName;
    this.testLastName = testLastName;
    this.testAddress = testAddress;
    this.testMobile = testMobile1;
    this.testEmail = testEmail;
    this.testgroup = testgroup;
  }

  public ContactData(String testName,
                     String testMiddleName,
                     String testLastName,
                     String testAddress,
                     String testMobile1,
                     String testEmail,
                     String testgroup) {
    this.id = 0;
    this.testName = testName;
    this.testMiddleName = testMiddleName;
    this.testLastName = testLastName;
    this.testAddress = testAddress;
    this.testMobile = testMobile1;
    this.testEmail = testEmail;
    this.testgroup = testgroup;
  }


  public void setId(int id) {
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
    return testgroup;
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
