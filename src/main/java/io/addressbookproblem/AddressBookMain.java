package io.addressbookproblem;

import java.util.Comparator;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        String response;
        boolean flagForAddressBookSystem = true;
        AddressBook addressBook;
        System.out.println("Welcome to Address Book Program");
        Scanner scanner = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        while (flagForAddressBookSystem) {
            boolean flagForAddressBook = true;
            System.out.println("List of address book");
            addressBookSystem.getListOfAddressBook().stream().forEach(System.out::println);
            System.out.println("1.Create new addressbook");
            System.out.println("2.Open addressbook");
            System.out.println("3.View person by city");
            System.out.println("4.View person by state");
            System.out.println("5.Count person by city");
            System.out.println("6.Count person by state");
            System.out.println("7.Exit");
            System.out.println("Enter your choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name of addressbook");
                    String addressBookName = scanner.next();
                    response = addressBookSystem.createAddressBook(addressBookName);
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("List of addressbook");
                    addressBookSystem.getListOfAddressBook().forEach(addressBook1 -> System.out.println(addressBook1.getAddressBookName()));
                    System.out.println("Enter name of addressbook");
                    addressBookName = scanner.next();
                    boolean checkAddressBook = addressBookSystem.openAddressBook(addressBookName);
                    if (!checkAddressBook)
                        System.out.println("Not Found");
                    while (flagForAddressBook && checkAddressBook) {
                        System.out.println("1.Add Contact");
                        System.out.println("2.Edit Contact");
                        System.out.println("3.Delete");
                        System.out.println("4.Sort by first name");
                        System.out.println("5.Sort by city");
                        System.out.println("6.Sort by state");
                        System.out.println("7.Sort by zip");
                        System.out.println("8.Exit");
                        System.out.print("Enter your choice : ");
                        int choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                Person contact = new Person();
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
                                response = addressBookSystem.addContact(contact, addressBookName);
                                System.out.println(response);
                                break;
                            case 2:
                                Person editContact = new Person("Amit", "Kumar", "Mumbai", "Mumbai", "Maharastra", "123456",
                                        "9999999999", "mohit@gmail.com");
                                System.out.println("Enter phone number : ");
                                String phoneNumber = scanner.next();
                                response = addressBookSystem.editContact(phoneNumber, editContact, addressBookName);
                                System.out.println(response);
                                break;
                            case 3:
                                System.out.println("Enter phone number : ");
                                phoneNumber = scanner.next();
                                response = addressBookSystem.deleteContact(phoneNumber, addressBookName);
                                System.out.println(response);
                                break;
                            case 4:
                                addressBookSystem.sortByPersonName(addressBookName);
                                break;
                            case 5:
                                addressBookSystem.sortByCity(addressBookName);
                                break;
                            case 6:
                                addressBookSystem.sortByState(addressBookName);
                                break;
                            case 7:
                                addressBookSystem.sortByZip(addressBookName);
                                break;
                            case 8:
                                flagForAddressBook = false;
                                break;
                            default:
                                System.out.println("Please enter valid option");
                        }
                        if (choice1 != 4)
                            System.out.println(addressBookSystem);
                    }
                    break;
                case 3:
                    System.out.println("Enter city name");
                    String city = scanner.next();
                    addressBookSystem.getListOfPersonAccordingToCity(city).stream().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter state name");
                    String state = scanner.next();
                    addressBookSystem.getListOfPersonAccordingToState(state).stream().forEach(System.out::println);
                    break;
                case 5:
                    addressBookSystem.printCountByCity();
                    break;
                case 6:
                    addressBookSystem.printCountByState();
                    break;
                case 7:
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
