package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.tests.ContactDataGenerator.loadContactFromXmlFile;

public class ContactCreationTests extends TestBase {

	@DataProvider
	public Iterator <Object[]> contactsFromFile() throws IOException {
		return wraperContactForDataProvider(loadContactFromXmlFile(new File("contacts.xml"))).iterator();
	}

	@Test(dataProvider = "contactsFromFile")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {

		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contact);

		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		checkNullTelephoneAndEmail(contact);

		assertThat(newList, equalTo(oldList.withAdded(contact)));

	}

}
