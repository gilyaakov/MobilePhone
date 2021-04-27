package MobilePhone;

import java.util.ArrayList;

public class Player {
	
	    // ArrayList declaration
		protected static ArrayList<Media> mediaPlayer;
		
		// Default Constructor
		protected Player() {
			mediaPlayer = new ArrayList<Media>(); // Create an ArrayList object
		}
	    // User menu
		protected void menu() {
			while(true) {
				this.printMenu();
				System.out.println("Enter option:");
				String option = MobilePhone.myObj.nextLine();  // Read user input
				switch (option) {
				        case "1":
						         // Add media function
					             break;
					    case "2":
						         // Play Media by name function
					             break;
					    case "3":
					             // Play all function
					             break;
					    case "4":
						         return;
					     default:
						         System.out.println("No such option");
					    }
			    }
		}
		// Printing the menu
		protected void printMenu() {
			String str1,str2,str3,str4;
			str1 = "1. Add Media\n";
			str2 = "2. Play Media by name\n";
			str3 = "3. Play all\n";
			str4 = "4. Exit\n";
			System.out.println(str1+str2+str3+str4);
		}
}
