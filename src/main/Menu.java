package main;

import java.util.ArrayList;

public class Menu {

	private ArrayList<Reminder> reminderList = new ArrayList<Reminder>();
	
	public Menu() {
		System.out.println("**** Personal Reminder ****");
	}
	
	public void start()	{
		
		System.out.println("1 - Add a new reminder");
		System.out.println("2 - Edit a reminder");
		System.out.println("3 - List all reminders");
		System.out.println("Please choose and option: ");
		
		String input = Utils.readInput();
		MenuOption option = MenuOption.getOption(input);
		
		if(option == MenuOption.Add) {
			addReminder();
		}else if(option == MenuOption.Edit) {
			editReminder();
		}else if(option == MenuOption.List) {
			listReminders();
		}else {
			System.out.println("Invalid option!");
		}
		
		start();
	}
	
	public enum MenuOption {
		Add(1), Edit(2), List(3), None(4);

		private MenuOption(int option){
				
		}
		
		public static MenuOption getOption(String option) {
			MenuOption menuOption;
			
			switch(option) {
				case "1": menuOption = MenuOption.Add;
				break;
				
				case "2": menuOption = MenuOption.Edit;
				break;
				
				case "3": menuOption = MenuOption.List;
				break;
				
				default: return MenuOption.None;
			}
			
			return menuOption;
		}
		
		public static MenuOption getOption(int option) {
			
			return getOption(Integer.toString(option));
		}
	}
	
	private void addReminder() {
		
		System.out.print("Please type the reminder description: ");
		String reminderDescription = Utils.readInput();
		
		System.out.print("Please type the reminder interval in seconds: ");
		String reminderSeconds = Utils.readInput();
		
		Reminder reminder = new Reminder(reminderList.size() + 1, reminderDescription, Long.parseLong(reminderSeconds));
		reminderList.add(reminder);
	}
	
	private void editReminder() {
		
		if(reminderList.isEmpty()) {
			System.out.println("There are no reminders configured!");
			return;
		}
		
		System.out.println("Please choose a reminder:");
		listReminders();
		
		String reminderId = Utils.readInput();

		try {
			Reminder reminder = reminderList.get(Integer.parseInt(reminderId) - 1);
			editReminder(reminder);
			
		}catch(Exception ex) {
			System.out.println("There are no reminders with the id '" + reminderId + "'");
		}
	}
	
	private void editReminder(Reminder reminder) {
		
		System.out.print("Please type the reminder description: ");
		reminder.description = Utils.readInput();
		
		System.out.print("Please type the reminder interval in seconds: ");
		reminder.setInterval(Long.parseLong(Utils.readInput()));
	}
	
	private void listReminders() {
		for(int x = 0; x < reminderList.size(); x++) {
			System.out.println(reminderList.get(x));
		}
		System.out.println();
	}
}
