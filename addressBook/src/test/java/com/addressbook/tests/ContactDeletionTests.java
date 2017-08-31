package com.addressbook.tests;

import com.addressbook.model.ContactData;
import com.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase  {

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().gotoHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "bbb", "aaa", "Minsk",
                    "info@epam.com", "+37529 111-22-33", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        //int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        List<ContactData> after = app.getContactHelper().getContactList();
        System.out.println("Before: " + before.size() + " After: " + after.size());
        app.getContactHelper().printGetContactList();
       // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before.size(), after.size() + 1);

       before.remove(before.size() - 1);
       Assert.assertEquals(before, after);

    }
}
