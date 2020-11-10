package main;

import java.awt.AWTException;
import java.util.Timer;
import java.util.TimerTask;

public class Reminder {

	public int id;
	public String description;
	private Timer timer;
	private ReminderTask reminderTask;
	
	public Reminder(int id, String description, long seconds) {
		this.id = id;
		this.description = description;
		setInterval(seconds);
	}
	
	public void setInterval(long seconds) {
		
		if(this.timer != null)
			this.timer.cancel();
		
		this.timer = new Timer("Reminder", true);
		this.reminderTask = new ReminderTask(this);
		long period = seconds * 1_000;
		this.timer.schedule(reminderTask, period, period);
	}

	@Override
	public String toString() {
		return id + " - " + description;
	}
	
	private class ReminderTask extends TimerTask {
		
		private final Reminder reminder;
		
		public ReminderTask(Reminder reminder) {
			this.reminder = reminder;
		}
		
		@Override
		public void run() {
			try {
				Utils.displayTray(reminder);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}
}
