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

	public void setListOfContacts(List<Person> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}

	@Override
	public String toString() {
		return "AddressBook{" +
				"addressBookName='" + addressBookName + '\'' +
				", listOfContacts=" + listOfContacts +
				'}';
	}

	public List<Person> addContact(Person contact) {
		Optional<Person> optionalPerson = searchPerson(contact.getPhoneNumber());
		if(optionalPerson.isPresent()) return null;
		this.getListOfContacts().add(contact);
		return listOfContacts;
	}
	
	public Optional<Person> searchPerson(String phoneNumber) {
		return listOfContacts.stream().filter(e -> e.getPhoneNumber().equals(phoneNumber)).findAny();
	}
	
	public List<Person> editContact(String phoneNumber, Person contact) {
		Optional<Person> optionalContact = searchPerson(phoneNumber);
		if(optionalContact.isEmpty()) return null;
		listOfContacts.remove(optionalContact.get());
		listOfContacts.add(contact);
		return listOfContacts;
	}

	public List<Person> deleteContact(String phoneNumber) {
		Optional<Person> optionalContact = searchPerson(phoneNumber);
		if(optionalContact.isEmpty()) return null;
		listOfContacts.remove(optionalContact.get());
		return listOfContacts;
	}
	
}
