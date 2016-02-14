package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends BaseHelper {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

  //  public static boolean CREATION = true;
  //  public static boolean MODIFICATION = false;
	
	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			ContactData contacts = new ContactData()
					.withLastName(row.findElement(By.xpath(".//td[2]")).getText())
					.withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
					.withEmail(row.findElement(By.xpath(".//td[4]")).getText())
					.withTelephoneHome(row.findElement(By.xpath(".//td[5]")).getText());
			
			if (contacts.getLastName() == null) {
				contacts.setLastName("");
			}
			if (contacts.getFirstName() == null) {
				contacts.setFirstName("");
			}
			if (contacts.getEmail() == null) {
				contacts.setEmail("");
			}
			if (contacts.getTelephoneHome() == null) {
				contacts.setTelephoneHome("");
			}
			
			cachedContacts.add(contacts); 
 		}		
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForms(contact /*, CREATION */);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		manager.navigateTo().mainPage();
		initContactModificationByIndex(index);
		fillContactForms(contact /*, MODIFICATION */);
		submitUpdateContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	public ContactHelper deleteContact(int index) {
		manager.navigateTo().mainPage();
		initContactModificationByIndex(index);
		submitDeleteContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}

	//------------------------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForms(ContactData contact /*, boolean formType */) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAdress());
		type(By.name("home"), contact.getTelephoneHome());
		type(By.name("mobile"), contact.getTelephoneMobile());
		type(By.name("work"), contact.getTelephoneWork());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBirthdayDay());
		selectByText(By.name("bmonth"), contact.getBirthdayMonth());
		type(By.name("byear"), contact.getBirthdayYear());
	/*	
        if (formType == CREATION) {
            //selectByText(By.name("new_group"), contact.getGroup());
        }else{
            if(driver.findElements(By.name("new_group")).size()!=0){
                throw new Error("Group selector exists in contact modification form");
            }
        }
     */   
		type(By.name("address2"), contact.getSecondaryAdress());
		type(By.name("phone2"), contact.getSecondaryTelephoneHome());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper submitDeleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactModificationByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public ContactHelper submitUpdateContact() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
			
	public List<WebElement> getContactRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		return rows;
	}

}
