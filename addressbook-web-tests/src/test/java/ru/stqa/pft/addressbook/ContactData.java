package ru.stqa.pft.addressbook;

public class ContactData {
  private final String testName;
  private final String testMiddleName;
  private final String testLastName;
  private final String testAddress;
  private final String testMobile;
  private final String testEmail;

  public ContactData(String testName, String testMiddleName, String testLastName, String testAddress, String testMobile1, String testEmail) {
    this.testName = testName;
    this.testMiddleName = testMiddleName;
    this.testLastName = testLastName;
    this.testAddress = testAddress;
    this.testMobile = testMobile1;
    this.testEmail = testEmail;
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
}
