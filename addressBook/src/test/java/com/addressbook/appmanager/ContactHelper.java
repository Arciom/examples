package com.addressbook.appmanager;

import com.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

        if(creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else {
            Assert.assertFalse(isElemntPresent(By.name("new_group")));
        }
//        if(isElemntPresent(By.name("new_group"))) {
//            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//        }
    }

    public void initContactCreation() {
        click(By.linkText("ADD_NEW"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='DELETE']"));
        driver.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt=\"EDIT\"]"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return isElemntPresent(By.name("selected[]"));
    }

    public void submit() {
        driver.findElement(By.name("submit")).click();
    }

    public void returnToHomePage() {      click(By.linkText("home page"));    }

    public void createContact(ContactData contactData, boolean b) {
        initContactCreation();
        fillContactForm(contactData, true);
        submit();
        returnToHomePage();
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }

    public List<WebElement> printGetContactList() {
        List<WebElement> elements = new ArrayList<>();
        elements = driver.findElements(By.name("entry"));
        return elements;
    }
}
