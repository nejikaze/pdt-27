package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationByIndex(1);
		app.getContactHelper().submitDeleteContact();
		app.getContactHelper().returnToHomePage();
	}
}
