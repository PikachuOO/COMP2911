import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RoomBookingSystem {
	public static void main(String args[]) {
		try {
			Scanner inputScanner = new Scanner(new File("src/inputs.txt"));
			while (inputScanner.hasNext()) {
				String s = inputScanner.nextLine();
				String[] params = s.split(" ");
				if (params[0].equals("Room")) {
					try {
						Room.createRoom(Integer.parseInt(params[1]), params[2]);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Sorry, room added. Hence, skipped.");
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
