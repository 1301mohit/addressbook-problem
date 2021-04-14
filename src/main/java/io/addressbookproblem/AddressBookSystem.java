package io.addressbookproblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookSystem {

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
				", listOfAddressBook=" + listOfAddressBook +
				'}';
	}

	public String createAddressBook(String addressBookName) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBookName.equals(addressBook1.getAddressBookName())).findAny();
		if(!optionalAddressBook.isEmpty())
			return "Already Exist";
		AddressBook addressBook = new AddressBook();
		addressBook.setAddressBookName(addressBookName);
		this.listOfAddressBook.add(addressBook);
		return "AddressBook Created";
	}
	
	public boolean openAddressBook(String addressBookName) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
		if (optionalAddressBook.isEmpty())
			return false;
		return true;
	}


	public void getListOfPerson(String cityOrState) {
		List<Person> listOfPerson = new ArrayList<>();
		this.listOfAddressBook.stream()
				.map(addressBook -> addressBook.getListOfContacts().stream()
						.filter(person -> {
							if (person.getCity().equals(cityOrState))
								listOfPerson.add(person);
							return true;
						}));
		listOfPerson.stream().forEach(System.out::println);
	}

	public Optional<AddressBook> searchAddressBook(String addressBookName) {
		return listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
	}

	public String addContact(Person contact, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = optionalAddressBook.get().addContact(contact);
		if(listOfPerson == null) return "Already Exist";
		return "Added Successfully";
	}

	public String editContact(String phoneNumber, Person editContact, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = optionalAddressBook.get().editContact(phoneNumber, editContact);
		if(listOfPerson == null) return "Person not found";
		return "Edited Successfully";
	}

	public String deleteContact(String phoneNumber, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = optionalAddressBook.get().deleteContact(phoneNumber);
		if(listOfPerson == null) return "Person not found";
		optionalAddressBook.get().setListOfContacts(listOfPerson);
		return "Deleted Successfully";
	}

}
