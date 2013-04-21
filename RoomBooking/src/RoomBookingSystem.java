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
					if (delete(params))
						System.out.println("Reservations deleted");
					else
						System.out.println("Delete rejected");
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
		boolean booked = false;
		BookingInputs inputs = new BookingInputs(params);
		
		while (i.hasNext() && booked == false) {
			room = i.next();
			if(room.getCapacity() >= inputs.getCapacity()) {
				if(!room.foundReservations(inputs.getMonth(), 
						inputs.getDate(), inputs.getTime(), inputs.getNumWeeks())) {
					Reservation.createReservation(inputs, room);
					booked = true;
				}
			}
		}
	}
	
	private static void change(String[] params) {
		String[] deleteParams = {"Delete", params[1], params[2],
				params[3], params[4], params[5], params[6]};
		String[] bookingParams = {"Book", params[1], params[7],
				params[3], params[8], params[9], params[10], 
				params[11], params[12]};
		
		if (delete(deleteParams))
			book(bookingParams);
		else
			System.out.println("Change rejected.");
	}
	
	private static boolean delete(String[] params) {
		DeleteInputs inputs = new DeleteInputs(params);
		Room room = Room.findRoomByName(inputs.getRoom());
		
		if (room.foundReservations(inputs.getMonth(), inputs.getDate(),
				inputs.getTime(), inputs.getNumWeeks()))
			return (Reservation.deleteReservation(inputs, room));
		return false;
	}
}
