package io.addressbookproblem;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	
	private List<Contact> listOfContacts;
	
	public AddressBook() {
		listOfContacts = new ArrayList<Contact>();
	}

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}
	
	public void addContact(Contact contact) {
		listOfContacts.add(contact);
	}
	
}
