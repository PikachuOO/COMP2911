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
				switch (params[0]) {
				case "Room":
					try {
						Room.createRoom(Integer.parseInt(params[1]), params[2]);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Sorry, room added. Hence, skipped.");
					}
					break;
				case "Book":
					Reservation.createReservation(params);
//					try {
//						Reservation.createReservation(params);
//					} catch (NumberFormatException e) {
//						e.printStackTrace();
//					} catch (Exception e) {
//						System.out.println("Invalid inputs. Nothing was done");
//					}
					break;
				}
			}
			inputScanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
