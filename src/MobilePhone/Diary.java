// Students: Matan Eshel 203502802 & Gil Ya'akov 203382858
// Project Name: Task2
// Date: 19/04/2021
// Group number: 17
package MobilePhone;
import java.util.ArrayList; // import the ArrayList class

public class Diary {

	protected ArrayList<ArrayList<Meeting>> d;
	
	// Default Constructor
	protected Diary() {
		d = new ArrayList<ArrayList<Meeting>>(30);
		for(int i = 0; i<30; i++) {
		    ArrayList<Meeting> e = new ArrayList<Meeting>(); 
		    d.add(e);
		}
	}
	protected void addMeeting() {
	    System.out.println("Enter name:");
	    String name = MobilePhone.myObj.nextLine();  // Read user input
	    if(!MobilePhone.pb.existPerson(name)) {
	    	System.out.println("The contact doesn't exist");
	    	return;
	    }
	    int index = MobilePhone.pb.searchPerson2(name);
	    Meeting b = new Meeting();
	    Meeting b1 = new Meeting();
	    Meeting b2 = new Meeting();
	    //PhoneBook.PersonsPhoneBook.get(index).pm.add(e);
	    d.get(0).add(b);
	    d.get(3).add(b1);
	    d.get(3).add(b2);
	}
	// toString Override
	@Override
	public String toString(){
		String str = "";
		for(int i = 0; i<30; i++) {
			if(!d.get(i).isEmpty()) {
			    for(Meeting a: d.get(i)) {
					str += a.toString() + "\n";
			        }
			}
		}
		return str;
	}
	// User menu
	protected void menu() {
		while(true) {
			this.printMenu();
		    System.out.println("Enter option");
		    String option = MobilePhone.myObj.nextLine();  // Read user input
			switch (option) {
			  case "1":
				    this.addMeeting();
			        break;
			  case "2":
			        break;
			  case "3":
			        break;
			  case "4":
			        break;
			  case "5":
			        break;
			  case "6":
				    System.out.println(d);
			        break;
			  case "7":
				    return;
			  default:
				    System.out.println("No such option");
			}
		}
	}
	// Printing the menu
	protected void printMenu() {
		String str1,str2,str3,str4,str5,str6,str7;
		str1 = "1. Add Event\n";
		str2 = "2. Delete Event\n";
		str3 = "3. Print Date schedule\n";
		str4 = "4. Print Contact schedule\n";
		str5 = "5. Identify if there are colliding events\n";
		str6 = "6. Print diary\n";
		str7 = "7. Exit\n";
		System.out.println(str1+str2+str3+str4+str5+str6+str7);
	}
}
