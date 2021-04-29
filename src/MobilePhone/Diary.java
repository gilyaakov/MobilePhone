// Students: Matan Eshel,Gil Ya'akov, Ron Gandelman, Eliyahu Latin
// Project Name: Task2
// Date: 29/04/2021
// Group number: 17
package MobilePhone;
import java.util.ArrayList; // import the ArrayList class
import java.util.Calendar; // import the Calendar class
import java.util.Collections;
import  java.util.Date; // import the Date class
import java.util.InputMismatchException;
import java.util.Iterator; // import the Iterator class
import java.util.concurrent.CopyOnWriteArrayList;

public class Diary {

	protected CopyOnWriteArrayList<CopyOnWriteArrayList<Meeting>> d;
	
	// Default Constructor
	protected Diary() {
		d = new CopyOnWriteArrayList<CopyOnWriteArrayList<Meeting>>();
		for(int i = 0; i<30; i++) {
		    CopyOnWriteArrayList<Meeting> e = new CopyOnWriteArrayList<Meeting>(); 
		    d.add(e);
		}
	}
	// Function for adding a meeting or event
	protected void addMeeting() throws InputMismatchException{
		Calendar c = Calendar.getInstance();
		System.out.println("Enter day (1-30):");
	    int day = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    if(day < 1 || day > 30) { // Input integrity check
	    	System.out.println("Error: No such day");
	    	return;
	    }
		System.out.println("Enter Hour (00-23):");
	    int hour = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    if(hour < 00 || hour > 23) { // Input integrity check
	    	System.out.println("Error: No such hour");
	    	return;
	    }
		System.out.println("Enter Minute (00-59):");
	    int minute = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    if(minute < 00 || minute > 59) { // Input integrity check
	    	System.out.println("Error: No such minute");
	    	return;
	    }
	    c.set(2021, 05, day, hour, minute, 00);
	    Date date = c.getTime(); // Initialize date
		System.out.println("Enter Length (1-60):");
	    int length = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    if(length < 1 || length > 60) { // Input integrity check
	    	System.out.println("Error: No such length");
	    	return;
	    }
	    c.add(Calendar.MINUTE, length);
	    Date end = c.getTime();
	    System.out.println("Enter option: 1. Event 2. Meeting with person");
	    String option = MobilePhone.myObj.nextLine();  // Read user input
		switch (option) {
		  case "1":
	               System.out.println("Enter Description:");
	               String description = MobilePhone.myObj.nextLine();  // Read user input
	               Event e = new Event(date, length, end, description);
	               d.get(day-1).add(e);
		           break;
		  case "2":
		           System.out.println("Enter name:");
		           String name = MobilePhone.myObj.nextLine();  // Read user input
		           if(!MobilePhone.pb.existPerson(name)) {
		    	      System.out.println("The contact doesn't exist");
		    	      return;
		              }
		           int index = MobilePhone.pb.searchPerson2(name);
		           String phoneNumber = MobilePhone.pb.PersonsPhoneBook.get(index).getphoneNumber();
		           PersonMeeting pm = new PersonMeeting(date, length, end, name ,phoneNumber);
		           d.get(day-1).add(pm);
		           break;
		  default:
			      System.out.println("No such option");
		}
	}
	// Function for delete a meeting or event
	protected void deleteMeeting() {
		System.out.println("Enter day (1-30) of the event you want to delete:");
	    int day = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    if(day < 1 || day > 30) { // Input integrity check
	    	System.out.println("Error: No such day");
	    	return;
	    }
	    System.out.println("Enter the number of event you want to delete:");
	    int number = MobilePhone.myObj.nextInt();  // Read user input
	    MobilePhone.myObj.nextLine();  // Clean enter
	    day = day - 1;
	    number = number - 1;
	    try {
	    	  //  Block of code to try
	    	  this.d.get(day).remove(number);
	    	}
	    	catch(Exception e) {
	    	  //  Block of code to handle errors
	    	  System.out.println("Error: No such event");
	    	}
	}
	// Function for delete all the meetings of a person (very very clever function)
	protected void deleteMeetingPerson(String name) {
		    Iterator<CopyOnWriteArrayList<Meeting>> iter0 = d.iterator();
		    while (iter0.hasNext()) {
		    	CopyOnWriteArrayList<Meeting> temp = iter0.next();
				if(!temp.isEmpty()) {
					Iterator<Meeting> iter = temp.iterator();
					while (iter.hasNext()) {
						Meeting m = iter.next();
						if(m instanceof PersonMeeting) {
							// Down casting
							PersonMeeting pm = (PersonMeeting)m;
							if(pm.getName().equals(name)) {
							   temp.remove(m);
							}
					    }
				    }
				}
		    }
	}
	// Function for print all the meetings with a person
	protected void printByPerson(String name) {
	    Iterator<CopyOnWriteArrayList<Meeting>> iter0 = d.iterator();
	    while (iter0.hasNext()) {
	    	CopyOnWriteArrayList<Meeting> temp = iter0.next();
			if(!temp.isEmpty()) {
				Iterator<Meeting> iter = temp.iterator();
				while (iter.hasNext()) {
					Meeting m = iter.next();
					if(m instanceof PersonMeeting) {
						// Down casting
						PersonMeeting pm = (PersonMeeting)m;
						if(pm.getName().equals(name)) {
						    System.out.println(m);
						}
				    }
			    }
			}
	    }
    }
	// Function to sort the diary
	protected void sortDiary() {
	    Iterator<CopyOnWriteArrayList<Meeting>> iter0 = d.iterator();
	    while (iter0.hasNext()) {
	    	CopyOnWriteArrayList<Meeting> temp = iter0.next();
			if(!temp.isEmpty()) {
				Collections.sort(temp);
			}
	    }	
	}
	// Handling collisions (also amazing function)
    protected void collisionsHandling() {
    	Iterator<CopyOnWriteArrayList<Meeting>> iter0 = d.iterator();
	    while (iter0.hasNext()) {
	    	CopyOnWriteArrayList<Meeting> temp = iter0.next();
			if(!temp.isEmpty()) {
				Iterator<Meeting> iter = temp.iterator();
				while (iter.hasNext()) {
					Meeting m = iter.next();
					Iterator<Meeting> iter1 = temp.iterator();
					while (iter1.hasNext()) {
						Meeting check = iter1.next();
						if((m.equals(check) == false) && (m.getEnd().compareTo(check.getDate()) == 1) && (check.getEnd().compareTo(m.getDate()) == 1)) {				
							temp.remove(check);
							iter = temp.iterator();
							iter1 = temp.iterator();
						}
				    }
			    }
			}
	    }
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
		    System.out.println("Enter option:");
		    String option = MobilePhone.myObj.nextLine();  // Read user input
			switch (option) {
			  case "1":
				  try {
				    this.addMeeting();
				  }catch(InputMismatchException e) {
					  MobilePhone.myObj.nextLine();  // Clean enter
					  System.out.println("Error: inValid input");
				  }
				    this.sortDiary();
			        break;
			  case "2":
				    this.deleteMeeting();
			        break;
			  case "3":
				    System.out.println("Enter day (1-30) for print:");
				    int day = MobilePhone.myObj.nextInt();  // Read user input
				    MobilePhone.myObj.nextLine();  // Clean enter
				    if(day < 1 || day > 30) { // Input integrity check
				    	System.out.println("Error: No such day");
				    	break;
				    }
				    day = day - 1;
				    System.out.println(d.get(day).toString()); // Print the date
			        break;
			  case "4":
				    System.out.println("Enter name:");
				    String name = MobilePhone.myObj.nextLine();  // Read user input
				    this.printByPerson(name);
			        break;
			  case "5":
				    this.collisionsHandling();
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
