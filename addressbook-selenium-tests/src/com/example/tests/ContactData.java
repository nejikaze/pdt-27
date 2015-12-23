package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String adress;
	public String telephoneHome;
	public String telephoneMobile;
	public String telephoneWork;
	public String email;
	public String email2;
	public String birthdayDay;
	public String birthdayMonth;
	public String birthdayYear;
	public String group;
	public String secondaryAdress;
	public String secondaryTelephoneHome;

	public ContactData() {
		
	}
	
	public ContactData(String firstName, String lastName, String adress,
			String telephoneHome, String telephoneMobile, String telephoneWork,
			String email, String email2, String birthdayDay, String birthdayMonth,
			String birthdayYear, String group, String secondaryAdress,
			String secondaryTelephoneHome) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.telephoneHome = telephoneHome;
		this.telephoneMobile = telephoneMobile;
		this.telephoneWork = telephoneWork;
		this.email = email;
		this.email2 = email2;
		this.birthdayDay = birthdayDay;
		this.birthdayMonth = birthdayMonth;
		this.birthdayYear = birthdayYear;
		this.group = group;
		this.secondaryAdress = secondaryAdress;
		this.secondaryTelephoneHome = secondaryTelephoneHome;
	}
}