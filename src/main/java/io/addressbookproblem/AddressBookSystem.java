package io.addressbookproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookSystem {

	AddressBook addressBook;
	private List<AddressBook> listOfAddressBook = new ArrayList<AddressBook>();

	public List<AddressBook> getListOfAddressBook() {
		return listOfAddressBook;
	}

	public void setListOfAddressBook(List<AddressBook> listOfAddressBook) {
		this.listOfAddressBook = listOfAddressBook;
	}

	@Override
	public String toString() {
		return "AddressBookSystem{" +
				"addressBook=" + addressBook +
				", listOfAddressBook=" + listOfAddressBook +
				'}';
	}

	public String createAddressBook(String addressBookName) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBookName.equals(addressBook1.getAddressBookName())).findAny();
		if(!optionalAddressBook.isEmpty())
			return "Already Exist";
		addressBook = new AddressBook();
		this.addressBook.setAddressBookName(addressBookName);
		this.listOfAddressBook.add(addressBook);
		return "AddressBook Created";
	}
	
	public boolean openAddressBook(String addressBookName) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
		if (optionalAddressBook.isEmpty())
			return false;
		return true;
	}


	public void getListOfPerson(String city) {
		List<List<Person>> collect = this.listOfAddressBook.stream()
									 .map(addressBook -> addressBook.getListOfContacts().stream()
											 		     .filter(person -> person.getCity().equals(city))
											 			 .collect(Collectors.toList()))
									 .collect(Collectors.toList());
		System.out.println(collect);
	}

	public Optional<AddressBook> searchAddressBook(String addressBookName) {
		return listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
	}

	public String addContact(Person contact, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = addressBook.addContact(contact);
		if(listOfPerson == null) return "Already Exist";
		optionalAddressBook.get().setListOfContacts(listOfPerson);
		return "Added Successfully";
	}

	public String editContact(String phoneNumber, Person editContact, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = addressBook.editContact(phoneNumber, editContact);
		if(listOfPerson == null) return "Person not found";
		optionalAddressBook.get().setListOfContacts(listOfPerson);
		return "Edited Successfully";
	}

	public String deleteContact(String phoneNumber, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = addressBook.deleteContact(phoneNumber);
		if(listOfPerson == null) return "Person not found";
		optionalAddressBook.get().setListOfContacts(listOfPerson);
		return "Deleted Successfully";
	}

}
