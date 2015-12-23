package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
		goToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "Name";
		group.header = "Header";
		group.footer = "Footer";
		fillGroupForms(group);
		submitGroupCreation();
		returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();
		goToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "";
		group.header = "";
		group.footer = "";
		fillGroupForms(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
}
