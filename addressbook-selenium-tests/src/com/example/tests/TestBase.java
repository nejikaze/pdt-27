package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContact;

public class TestBase {

	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wraperGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}

	public static List<Object[]> wraperGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups){
    		list.add(new Object[]{group});
    	}
		return list;
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wraperContactForDataProvider(generateRandomContact(5)).iterator();
	}
	
	public static List<Object[]> wraperContactForDataProvider(List<ContactData> contacts) {
    	List<Object[]> list = new ArrayList<Object[]>();
    	for (ContactData contact : contacts){
    		list.add(new Object[]{contact});
    	}
    	return list;
	}

	public void checkNullTelephoneAndEmail(ContactData contact) {
		if (contact.getTelephoneHome().isEmpty()) {
			if (contact.getTelephoneMobile().isEmpty()) {
				contact.setTelephoneHome(contact.getTelephoneWork());
			} else {
				contact.setTelephoneHome(contact.getTelephoneMobile());
			}
		}
		if (contact.getEmail().isEmpty()) {
			contact.setEmail(contact.getEmail2());
		}
	}

}
