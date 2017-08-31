package com.addressbook.tests;

import com.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getNavigationHelper().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "bbb", "aaa", "Minsk",
                    "info@epam.com", "+37529 111-22-33", "test1"), true);
        }
     //   int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "222", "111", "Gomel",
                "info@epam.com", "+37529 111-22-33", null), false);
        app.getContactHelper().submitContactModification();
        app.getGroupHelper().returnToHomePage();
      //  int after = app.getContactHelper().getContactCount();
        List<ContactData> after = app.getContactHelper().getContactList();
        System.out.println("Before: " + before.size() + " After: " + after.size());
        Assert.assertEquals(before.size(), after.size());

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
