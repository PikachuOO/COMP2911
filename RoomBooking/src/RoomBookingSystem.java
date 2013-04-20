import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;

public class RoomBookingSystem {
	public static void main(String args[]) {		
		try {
			Scanner inputScanner = new Scanner(new File(args[0]));
			File output = new File(args[1]);
			if (output.exists()) {
				output.delete();
			}
			
			while (inputScanner.hasNext()) {
				String s = inputScanner.nextLine();
				String[] params = s.split(" ");
				if (params[0].equals("Room")) {
					RoomInputs inputs = new RoomInputs(params);
					Room.createRoom(inputs, output);
				} else if (params[0].equals("Book")) {
					book(params, output);
				} else if (params[0].equals("Change")) {
					change(params, output);
				} else if (params[0].equals("Delete")) {
					DeleteInputs inputs = new DeleteInputs(params);
					Reservation.deleteReservation(inputs, output);
				} else if (params[0].equals("Print")) {
					Printer.printReservations(params[1], output);
				}
			}
			inputScanner.close();
			Printer.closeFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void book(String[] params, File output) {
		ListIterator<Room> i = Room.getAllRooms().listIterator();
		Room room;
		BookingInputs inputs = new BookingInputs(params);
		
		while (i.hasNext()) {
			room = i.next();
			if(room.getCapacity() >= inputs.getCapacity()) {
				if(!room.foundReservations(inputs.getMonth(), 
						inputs.getDate(), inputs.getTime(), inputs.getNumWeeks())) {
					Reservation.createReservation(inputs, output);
					break;
				}
			}
		}
	}
	
	private static void change(String[] params, File output) {
		ChangeInputs cInputs= new ChangeInputs(params);
		String[] deleteParams = {"Delete", params[1], params[2],
				params[3], params[4], params[5], params[6]};
		DeleteInputs dInputs  = new DeleteInputs(deleteParams);
		String[] bookingParams = {"Book", params[1], params[7],
				params[3], params[8], params[9], params[10], 
				params[11], params[12]};
		BookingInputs bInputs = new BookingInputs(bookingParams);
		
		Reservation.changeReservation(cInputs, dInputs, bInputs, output);
	}
}
