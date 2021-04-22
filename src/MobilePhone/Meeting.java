package MobilePhone;

import  java.util.Date; // import the Date class
import java.text.DateFormat; // import the Date Format class
import java.text.SimpleDateFormat; // import the Date Format class

public class Meeting {
	
	Date date;
	int Length;
	
	// Constructor
	protected Meeting() {
		date = new Date();
		Length = 0;
	}
	// Constructor
	protected Meeting(Date date,int Length) {
		this.date = date;
		this.Length = Length;
	}
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    return df.format(date) + " " + Length;
	}
	// Return Date function
	protected Date getDate() {
		return this.date;
	}
	// Return Length function
	protected int getLength() {
		return this.Length;
	}
}
