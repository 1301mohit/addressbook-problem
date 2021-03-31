package io.addressbookproblem;


public class AddressBookMain 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Address Book Program" );
        AddressBook addressBook = new AddressBook();
        System.out.println(addressBook.getListOfContacts());
    }
}
