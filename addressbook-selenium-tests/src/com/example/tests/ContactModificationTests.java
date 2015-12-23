package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
		
	@Test
	public void modifyContactByIndex() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationByIndex(1);
		ContactData contact = new ContactData();
		contact.firstName = "New First Name";
		contact.lastName = "New Last Name";
	    app.getContactHelper().fillContactForms(contact);
		app.getContactHelper().submitUpdateContact();			   
		app.getContactHelper().returnToHomePage();	
	}
	
}