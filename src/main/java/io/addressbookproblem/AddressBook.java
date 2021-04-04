package io.addressbookproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
	
	private String addressBookName;
	private List<Contact> listOfContacts;
	
	public AddressBook() {
		listOfContacts = new ArrayList<Contact>();
	}

	public AddressBook(String addressBookName) {
		super();
		this.addressBookName = addressBookName;
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public List<Contact> getListOfContacts() {
		return listOfContacts;
	}
	
	@Override
	public String toString() {
		return "AddressBook [addressBookName=" + addressBookName + "]";
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

	public String deleteContact(String phoneNumber) {
		Optional<Contact> optionalContact = listOfContacts.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).findAny();
		if( optionalContact.isEmpty()) return "NOT FOUND";
		listOfContacts.remove(optionalContact.get());
		return "Deleted Successfully";
	}
	
}
