package com.addressbook.tests;

import com.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupsCreationTests extends TestBase{

  @Test
  public void testGroupsCreate() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
 //   int before = app.getGroupHelper().getGroupCount();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
  //  int after = app.getGroupHelper().getGroupCount();
    System.out.println("before: " + before + " after: " + after);
    Assert.assertEquals(before.size() + 1, after.size());

    before.add(group);
    int max = 0;
    for(GroupData g : after) {
      if(max < g.getId()) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
