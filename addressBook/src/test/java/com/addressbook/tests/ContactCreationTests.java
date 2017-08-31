package com.addressbook.tests;

import com.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreate() throws Exception {
    app.getNavigationHelper().gotoHome();
   // int before = app.getContactHelper().getContactCount();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData(
            "bbb", "aaa", "Minsk",
            "info@epam.com", "+37529 111-22-33", "test1"), true);
    app.submit();
    app.getGroupHelper().returnToHomePage();
   // int after = app.getContactHelper().getContactCount();
    List<ContactData> after = app.getContactHelper().getContactList();
    System.out.println("Before: " + before.size() + " After: " + after.size());
    Assert.assertEquals(before.size() + 1, after.size());
  }


}
