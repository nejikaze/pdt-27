package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name = "New Name";
		app.getGroupHelper().fillGroupForms(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}
}
