package com.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
    public WebDriver driver;
    public boolean acceptNextAlert = true;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        click(locator);
        if(text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if(! existingText.equals(text)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    protected boolean isElemntPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException e) {
            return false;
        }
    }
}
