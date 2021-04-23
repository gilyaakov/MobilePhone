// Students: Matan Eshel 203502802 & Gil Ya'akov 203382858
// Project Name: Task2
// Date: 19/04/2021
// Group number: 17
package MobilePhone;
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Iterator;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

public class PhoneBook {
	
	// ArrayList declaration
	protected static ArrayList<Person> PersonsPhoneBook;
	
	// Default Constructor
	protected PhoneBook() {
		PersonsPhoneBook = new ArrayList<Person>(); // Create an ArrayList object
	}
	// Add person function
    protected void addPerson(String name, String phoneNumber) {
    	
    	if(existPerson(name)) {
    		System.out.println("The contact already exists");
    		return;
    	}
    	else {
		Person p = new Person(name,phoneNumber);
		PersonsPhoneBook.add(p);
    	}
	}
    // Delete person function
	protected void deletePerson(String name) {
        int i = 0;
		for(Person a : PersonsPhoneBook) {
			if(a.getName().equals(name)) {
			   PersonsPhoneBook.remove(i);
			   return;
			}
			i++;
		}
		if(i == PersonsPhoneBook.size()) {
		   System.out.println("ERROR: No contact found");
		   return;
		}
	}
	// Search person function
	protected int searchPerson(String name) {
        int i = 0;
        int count = 0;
		for(Person a : PersonsPhoneBook) {
			if(a.getName().equals(name)) {
				System.out.println(i + " " + a);
				count++;
			}
			i++;
		}
		if(count == 0) {
		   System.out.println("ERROR: No contact found");
		}
		return i;
	}
	protected int searchPerson2(String name) {
        int i = 0;
		for(Person a : PersonsPhoneBook) {
			if(a.getName().equals(name)) {
		 	   return i;
			}
			i++;
		}
		return i;
	}
	// Boolean search person function
	protected boolean existPerson(String name) {
        int count = 0;
		for(Person a : PersonsPhoneBook) {
			if(a.getName().equals(name)) {
				count++;
			}
		}
		if(count == 0) {
		   return false;
		}
		return true;
	}
	// toString Override
	@Override
	public String toString(){
		String str = "";
		for(Person a : PersonsPhoneBook) {
			str += a.toString() + "\n";
		}
		return str;
	}
	// Lexicographic Sort of the phone book (by name) From the smallest to the largest name - using bubble sort
	protected void lexicographicSort() { 
		Collections.sort(PersonsPhoneBook);
	}
	// Numerical Sort of the phone book (by phone number) From the largest to the smallest phone number - using bubble sort
	protected void numericalSort() { 
        Person temp;
        int n = PersonsPhoneBook.size(); 
        for (int j = 0; j < n - 1; j++) { 
            for (int i = j + 1; i < n; i++) { 
                if (PersonsPhoneBook.get(j).getphoneNumber().compareTo(PersonsPhoneBook.get(i).getphoneNumber()) < 0) { 
                    temp = PersonsPhoneBook.get(j); 
                    PersonsPhoneBook.set(j, PersonsPhoneBook.get(i));
                    PersonsPhoneBook.set(i, temp); 
                } 
            } 
        } 
    }
	// Remove Duplicates function
	protected void removeDuplicates() {
		for(int i = 0; i < PersonsPhoneBook.size(); i++) {
			for(int j = 0; j < PersonsPhoneBook.size(); j++) {
				if(PersonsPhoneBook.get(i).equals(PersonsPhoneBook.get(j)) && (i != j)){
				   PersonsPhoneBook.remove(j);
				   }
				}
			}		
	}
	// Inverse the order of the phone book
	protected void inversePhoneBook() {
		int i = 0;
		int j = PersonsPhoneBook.size() - 1 ;
        Person temp;
		while ((i!=j) && (i <= j)) {
            temp = PersonsPhoneBook.get(j); 
            PersonsPhoneBook.set(j, PersonsPhoneBook.get(i));
            PersonsPhoneBook.set(i, temp);
			i++;
			j--;
		}		
	}
	// Save the phone book to file
	protected void saveFile(String fileName) {
		try {
		      File pb = new File(fileName + ".txt");
		      if (pb.createNewFile()) {
		        System.out.println("File created: " + pb.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } 
		catch (IOException e) {
		       System.out.println("An error occurred.");
		       e.printStackTrace();
		}
		try {
		      FileWriter myWriter = new FileWriter(fileName + ".txt");
		      Iterator<Person> itr = PersonsPhoneBook.iterator();
		        while(itr.hasNext()) {
		              myWriter.write(itr.next().toString() + "\n");
		              }
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	// Load contacts to the phone book from file
	protected void loadFile(String fileName) {
		try {
		      File pb = new File(fileName + ".txt");
		      Scanner myReader = new Scanner(pb);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] parts = data.split(" ");
		        this.addPerson(parts[0], parts[1]);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	// User menu
	protected void menu() {
		while(true) {
			this.printMenu();
		    System.out.println("Enter option:");
		    String option = MobilePhone.myObj.nextLine();  // Read user input
			switch (option) {
			  case "1":
				    System.out.println("Enter name:");
				    String name = MobilePhone.myObj.nextLine();  // Read user input
				    System.out.println("Enter phone number:");
				    String phoneNumber = MobilePhone.myObj.nextLine();  // Read user input       
				    this.addPerson(name, phoneNumber);
			        break;
			  case "2":
				    System.out.println("Enter name to delete:");
				    String nameToDelete = MobilePhone.myObj.nextLine();  // Read user input
				    this.deletePerson(nameToDelete);
				    MobilePhone.myDiary.deleteMeetingPerson(nameToDelete);
			        break;
			  case "3":
			        System.out.println(this);
			        break;
			  case "4":
				    System.out.println("Enter name to search:");
				    String nameToSearch = MobilePhone.myObj.nextLine();  // Read user input
				    this.searchPerson(nameToSearch);
			        break;
			  case "5":
			        this.lexicographicSort();
			        break;
			  case "6":
			        this.numericalSort();
			        break;
			  case "7":
			        this.removeDuplicates();
			        break;
			  case "8":
				    this.inversePhoneBook();
				    break;
			  case "9":
				    System.out.println("Enter file name to save:");
				    String fileName = MobilePhone.myObj.nextLine();  // Read user input
				    this.saveFile(fileName);
				    break;
			  case "10":
				    System.out.println("Enter file name to load:");
				    String fileNameLoad = MobilePhone.myObj.nextLine();  // Read user input
				    this.loadFile(fileNameLoad);
				    break;
			  case "11":
				    return;
			  default:
				    System.out.println("No such option");
			}
		}
	}
	// Printing the menu
	protected void printMenu() {
		String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11;
		str1 = "1. Add new contact member\n";
		str2 = "2. Delete contact member by name\n";
		str3 = "3. Print phonebook to screen\n";
		str4 = "4. search contact member by name\n";
		str5 = "5. Sort phonebook in lexicographic order by name\n";
		str6 = "6. Sort phonebook in numerical order by phone number\n";
		str7 = "7. Remove Duplicates contact members\n";
		str8 = "8. Inverse phonebook\n";
		str9 = "9. Save phonebook in text file\n";
		str10 = "10. Load text file to phonebook\n";
		str11 = "11. Exit\n";
		System.out.println(str1+str2+str3+str4+str5+str6+str7+str8+str9+str10+str11);
	}
}

