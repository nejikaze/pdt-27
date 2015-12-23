package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends BaseHelper {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForms(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.adress);
		type(By.name("home"), contact.telephoneHome);
		type(By.name("mobile"), contact.telephoneMobile);
		type(By.name("work"), contact.telephoneWork);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.birthdayDay);
		selectByText(By.name("bmonth"), contact.birthdayMonth);
		type(By.name("byear"), contact.birthdayYear);
		selectByText(By.name("new_group"), contact.group);
		type(By.name("address2"), contact.secondaryAdress);
		type(By.name("phone2"), contact.secondaryTelephoneHome);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void submitDeleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void initContactModificationByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + index + "]"));
	}
	
	public void submitUpdateContact() {	
		click(By.xpath("//input[@value='Update']"));
	}

}
