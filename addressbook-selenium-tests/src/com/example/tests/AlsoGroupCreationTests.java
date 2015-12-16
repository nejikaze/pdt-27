package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {
	@Test
	public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
		goToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.groupName = "group name test";
		group.groupHeader = "group header test";
		group.groupFooter = "group footer test";
		fillGroupForms(group);
		submitGroupCreation();
		returnToGroupsPage();
	}

	@Test
	public void testEmptyGroupCreation() throws Exception {
		openMainPage();
		goToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData("", "", "");
		fillGroupForms(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
}
