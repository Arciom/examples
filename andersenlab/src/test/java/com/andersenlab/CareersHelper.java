package com.andersenlab;

import com.andersenlab.model.CVData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CareersHelper extends HelperBase{

    public CareersHelper(WebDriver driver) {
        super(driver);
    }

    protected void fillSendCVForm(CVData cvData) {
        type(By.name("name"), cvData.getName());
        type(By.name("email"), cvData.getEmail());
        dropdownList(By.name("city"), cvData.getPlace());
        attach(By.xpath(".//*[@id='job-form-dropzone']/div/div[4]/div/div"), cvData.getCv());
//        type(By.xpath(".//*[@id='job-form-dropzone']/div/div[5]/div/div"), cvData.getCv().getAbsolutePath());
    }

    protected void fillDrop(CVData cvData) {
        attachDrop(By.xpath(".//*[@id='job-form-dropzone']/div/div[5]/div/div"), cvData.getCv());
      //  type(By.xpath(".//*[@id='job-form-dropzone']/div/div[5]/div/div"), cvData.getCv().getAbsolutePath());
    }
    protected void attachDrop (By locator, File file) {
         //click(locator);
        //     driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    protected void fillSendCVFormWithoutCV(CVData cvData) {
        type(By.name("name"), cvData.getName());
        type(By.name("email"), cvData.getEmail());
        dropdownList(By.name("city"), cvData.getPlace());
        //       attach(By.xpath(".//*[@id='job-form-dropzone']/div/div[5]/div/div"), cvData.getCv());
//        type(By.xpath(".//*[@id='job-form-dropzone']/div/div[5]/div/div"), cvData.getCv().getAbsolutePath());
    }

}
