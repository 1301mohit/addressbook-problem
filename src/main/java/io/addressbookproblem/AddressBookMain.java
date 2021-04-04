package io.addressbookproblem;


public class AddressBookMain 
{
    public static void main( String[] args )
    {
    	String response;
        System.out.println( "Welcome to Address Book Program" );
        AddressBook addressBook = new AddressBook();
        Contact contact1 = new Contact("Mohit", "Kumar", "Mumbai", "Mumbai","Maharastra",
        							   "123456", "9999999999", "mohit@gmail.com");
        response = addressBook.addContact(contact1);
        System.out.println(response);
        System.out.println(addressBook.getListOfContacts());
        Contact contact2 = new Contact("Amit", "Kumar", "Mumbai", "Mumbai","Maharastra",
				   "123456", "9999999999", "mohit@gmail.com");
        response = addressBook.editContact("9999999999", contact2);
        System.out.println(response);
        System.out.println(addressBook.getListOfContacts());
    }
}
