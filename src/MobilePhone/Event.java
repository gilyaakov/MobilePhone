// Students: Matan Eshel 203502802 & Gil Ya'akov 203382858
// Project Name: Task2
// Date: 19/04/2021
// Group number: 17
package MobilePhone;

import java.util.Date;

public class Event extends Meeting {
	
	private String Description;
	
	    // Default Constructor
        protected Event() {
			super();
			Description = "No description\n";
		}
		// Constructor
        protected Event(Date date, int Length, Date end, String s) {
			super(date,Length,end);
			Description = s;
		}
		@Override
		public String toString() {
		    return super.toString() + " " + Description;
		}
		// Return Date function
		protected String getDescription() {
			return this.Description;
		}
		// Set Description function
	    protected void setDescription(String s) {
			this.Description = s;
		}
}
