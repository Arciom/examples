package com.gmail.swertrem;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Mail extends TestBase {

  @Test
  public void testMail() throws Exception {
    init();
    initCreationMail();
    driver.findElement(By.id(":ns")).clear();
    driver.findElement(By.id(":ns")).sendKeys("QA Automation");
    driver.findElement(By.id(":pg")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    driver.findElement(By.id(":ni")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame |  | ]]
    driver.findElement(By.cssSelector("#treeitem-41 > span.theme-twisty.expander")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=toolbox-panel-iframe-inspector | ]]
    driver.findElement(By.cssSelector("#treeitem-41 > span.theme-twisty.expander")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("#treeitem-41 > span.theme-twisty.expander")).click();
  }

  private void initCreationMail() {
    driver.findElement(By.xpath("//div[@id=':if']/div/div")).click();
  }

  private void init() {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("a.gb_b.gb_4b")).click();
    driver.findElement(By.cssSelector("span.gb_2")).click();
    driver.findElement(By.cssSelector("a.WaidBe")).click();
    driver.findElement(By.cssSelector("span > svg")).click();
    driver.findElement(By.cssSelector("p.uRhzae")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Gipopotam1");
    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
  }

}
