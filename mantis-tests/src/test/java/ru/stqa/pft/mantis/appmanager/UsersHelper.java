package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UsersHelper extends HelperBase {

  public UsersHelper(ApplicationManager app) {
    super(app);
  }

  public void manageUser(String userName) {
    type(By.name("username"), userName);
    click(By.cssSelector("input[value='Manage User']"));
  }

  public void startResetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }


}