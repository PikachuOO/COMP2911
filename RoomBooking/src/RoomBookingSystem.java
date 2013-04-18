import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoomBookingSystem {
	public static void main(String args[]) {		
		try {
			Scanner inputScanner = new Scanner(new File("src/inputs.txt"));
//			Scanner inputScanner = new Scanner(new File(args[0]));
//			File output = new File(args[1]);
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
				} else if (params[0].equals("Book")) {
					Reservation.createReservation(params);
				} else if (params[0].equals("Change")) {
					Reservation.changeReservation(params);
				} else if (params[0].equals("Delete")) {
					Reservation.deleteReservation(params);
				} else if (params[0].equals("Print")) {
					Printer.printReservations(params[1]);
				}
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
