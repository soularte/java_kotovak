package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String testName;
  private String testMiddleName;
  private String testLastName;
  private String testAddress;
  private String testHome;
  private String testMobile;
  private String testWork;
  private String testEmail;
  private String testEmail1;
  private String testEmail2;
  private String testGroup;
  private String allPhones;
  private String allAddresses;
  private String allEmails;
  private File photo;

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

  public String getTestHome() {
    return testHome;
  }

  public String getTestMobile() {
    return testMobile;
  }

  public String getTestWork() {
    return testWork;
  }

  public String getTestEmail() {
    return testEmail;
  }

  public String getTestEmail1() {
    return testEmail1;
  }

  public String getTestEmail2() {
    return testEmail2;
  }

  public String getTestGroup() {
    return testGroup;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllAddresses() {
    return allAddresses;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public File getPhoto() {
    return photo;
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

  public ContactData withTestHome(String testHome) {
    this.testHome = testHome;
    return this;
  }

  public ContactData withTestMobile(String testMobile) {
    this.testMobile = testMobile;
    return this;
  }

  public ContactData withTestWork(String testWork) {
    this.testWork = testWork;
    return this;
  }

  public ContactData withTestEmail(String testEmail) {
    this.testEmail = testEmail;
    return this;
  }

  public ContactData withTestEmail1(String testEmail1) {
    this.testEmail1 = testEmail1;
    return this;
  }

  public ContactData withTestEmail2(String testEmail2) {
    this.testEmail2 = testEmail2;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllAddresses(String allAddresses) {
    this.allAddresses = allAddresses;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withTestGroup(String testGroup) {
    this.testGroup = testGroup;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
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
