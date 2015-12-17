package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.contactFirstName = "First Name";
	contact.contactLastName = "Last Name";
	contact.contactAdress = "Adress";
	contact.contactTelephoneHome = "Telephone Home";
	contact.contactTelephoneMobile = "Telephone Mobile";
	contact.contactTelephoneWork = "Telephone Work";
	contact.contactEmail = "Email";
	contact.contactEmail2 = "Email2";
	contact.contactBirthdayDay = "1";
	contact.contactBirthdayMonth = "January";
	contact.contactBirthdayYear = "2000";
	contact.contactGroup = "Name";
	contact.contactSecondaryAdress = "Secondary Adress";
	contact.contactSecondaryTelephoneHome = "Secondary Telephone Home";
    fillContactForms(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.contactFirstName = "";
	contact.contactLastName = "";
	contact.contactAdress = "";
	contact.contactTelephoneHome = "";
	contact.contactTelephoneMobile = "";
	contact.contactTelephoneWork = "";
	contact.contactEmail = "";
	contact.contactEmail2 = "";
	contact.contactBirthdayDay = "-";
	contact.contactBirthdayMonth = "-";
	contact.contactBirthdayYear = "";
	contact.contactGroup = "[none]";
	contact.contactSecondaryAdress = "";
	contact.contactSecondaryTelephoneHome = "";
    fillContactForms(contact);
    submitContactCreation();
    returnToHomePage();
  }

}
