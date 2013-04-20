import java.io.File;
import java.io.FileNotFoundException;
import java.util.ListIterator;
import java.util.Scanner;

public class RoomBookingSystem {
	
	public static void main(String args[]) {		
		try {
			Scanner inputScanner = new Scanner(new File(args[0]));
			
			while (inputScanner.hasNext()) {
				String s = inputScanner.nextLine();
				String[] params = s.split(" ");
				if (params[0].equals("Room")) {
					RoomInputs inputs = new RoomInputs(params);
					Room.createRoom(inputs);
				} else if (params[0].equals("Book")) {
					book(params);
				} else if (params[0].equals("Change")) {
					change(params);
				} else if (params[0].equals("Delete")) {
					DeleteInputs inputs = new DeleteInputs(params);
					Reservation.deleteReservation(inputs);
				} else if (params[0].equals("Print")) {
					Room.printReservations(params[1]);
				}
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void book(String[] params) {
		ListIterator<Room> i = Room.getAllRooms().listIterator();
		Room room;
		BookingInputs inputs = new BookingInputs(params);
		
		while (i.hasNext()) {
			room = i.next();
			if(room.getCapacity() >= inputs.getCapacity()) {
				if(!room.foundReservations(inputs.getMonth(), 
						inputs.getDate(), inputs.getTime(), inputs.getNumWeeks())) {
					Reservation.createReservation(inputs);
					break;
				}
			}
		}
	}
	
	private static void change(String[] params) {
		ChangeInputs cInputs= new ChangeInputs(params);
		String[] deleteParams = {"Delete", params[1], params[2],
				params[3], params[4], params[5], params[6]};
		DeleteInputs dInputs  = new DeleteInputs(deleteParams);
		String[] bookingParams = {"Book", params[1], params[7],
				params[3], params[8], params[9], params[10], 
				params[11], params[12]};
		BookingInputs bInputs = new BookingInputs(bookingParams);
		
		Reservation.changeReservation(cInputs, dInputs, bInputs);
	}
}
