package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

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
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 3; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 3; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAdress(generateRandomString())
					.withTelephoneHome(generateRandomString())
					.withTelephoneMobile(generateRandomString())
					.withTelephoneWork(generateRandomString())
					.withEmail(generateRandomString())
					.withEmail2(generateRandomString())
					.withBirthdayDay(generateRandomBirthdayDay())
					.withBirthdayMonth(generateRandomBirthdayMonth())
					.withBirthdayYear(generateRandomBirthdayYear())
					// contact.group = "[none]";
					.withSecondaryAdress(generateRandomString())
					.withSecondaryTelephoneHome(generateRandomString());

			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {

		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public String generateRandomBirthdayDay() {

		Random rndBirthdayDay = new Random();
		if (rndBirthdayDay.nextInt(4) == 0) {
			return "-";
		} else {
			return String.valueOf(rndBirthdayDay.nextInt(31) + 1);
		}
	}

	public String generateRandomBirthdayMonth() {

		Random rndBirthdayMonth = new Random();
		String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		if (rndBirthdayMonth.nextInt(4) == 0) {
			return "-";
		} else {
			return String.valueOf(month[rndBirthdayMonth.nextInt(month.length)]);
		}
	}

	public String generateRandomBirthdayYear() {

		Random rndBirthdayYear = new Random();
		if (rndBirthdayYear.nextInt(4) == 0) {
			return "";
		} else {
			return String.valueOf(rndBirthdayYear.nextInt(2016));
		}
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
