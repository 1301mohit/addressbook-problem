package io.addressbookproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBookSystem {

	private List<AddressBook> listOfAddressBook = new ArrayList<AddressBook>();

	public List<AddressBook> getListOfAddressBook() {
		return listOfAddressBook;
	}

	public void setListOfAddressBook(List<AddressBook> listOfAddressBook) {
		this.listOfAddressBook = listOfAddressBook;
	}

	public String createAddressBook(AddressBook addressBook) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBook.getAddressBookName().equals(addressBook1.getAddressBookName())).findAny();
		if(!optionalAddressBook.isEmpty())
			return "Already Exist";
		this.listOfAddressBook.add(addressBook);
		return "AddressBook Created";
	}
	
	public boolean openAddressBook(String addressBookName) {
		Optional<AddressBook> optionalAddressBook = this.listOfAddressBook.stream().filter(addressBook1 -> addressBook1.getAddressBookName().equals(addressBookName)).findAny();
		if(optionalAddressBook.isEmpty())
			return false;
		listOfAddressBook.add(new AddressBook(addressBookName));
		return true;
	}
}
