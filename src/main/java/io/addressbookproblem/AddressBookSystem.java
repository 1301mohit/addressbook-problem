package io.addressbookproblem;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookSystem {

	private List<AddressBook> listOfAddressBook = new ArrayList<AddressBook>();

	private Map<String, List<Person>> listOfPersonAccordingToCity = new HashMap<>();
	private Map<String, List<Person>> listOfPersonAccordingToState = new HashMap<>();

	public List<Person> getListOfPersonAccordingToCity(String city) {
		return this.listOfPersonAccordingToCity.get(city);
	}

	public void setListOfPersonAccordingToCity(Person contact) {
		if(this.listOfPersonAccordingToCity.get(contact.getCity()) == null) {
			List<Person> listOfPerson = new ArrayList<>();
			listOfPerson.add(contact);
			this.listOfPersonAccordingToCity.put(contact.getCity(), listOfPerson);
		}
		else
			this.listOfPersonAccordingToCity.get(contact.getCity()).add(contact);
	}

	public List<Person> getListOfPersonAccordingToState(String state) {
		return this.listOfPersonAccordingToState.get(state);
	}

	public void setListOfPersonAccordingToState(Person contact) {
		if(this.listOfPersonAccordingToState.get(contact.getState()) == null) {
			List<Person> listOfPerson = new ArrayList<>();
			listOfPerson.add(contact);
			this.listOfPersonAccordingToState.put(contact.getState(), listOfPerson);
		}
		else
			this.listOfPersonAccordingToState.get(contact.getState()).add(contact);
	}

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

	public Optional<AddressBook> searchAddressBook(String addressBookName) {
		return listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
	}

	public String addContact(Person contact, String addressBookName) {
		Optional<AddressBook> optionalAddressBook = searchAddressBook(addressBookName);
		if(optionalAddressBook.isEmpty()) return "Addressbook Not Found";
		List<Person> listOfPerson = optionalAddressBook.get().addContact(contact);
		if(listOfPerson == null) return "Already Exist";
		this.setListOfPersonAccordingToCity(contact);
		this.setListOfPersonAccordingToState(contact);
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

	public void printCountByCity() {
		System.out.println("Print city and its count");
		this.listOfPersonAccordingToCity.keySet().stream().forEach(city -> System.out.println(city+" -> "+this.listOfPersonAccordingToCity.get(city).size()));
	}

	public void printCountByState() {
		System.out.println("Print state and its count");
		this.listOfPersonAccordingToState.keySet().stream().forEach(state -> System.out.println(state+" -> "+this.listOfPersonAccordingToState.get(state).size()));
	}

}
