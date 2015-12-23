package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.name = "Name";
		group.header = "Header";
		group.footer = "Footer";
		app.getGroupHelper().fillGroupForms(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupCreation();
		GroupData group = new GroupData();
		group.name = "";
		group.header = "";
		group.footer = "";
		app.getGroupHelper().fillGroupForms(group);
		app.getGroupHelper().submitGroupCreation();
		app.getGroupHelper().returnToGroupsPage();
	}
}
