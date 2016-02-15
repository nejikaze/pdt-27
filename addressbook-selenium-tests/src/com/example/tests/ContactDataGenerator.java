package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters:<amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		if (file.exists()) {
			System.out.println("File exist, please remove it manualy:" + file);
		}

		List<ContactData> contacts = generateRandomContact(amount);
		if ("csv".equals(format)) {
			saveContactToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	private static void saveContactToXmlFile(List<ContactData> contact,File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contact);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();

	}
	
	public static List<ContactData> loadContactFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getTelephoneHome() + ","
					+ contact.getEmail() + ",!" + "\n");
		}
		writer.close();
	}

	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withTelephoneHome(part[2])
					.withEmail(part[3]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}
	
	public static List<ContactData> generateRandomContact(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
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
			list.add(contact);
		}
		return list;
	}

	public static String generateRandomString() {

		Random rnd = new Random();
		if (rnd.nextInt(4) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public static String generateRandomBirthdayDay() {

		Random rndBirthdayDay = new Random();
		if (rndBirthdayDay.nextInt(4) == 0) {
			return "-";
		} else {
			return String.valueOf(rndBirthdayDay.nextInt(31) + 1);
		}
	}

	public static String generateRandomBirthdayMonth() {

		Random rndBirthdayMonth = new Random();
		String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		if (rndBirthdayMonth.nextInt(4) == 0) {
			return "-";
		} else {
			return String.valueOf(month[rndBirthdayMonth.nextInt(month.length)]);
		}
	}

	public static String generateRandomBirthdayYear() {

		Random rndBirthdayYear = new Random();
		if (rndBirthdayYear.nextInt(4) == 0) {
			return "";
		} else {
			return String.valueOf(rndBirthdayYear.nextInt(2016));
		}
	}
}