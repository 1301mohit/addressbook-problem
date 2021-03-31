package io.addressbookproblem;


public class AddressBookMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Address Book Program" );
        AddressBook addressBook = new AddressBook();
        Contact contact1 = new Contact("Mohit", "Kumar", "Mumbai", "Mumbai","Maharastra",
        							   "123456", "9999999999", "mohit@gmail.com");
        addressBook.addContact(contact1);
        System.out.println(addressBook.getListOfContacts());
    }
}
