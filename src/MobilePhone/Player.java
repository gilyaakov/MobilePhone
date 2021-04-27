package MobilePhone;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Player {
	
	    // ArrayList declaration
		protected static ArrayList<Playable> mediaPlayer;
		
		// Default Constructor
		protected Player() {
			mediaPlayer = new ArrayList<Playable>(); // Create an ArrayList object
		}
		// Add media function
		protected void addMedia() throws InputMismatchException{
			System.out.println("Enter name:");
            String name = MobilePhone.myObj.nextLine();  // Read user input
            System.out.println("Length:");
		    int Length = MobilePhone.myObj.nextInt();  // Read user input
		    MobilePhone.myObj.nextLine();  // Clean enter
            System.out.println("Enter option: 1. Song 2. VideoClip");
		    String option = MobilePhone.myObj.nextLine();  // Read user input
			switch (option) {
			  case "1":
		               Song s = new Song(name,Length);
		               mediaPlayer.add(s);
			           break;
			  case "2":
				       VideoClip c = new VideoClip(name,Length);
	                   mediaPlayer.add(c);
			           break;
			  default:
				      System.out.println("No such option");
			}
		}
		// Play all function
		protected void playAll(){
			Iterator<Playable> iter = mediaPlayer.iterator();
		    while (iter.hasNext()) {
		    	Playable m = iter.next();
		    	m.play();
		    }
		}
		// Play by name function
				protected void playName() throws InputMismatchException{
					System.out.println("Enter name:");
		            String name = MobilePhone.myObj.nextLine();  // Read user input
					Iterator<Playable> iter = mediaPlayer.iterator();
				    while (iter.hasNext()) {
				    	Playable m = iter.next();
				    	if(m.getName().equals(name)) {
				    	   m.play();
				    	   return;
				    	}
				    }
				    System.out.println("Error: No such media");
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
							          this.addMedia();
							     }catch(InputMismatchException e) {
								  MobilePhone.myObj.nextLine();  // Clean enter
								  System.out.println("Error: inValid input");
							  }
					             break;
					    case "2":
					    	     try {
						             this.playName();
						         }catch(InputMismatchException e) {
							      MobilePhone.myObj.nextLine();  // Clean enter
							      System.out.println("Error: inValid input");
						      }
					             break;
					    case "3":
					             this.playAll();
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
