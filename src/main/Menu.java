package main;

public class Menu {

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
}
