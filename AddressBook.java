package com.bridgelabz.problem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Predicate;

public class AddressBook {
	private static HashSet<ContactPerson> contactPersonList = new HashSet<ContactPerson>();

	public static void main(String[] args) {
		addContactPerson();
		addContactPerson();
		addContactPerson();
		for (ContactPerson contactPerson : contactPersonList) {
			showContactPerson(contactPerson);
		}
	}

	/**
	 * uc7
	 * 
	 */
	/**
	 * 
	 */
	public static void addContactPerson() {
		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter the First Name ");
		String firstName = scannerObj.next();
		System.out.println("Enter the last Name ");
		String lastName = scannerObj.next();
		System.out.println("Enter the address ");
		String address = scannerObj.next();
		System.out.println("Enter the  city ");
		String city = scannerObj.next();
		System.out.println("Enter the state ");
		String state = scannerObj.next();
		System.out.println("Enter the zip ");
		String zip = scannerObj.next();
		System.out.println("Enter the phoneNumber ");
		double phoneNumber = scannerObj.nextDouble();
		System.out.println("Enter the email ");
		String email = scannerObj.next();
		ContactPerson contactPerson = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber,
				email);
		if (contactPersonList.size() == 0)
			contactPersonList.add(contactPerson);
		else {
			Predicate<ContactPerson> isDuplicate = (ContactPerson) -> {
				for (ContactPerson contactPersonInList : contactPersonList) {
					if (contactPersonInList.getFirstName().equals(contactPerson.getFirstName())
							&& contactPersonInList.getLastName().equals(contactPerson.getLastName()))
					return true;
				}
				return false;
			};
			if (contactPersonList.stream().anyMatch(isDuplicate)) {
			} 
			else {
				contactPersonList.add(contactPerson);
			}
		}
		scannerObj.close();
	}
	public static void showContactPerson(ContactPerson contactPerson) {
		System.out.println(contactPerson.getFirstName());
		System.out.println(contactPerson.getLastName());
		System.out.println(contactPerson.getAddress());
		System.out.println(contactPerson.getCity());
		System.out.println(contactPerson.getState());
		System.out.println(contactPerson.getZip());
		System.out.println(contactPerson.getPhoneNumber());
		System.out.println(contactPerson.getEmail());
	}

}