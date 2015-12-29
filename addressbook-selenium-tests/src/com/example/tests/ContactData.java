package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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

	public ContactData(String firstName, String lastName, String adress, String telephoneHome, String telephoneMobile,
			String telephoneWork, String email, String email2, String birthdayDay, String birthdayMonth,
			String birthdayYear, String group, String secondaryAdress, String secondaryTelephoneHome) {
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

	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName + ", telephoneHome=" + telephoneHome
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		int result = 1;
		// result = prime * result + ((email == null) ? 0 : email.hashCode());
		// result = prime * result + ((firstName == null) ? 0 :
		// firstName.hashCode());
		// result = prime * result + ((lastName == null) ? 0 :
		// lastName.hashCode());
		// result = prime * result + ((telephoneHome == null) ? 0 :
		// telephoneHome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (telephoneHome == null) {
			if (other.telephoneHome != null)
				return false;
		} else if (!telephoneHome.equals(other.telephoneHome))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		String contactData = firstName.toLowerCase() + firstName.length() + lastName.toLowerCase() + lastName.length() + email.toLowerCase() + email.length() + telephoneHome.toLowerCase() + telephoneHome.length();
		String contactDataOther = other.firstName.toLowerCase() + other.firstName.length() + other.lastName.toLowerCase() + other.lastName.length() + other.email.toLowerCase() + other.email.length() + other.telephoneHome.toLowerCase() + other.telephoneHome.length();
		return contactData.compareTo(contactDataOther);
	}
}