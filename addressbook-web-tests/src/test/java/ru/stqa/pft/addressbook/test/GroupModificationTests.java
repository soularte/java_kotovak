package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initializeGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Test1", "Test5", "Test6"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
