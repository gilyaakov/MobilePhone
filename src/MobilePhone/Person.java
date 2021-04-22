// Students: Matan Eshel 203502802 & Gil Ya'akov 203382858
// Project Name: Task2
// Date: 19/04/2021
// Group number: 17
package MobilePhone;

import java.util.Objects;
import java.util.ArrayList; // import the ArrayList class

public class Person implements Comparable<Person> {
    
	// Variables declaration
	private String name, phoneNumber;
	protected ArrayList<Meeting> pm;
	
	// Default Constructor
	protected Person(){
		name = "Ploni";
		phoneNumber = "0000000000";
		pm = new ArrayList<Meeting>();
	}
	// Constructor
	protected Person(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	// toString override
	@Override
	public String toString(){
	    return name + " " + phoneNumber;
	}
	// Return name function
	protected String getName() {
		return this.name;
	}
	// Return phone number function
	protected String getphoneNumber() {
		return this.phoneNumber;
	}
	// Equals override
	@Override
	public boolean equals(Object other) {
	    // Self check
	    if (this == other)
	        return true;
	    // Null check
	    if (other == null)
	        return false;
	    // Type check and cast
	    if (getClass() != other.getClass())
	        return false;
	    Person person = (Person) other;
	    // Field comparison
	    return Objects.equals(name, person.name) && Objects.equals(phoneNumber, person.phoneNumber);
	}
	// compareTo implement
	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
}

