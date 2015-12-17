package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
		goToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.groupName = "Name";
		group.groupHeader = "Header";
		group.groupFooter = "Footer";
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
		group.groupName = "";
		group.groupHeader = "";
		group.groupFooter = "";
		fillGroupForms(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
}
