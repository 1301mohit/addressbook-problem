package io.addressbookproblem;


public class AddressBookMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Address Book Program" );
        Contact contact1 = new Contact("Mohit", "Kumar", "Mumbai", "Mumbai",
			       					  "Maharastra", "123456", "9999999999", "mohit@gmail.com");
        Contact contact2 = new Contact("Amit", "Kumar", "Mumbai", "Mumbai",
					  				  "Maharastra", "123456", "9999999999", "amit@gmail.com");
        AddressBook addressBook = new AddressBook();
        addressBook.createContact(contact1);
        addressBook.createContact(contact2);
        System.out.println(addressBook.getListOfContacts());
    }
}
