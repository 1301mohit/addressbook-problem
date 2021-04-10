package io.addressbookproblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
	
	private String addressBookName;
	private List<Person> listOfContacts;
	
	public AddressBook() {
		listOfContacts = new LinkedList<Person>();
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

	public List<Person> getListOfContacts() {
		return listOfContacts;
	}
	
	@Override
	public String toString() {
		return "AddressBook [addressBookName=" + addressBookName + "]";
	}

	public String addContact(Person contact) {
		Optional<Person> optionalPerson = searchPerson(contact.getPhoneNumber());
		if(optionalPerson.isPresent()) return "Already exist";
		listOfContacts.add(contact);
		return "Added Successfully";
	}
	
	public Optional<Person> searchPerson(String phoneNumber) {
		return listOfContacts.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).findAny();
	}
	
	public String editContact(String phoneNumber, Person contact) {
		Optional<Person> optionalContact = searchPerson(phoneNumber);
		if(optionalContact.isEmpty()) return "NOT FOUND";
		listOfContacts.remove(optionalContact.get());
		listOfContacts.add(contact);
		return "Edited Successfully";
	}

	public String deleteContact(String phoneNumber) {
		Optional<Person> optionalContact = searchPerson(phoneNumber);
		if(optionalContact.isEmpty()) return "NOT FOUND";
		listOfContacts.remove(optionalContact.get());
		return "Deleted Successfully";
	}
	
}
