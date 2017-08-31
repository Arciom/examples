package com.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoHome() {
        if(isElemntPresent(By.name("MainForm"))){
            return;
        }
        click(By.linkText("HOME"));
    }

//    public void gotoGroupPage() {
//        if(isElemntPresent(By.tagName("h1"))
//                && driver.findElement(By.tagName("h1")).getText().equals("GROUPS")
//                && isElemntPresent(By.name("new"))){
//            return;
//        }
//        click(By.linkText("GROUPS"));
//    }

    public void gotoGroupPage() {
        if(isElemntPresent(By.name("new"))){
            return;
        }
        click(By.linkText("GROUPS"));
    }
}
