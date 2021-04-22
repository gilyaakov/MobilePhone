package MobilePhone;

import java.util.Date;

public class PersonMeeting extends Meeting {
	
	private String name, phoneNumber;
	
	    // Constructor
        protected PersonMeeting() {
			super();
			name = "Ploni";
			phoneNumber = "0000000000";
		}
		// Constructor
        protected PersonMeeting(Date date, int Length,String name, String phoneNumber) {
			super(date,Length);
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
		@Override
		public String toString() {
		    return super.toString() + " " + name + " " + phoneNumber;
		}
		// Return name function
		protected String getName() {
			return this.name;
		}
		// Return phoneNumber function
		protected String getPhoneNumber() {
			return this.phoneNumber;
		}
		// Set name function
	    protected void setName(String s) {
			this.name = s;
		}
	    // Set phoneNumber function
	    protected void setPhoneNumber(String s) {
			this.phoneNumber = s;
		}
}
