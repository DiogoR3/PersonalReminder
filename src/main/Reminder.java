package main;

import java.time.Period;

public class Reminder {

	public Period Period;
	public String Description;
	
	public Reminder(Period Period, String Description) {
		this.Period = Period;
		this.Description = Description;
	}

	@Override
	public String toString() {
		return Description + " - " + Period;
	}
}
