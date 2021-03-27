package io.addressbookproblem;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	
	private List<Contact> listOfContacts = new ArrayList<Contact>();

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}

	public String createContact(Contact contact) {
		listOfContacts.add(contact);
		return "CREATED";
	}
	
}
