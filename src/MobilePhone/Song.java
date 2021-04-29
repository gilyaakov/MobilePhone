// Students: Matan Eshel,Gil Ya'akov, Ron Gandelman, Eliyahu Latin
// Project Name: Task2
// Date: 29/04/2021
// Group number: 17
package MobilePhone;

public class Song extends Media{
	
	// Default Constructor
	protected Song() {
		super();
	}
	//Constructor
	protected Song(String name, int Length) {
		super(name, Length);
	}
    public void play() {
    	System.out.println("Song:" + this.getName() + " " + "is now playing for" + " " + this.getLength() + " "+"time");	
	}
}
