package com.example.tests;

import java.util.List;
import java.util.Collections;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.firstName = "First Name";
		contact.lastName = "Last Name";
		contact.adress = "Adress";
		contact.telephoneHome = "TelephoneHome";
		contact.telephoneMobile = "TelephoneMobile";
		contact.telephoneWork = "TelephoneWork";
		contact.email = "Email";
		contact.email2 = "Email2";
		contact.birthdayDay = "1";
		contact.birthdayMonth = "January";
		contact.birthdayYear = "2000";
		contact.group = "[none]";
		contact.secondaryAdress = "Secondary Adress";
		contact.secondaryTelephoneHome = "Secondary Telephone Home";
		app.getContactHelper().fillContactForms(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		// compare states
	    oldList.add(contact);    
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList); 	
		
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initContactCreation();
		ContactData contact = new ContactData();
		contact.firstName = "";
		contact.lastName = "";
		contact.adress = "";
		contact.telephoneHome = "";
		contact.telephoneMobile = "";
		contact.telephoneWork = "";
		contact.email = "";
		contact.email2 = "";
		contact.birthdayDay = "-";
		contact.birthdayMonth = "-";
		contact.birthdayYear = "";
		contact.group = "[none]";
		contact.secondaryAdress = "";
		contact.secondaryTelephoneHome = "";
		app.getContactHelper().fillContactForms(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		// compare states	  
	    oldList.add(contact);    
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList); 	

	}

}
