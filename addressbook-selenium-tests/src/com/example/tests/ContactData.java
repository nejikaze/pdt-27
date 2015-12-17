package com.example.tests;

public class ContactData {
	public String contactFirstName;
	public String contactLastName;
	public String contactAdress;
	public String contactTelephoneHome;
	public String contactTelephoneMobile;
	public String contactTelephoneWork;
	public String contactEmail;
	public String contactEmail2;
	public String contactBirthdayDay;
	public String contactBirthdayMonth;
	public String contactBirthdayYear;
	public String contactGroup;
	public String contactSecondaryAdress;
	public String contactSecondaryTelephoneHome;

	public ContactData() {
		
	}
	
	public ContactData(String contactFirstName, String contactLastName, String contactAdress,
			String contactTelephoneHome, String contactTelephoneMobile, String contactTelephoneWork,
			String contactEmail, String contactEmail2, String contactBirthdayDay, String contactBirthdayMonth,
			String contactBirthdayYear, String contactGroup, String contactSecondaryAdress,
			String contactSecondaryTelephoneHome) {
		this.contactFirstName = contactFirstName;
		this.contactLastName = contactLastName;
		this.contactAdress = contactAdress;
		this.contactTelephoneHome = contactTelephoneHome;
		this.contactTelephoneMobile = contactTelephoneMobile;
		this.contactTelephoneWork = contactTelephoneWork;
		this.contactEmail = contactEmail;
		this.contactEmail2 = contactEmail2;
		this.contactBirthdayDay = contactBirthdayDay;
		this.contactBirthdayMonth = contactBirthdayMonth;
		this.contactBirthdayYear = contactBirthdayYear;
		this.contactGroup = contactGroup;
		this.contactSecondaryAdress = contactSecondaryAdress;
		this.contactSecondaryTelephoneHome = contactSecondaryTelephoneHome;
	}
}