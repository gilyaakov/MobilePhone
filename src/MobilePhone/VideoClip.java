package MobilePhone;

public class VideoClip extends Media{
	
	// Default Constructor
	protected VideoClip() {
		super();
	}
	//Constructor
	protected VideoClip(String name, int Length) {
		super(name, Length);
	}
	public void play() {
    	System.out.println("VideoClip:" + this.getName() + " " + "is now playing for" + " " + this.getLength() + " "+"time");	
	}

}
