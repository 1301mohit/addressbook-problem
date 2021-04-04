package io.addressbookproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
	
	private List<Contact> listOfContacts;
	
	public AddressBook() {
		listOfContacts = new ArrayList<Contact>();
	}

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}
	
	public String addContact(Contact contact) {
		listOfContacts.add(contact);
		return "Added Successfully";
	}
	
	public String editContact(String phoneNumber, Contact contact) {
		Optional<Contact> optionalContact = listOfContacts.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).findAny();
		if( optionalContact.isEmpty()) return "NOT FOUND";
		listOfContacts.remove(optionalContact.get());
		listOfContacts.add(contact);
		return "Edited Successfully";
	}
	
}
