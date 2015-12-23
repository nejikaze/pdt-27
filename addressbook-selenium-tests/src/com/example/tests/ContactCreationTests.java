package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "First Name";
	contact.lastName = "Last Name";
	contact.adress = "Adress";
	contact.telephoneHome = "Telephone Home";
	contact.telephoneMobile = "Telephone Mobile";
	contact.telephoneWork = "Telephone Work";
	contact.email = "Email";
	contact.email2 = "Email2";
	contact.birthdayDay = "1";
	contact.birthdayMonth = "January";
	contact.birthdayYear = "2000";
	contact.group = "Name";
	contact.secondaryAdress = "Secondary Adress";
	contact.secondaryTelephoneHome = "Secondary Telephone Home";
    fillContactForms(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
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
    fillContactForms(contact);
    submitContactCreation();
    returnToHomePage();
  }

}
