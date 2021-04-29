// Students: Matan Eshel,Gil Ya'akov, Ron Gandelman, Eliyahu Latin
// Project Name: Task2
// Date: 29/04/2021
// Group number: 17
package MobilePhone;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Fields:
 * 	1. msgingData - MyData array
 * 	2. contactAmount - number of contacts I'm messaging with
 * Methods:
 * 	3. existMessaging - Return true if there are messages with the contact - input: Name
 *	4. findContactIndex - Find the index of the contact by name in msgingData, return -1 if not there
 *	5. addCorresponding - Adds a message to the given name | Create new if needed - check if contact exists on phone book
 * 	6. deleteCorresponding - Delete the messages with the contact name given
 * 	7. printCorresponding - Print the messages with the given name
 * 	8. printAllCorresponding - Print the entire message data base
 * 	9. searchMsg - search the message given and return a contact list containing the message in the corresponding
 * 	10. menu - the control method according to the user inputs
 * 	11. printMenu - Prints the SMS Application menu to the user
 * 
 * 
 * */

public class MsgSystem {
	
	public class MyData 
	/*Fields:
	 *	 1. contactName - the name of the contact - Can change to person if number is needed
	 *	 2. personCorrespondence - ArrayList of strings, saving the messages from that contact
	 *	 3. msgAmount - The number of messages with that contact
	 * Methods:
	 *	 1.addMsg - Adds a message to personCorrespondence  
	 *	 2.getName - return the name of the contact
	 *	 3.getMessgse - return the message list
	 * */
	{
		private String contactName;		
		private CopyOnWriteArrayList<String> personCorrespondence;	
		private int msgAmount;
		
		protected MyData(String pers,String str) 
		{
			this.contactName = pers;
			this.personCorrespondence = new CopyOnWriteArrayList<String>();
			this.personCorrespondence.add(str);
			this.msgAmount = 0;
		}
		
		protected void addMsg(String msg)
		{
			this.personCorrespondence.add(msg);
			this.msgAmount++;
		}
		protected String getName()
		{
			return this.contactName;	
		}
		
		protected CopyOnWriteArrayList<String> getMessgses()
		{
			return this.personCorrespondence;
		}
	}
	
	private CopyOnWriteArrayList<MyData> msgingData;
	private int contactAmount;
	
	protected MsgSystem()
	{
		this.msgingData = new CopyOnWriteArrayList<MyData>();
		this.contactAmount = 0;	
	}
	
	
	protected boolean existMessaging(String name) 
	{
		for(MyData a : msgingData)
		{
			if(a.getName().equals(name)) 	
			{
				return true;
			}
		}
		return false;
	}
	
	
	protected int findContactIndex(String name)
	{
        int count = 0;
		for(MyData a : msgingData)
		{
			if(a.getName().equals(name)) 
			{
				return count;
			}
			else
			{
				count++;
			}
		}
		return -1;
	}
	
	
	protected void addCorresponding(PhoneBook phoneBook, String name, String msg)
	{
		// First search if I already messaging this contact
		if (existMessaging(name))
		{
			int index = findContactIndex(name); // index > -1 always here 
			msgingData.get(index).personCorrespondence.add(msg);
		}
		else
		{
			// Else create a new object - ONLY IF CONTACT EXISTS IN PHONEBOOK
			// TODO: Check how to access our phone book in MobilePhone class
			if (!phoneBook.existPerson(name))
			{
				System.out.println("ERROR: No contact with that name exists");
			}
			else
			{	
				MyData info = new MyData(name,msg);
				this.msgingData.add(info);
				this.contactAmount++;
					
			}
		}
	}
	
	
	protected void updateMsgSystem(PhoneBook pb)
	{
		String name;
		for(MyData data : this.msgingData)
		{
			name = data.getName();
			if(!pb.existPerson(name))
			{
				this.deleteCorresponding(name);
			}		
		}	
	}
	
	
	protected void deleteCorresponding(String name)
	{
		// First handle the case the contact has no Corresponding
		if (!existMessaging(name))
		{
			System.out.println("No corresponding with that contact");
		}
		else
		{
			int index = findContactIndex(name);
			msgingData.remove(index);
			System.out.println("Contact corresponding removed");
			this.contactAmount--;
		}	
	}

	
	protected void printCorresponding(String name)
	{
		// First handle the case the contact has no Corresponding
		int index;
		if (!existMessaging(name))
		{
			System.out.println("No corresponding with that contact");
		}
		else
		{
			index = findContactIndex(name);
			System.out.println("Printing " + name + "'s corresponding:"); 	
		    for (String str : msgingData.get(index).personCorrespondence)
		    { 		      
		    	System.out.println(str); 		
		    }
		}		
	}
	
	
	protected void printAllCorresponding()
	{
		System.out.println("Printing the entire corresponding history"); 	
		for (int i=0; i<this.contactAmount; i++)
		{
			printCorresponding(msgingData.get(i).contactName);	
		}	
	}
	
	
	protected void searchMessage(String msg)
	{
		boolean exist = false;
		System.out.println("The following contacts correspondence contain the given expression:");
		for(MyData element : msgingData)
		{
			for(String str : element.personCorrespondence)
			{
				if (str.contains(msg))
				{
					System.out.println(element.getName());
					exist = true;
				}
			}	
		}	
		if(!exist)
		{
			System.out.println("None!");
		}		
	}
	
	
	protected void menu(PhoneBook pb)
	{
		while(true) 
		{
			this.printMenu();	
			//  update our SMS contacts according to the new phone book
			if(this.contactAmount >0) {updateMsgSystem(pb);} 
			String name;
			String userMsgGiven;
			// String userMsg;
		    System.out.println("Enter option:");
		    String option = MobilePhone.myObj.nextLine();  // Read user input
			switch (option) 
			{
			  case "1":
				  try {
					System.out.println("Enter the contact's name:");
					name = MobilePhone.myObj.nextLine(); 
					System.out.println("Type the message - press Enter to send");
					userMsgGiven = MobilePhone.myObj.nextLine(); 
					this.addCorresponding(pb,name,userMsgGiven);
				  }catch(InputMismatchException e) {
					  MobilePhone.myObj.nextLine();  // Clean enter
					  System.out.println("Error: invalid input");
				  }
			        break;
			  case "2":
					System.out.println("Enter the contact's name");
					name = MobilePhone.myObj.nextLine();
					this.deleteCorresponding(name);
			        break;
			  case "3":
					System.out.println("Enter the contact's name");
					name = MobilePhone.myObj.nextLine();
					this.printCorresponding(name);
			        break;
			  case "4":
				  	System.out.println("Enter expression - press Enter when done");
				  	String searchMsg = MobilePhone.myObj.nextLine();
				  	this.searchMessage(searchMsg);
			        break;
			  case "5":
				    this.printAllCorresponding();
			        break;
			  case "6":
			        return;
			  default:
				    System.out.println("No such option");
			}
		}	
	}
	
	
	protected void printMenu() 
	{
		String str1,str2,str3,str4,str5,str6;
		str1 = "1. Add corresponding with contact\n";
		str2 = "2. Delete corresponding with contact\n";
		str3 = "3. Print corresponding with contact\n";
		str4 = "4. Search an expression\n";
		str5 = "5. Print all corresponding\n";
		str6 = "6. Exit\n";
		System.out.println(str1+str2+str3+str4+str5+str6);
	}
}

