package io.addressbookproblem;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		String response;
		boolean flagForAddressBookSystem = true;
		boolean flagForAddressBook = true;
		AddressBook addressBook;
		System.out.println("Welcome to Address Book Program");
		Scanner scanner = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();
		while (flagForAddressBookSystem) {
			System.out.println("List of address book");
			addressBookSystem.getListOfAddressBook().stream().forEach(System.out::println);
			System.out.println("1.Create new addressbook");
			System.out.println("2.Open addressbook");
			System.out.println("3.Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter name of addressbook");
				String addressBookName = scanner.next();
				addressBook = new AddressBook();
				addressBook.setAddressBookName(addressBookName);
				response = addressBookSystem.createAddressBook(addressBook);
				System.out.println(response);
				break;
			case 2:
				System.out.println("Enter name of addressbook");
				addressBook = new AddressBook();
				addressBookName = scanner.next();
				boolean checkAddressBook = addressBookSystem.openAddressBook(addressBookName);
				if (!checkAddressBook)
					System.out.println("Not Found");
				while (flagForAddressBook && checkAddressBook) {
					System.out.println("1.Add Contact");
					System.out.println("2.Edit Contact");
					System.out.println("3.Delete");
					System.out.println("4.Exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1:
						Contact contact = new Contact();
						System.out.print("Enter first name : ");
						contact.setFirstName(scanner.next());
						System.out.print("Enter last name : ");
						contact.setLastName(scanner.next());
						System.out.print("Enter address : ");
						contact.setAddress(scanner.next());
						System.out.print("Enter city : ");
						contact.setCity(scanner.next());
						System.out.print("Enter state : ");
						contact.setState(scanner.next());
						System.out.print("Enter zip : ");
						contact.setZip(scanner.next());
						System.out.print("Enter phone number : ");
						contact.setPhoneNumber(scanner.next());
						System.out.print("Enter email : ");
						contact.setEmail(scanner.next());
						response = addressBook.addContact(contact);
						System.out.println(response);
						break;
					case 2:
						Contact editContact = new Contact("Amit", "Kumar", "Mumbai", "Mumbai", "Maharastra", "123456",
								"9999999999", "mohit@gmail.com");
						System.out.println("Enter phone number : ");
						String phoneNumber = scanner.next();
						response = addressBook.editContact(phoneNumber, editContact);
						System.out.println(response);
						break;
					case 3:
						System.out.println("Enter phone number : ");
						phoneNumber = scanner.next();
						response = addressBook.deleteContact(phoneNumber);
						System.out.println(response);
						break;
					case 4:
						flagForAddressBook = false;
						break;
					default:
						System.out.println("Please enter valid option");
					}
					if (choice != 4)
						System.out.println(addressBook.getListOfContacts());
				}
				break;
			case 3:
				flagForAddressBookSystem = false;
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Please enter valid option");
			}

		}
		scanner.close();
	}
}
