package main;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

	public static String readInput() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch(IOException ex) {
			return null;
		}
	}
	
    public static void displayTray(Reminder reminder) throws AWTException {
    	
        SystemTray tray = SystemTray.getSystemTray();

        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Tray Icon");

        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Reminder #" + reminder.id);
        tray.add(trayIcon);

        trayIcon.displayMessage("Reminder #" + reminder.id, reminder.description, MessageType.INFO);
    }
}
