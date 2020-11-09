package main;

import java.time.Period;

public class Reminder {

	public Period period;
	public String description;
	
	public Reminder(Period period, String description) {
		this.period = period;
		this.description = description;
	}

	@Override
	public String toString() {
		return description + " - " + period;
	}
}
