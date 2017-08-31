package com.andersenlab;

import com.andersenlab.model.CVData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CareersTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validCvDataXml() throws IOException {

   try (BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/CvData.xml")))){
     String xml = "";
     String line =  reader.readLine();
     while (line != null) {
       xml += line;
       line = reader.readLine();
     }
     XStream xstream = new XStream();
     xstream.processAnnotations(CVData.class);
     List<CVData> cvDataList = (List<CVData>) xstream.fromXML(xml);
     return cvDataList.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
   }
  }

  @DataProvider
  public Iterator<Object[]> validCvDataJson() throws IOException {
   try (BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/CvData.json")))) {
     String json = "";
     String line =  reader.readLine();
     while (line != null) {
       json += line;
       line = reader.readLine();
     }
     Gson gson = new Gson();
     List<CVData> cvDataList = gson.fromJson(json, new TypeToken<List<CVData>>(){}.getType()); //List<CvData>.class
     return cvDataList.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
   }
  }

  @DataProvider
  public Iterator<Object[]> validCvDataCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader( new FileReader(new File("src/test/resources/CvData.xml")))){
      String line =  reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[] {new CVData().withName(split[0]).withEmail(split[1]).withPlace(split[2]).withCv(new File(split[3]))});
        line = reader.readLine();
      }
     return list.iterator();
    }
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().careers();
  }

  @Test(dataProvider =  "validCvDataJson")
  public void testSendCV(CVData cvData) throws Exception {
    app.careers().fillSendCVForm(cvData);
  }

  @Test(enabled = false)
  public void testDrop() throws Exception {
    File cv = new File("src/test/resources/Resume.PDF");
    CVData cvData = new CVData().withCv(cv);
    app.careers().fillDrop(cvData);
  }

  @Test(enabled = false)
  public void testSendCVwithoutResume() throws Exception {

    CVData cvData = new CVData().withName("arciom").withEmail("swert.rem@gmail.com").withPlace("Minsk");
    app.careers().fillSendCVFormWithoutCV(cvData);
  }

//  public void testCurrentDir() {
//    File curentDir = new File(".");
//    String absolutePath = curentDir.getAbsolutePath();
//    System.out.println(absolutePath);
//    File cv = new File("src/test/resources/Resume.PDF");
//    System.out.println(cv.getAbsolutePath());
//    System.out.println(cv.exists());
//  }
}
