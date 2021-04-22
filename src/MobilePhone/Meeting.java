package MobilePhone;

import  java.util.Date;

public class Meeting {
	
	Date date;
	int Length;
	
	protected Meeting() {
		date = new Date();
		Length = 0;
	}
	protected Meeting(Date date,int Length) {
		this.date = date;
		this.Length = Length;
	}
	@Override
	public String toString() {
	    return date + " " + Length;
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
