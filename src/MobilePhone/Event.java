package MobilePhone;

import java.util.Date;

public class Event extends Meeting {
	
	String Description;
	
	    // Constructor
        protected Event() {
			super();
			Description = "No description\n";
		}
		// Constructor
        protected Event(Date date, int Length, String s) {
			super(date,Length);
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
