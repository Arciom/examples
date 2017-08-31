package com.example.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.addressbook.tests.TestBase;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SandBox extends TestBase{


  @Test
  public void testSandBox() throws Exception {
    app.getNavigationHelper().gotoHome();
    app.getContactHelper().printGetContactList();
    List<WebElement> contacts = new ArrayList<>();
    contacts = app.getContactHelper().printGetContactList();
    for(WebElement e : contacts) {
      System.out.println(e + " : " + e);
    }

  }



  }

