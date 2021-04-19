// Students: Matan Eshel 203502802 & Gil Ya'akov 203382858
// Project Name: Task2
// Date: 19/04/2021
// Group number: 17
package MobilePhone;

import java.util.Scanner; // Import the Scanner class to read text files

public class MobilePhone {
	
	PhoneBook pb;
	public static Scanner myObj = new Scanner(System.in);
	
	// Default Constructor
	protected MobilePhone() {
		pb = new PhoneBook();
	}
	protected void PhoneBookControl() {
		this.pb.menu();
		return;
	}
	// User menu
	protected void menu() {
		while(true) {
			this.printMenu();
		    System.out.println("Enter option");
		    String option = myObj.nextLine();  // Read user input
			switch (option) {
			  case "1":
				    this.PhoneBookControl();
			        break;
			  case "2":
				    //SMS control
			        break;
			  case "3":
				    //Diary control
			        break;
			  case "4":
				    //Media control
			        break;
			  case "5":
				    //Print all (polymorphism)
			        break;
			  case "6":
				    myObj.close();
				    System.out.println("Goodbye!");
				    return;
			  default:
				    System.out.println("No such option");
			}
		}
	}
	// Printing the menu
	protected void printMenu() {
		String str1,str2,str3,str4,str5,str6;
		str1 = "1. PhoneBook\n";
		str2 = "2. SMS\n";
		str3 = "3. Diary\n";
		str4 = "4. Media\n";
		str5 = "5. Print\n";
		str6 = "6. Exit\n";
		System.out.println(str1+str2+str3+str4+str5+str6);
	}
}
