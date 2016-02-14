package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstName;
	private String lastName;
	private String adress;
	private String telephoneHome;
	private String telephoneMobile;
	private String telephoneWork;
	private String email;
	private String email2;
	private String birthdayDay;
	private String birthdayMonth;
	private String birthdayYear;
	private String group;
	private String secondaryAdress;
	private String secondaryTelephoneHome;

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

	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAdress(String adress) {
		this.adress = adress;
		return this;
	}

	public ContactData withTelephoneHome(String telephoneHome) {
		this.telephoneHome = telephoneHome;
		return this;
	}

	public ContactData withTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
		return this;
	}

	public ContactData withTelephoneWork(String telephoneWork) {
		this.telephoneWork = telephoneWork;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
		return this;
	}

	public ContactData withBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
		return this;
	}

	public ContactData withBirthdayYear(String birthdayYear) {
		this.birthdayYear = birthdayYear;
		return this;
	}

	public ContactData withSecondaryAdress(String secondaryAdress) {
		this.secondaryAdress = secondaryAdress;
		return this;
	}

	public ContactData withSecondaryTelephoneHome(String secondaryTelephoneHome) {
		this.secondaryTelephoneHome = secondaryTelephoneHome;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public String getTelephoneHome() {
		return telephoneHome;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public String getTelephoneWork() {
		return telephoneWork;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBirthdayDay() {
		return birthdayDay;
	}

	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	public String getBirthdayYear() {
		return birthdayYear;
	}

	public String getGroup() {
		return group;
	}

	public String getSecondaryAdress() {
		return secondaryAdress;
	}

	public String getSecondaryTelephoneHome() {
		return secondaryTelephoneHome;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTelephoneHome(String telephoneHome) {
		this.telephoneHome = telephoneHome;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}