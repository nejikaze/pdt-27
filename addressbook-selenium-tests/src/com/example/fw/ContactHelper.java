package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
	}

	public void submitUpdateContact() {
		click(By.xpath("//input[@value='Update']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		int numberOfLines = findElements(By.xpath("//tbody/tr")).size();
		int columnNumber = 2;
		for (int lineNumber = 2; lineNumber < numberOfLines; lineNumber++) {
			WebElement lastNameColumn = findElement(By.xpath("//table/tbody/tr[" + lineNumber + "]/td[" + columnNumber + "]"));
			WebElement firstNameColumn = findElement(By.xpath("//table/tbody/tr[" + lineNumber + "]/td[" + (columnNumber + 1) + "]"));
			WebElement emailColumn = findElement(By.xpath("//table/tbody/tr[" + lineNumber + "]/td[" + (columnNumber + 2) + "]"));
			WebElement telephoneHomeColumn = findElement(By.xpath("//table/tbody/tr[" + lineNumber + "]/td[" + (columnNumber + 3) + "]"));
			ContactData contact = new ContactData();
			contact.lastName = lastNameColumn.getText();
			contact.firstName = firstNameColumn.getText();
			contact.email = emailColumn.getText();
			contact.telephoneHome = telephoneHomeColumn.getText();

			if (contact.lastName == null)
				contact.lastName = "";
			if (contact.firstName == null)
				contact.firstName = "";
			if (contact.email == null)
				contact.email = "";
			if (contact.telephoneHome == null)
				contact.telephoneHome = "";

			contacts.add(contact);
		}
		return contacts;
	}

}
