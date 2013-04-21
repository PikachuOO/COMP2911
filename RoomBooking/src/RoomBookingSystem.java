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
				if (params[0].equalsIgnoreCase("Room")) {
					RoomInputs inputs = new RoomInputs(params);
					Room.createRoom(inputs);
				} else if (params[0].equalsIgnoreCase("Book")) {
					book(params);
				} else if (params[0].equalsIgnoreCase("Change")) {
					change(params);
				} else if (params[0].equalsIgnoreCase("Delete")) {
					if (delete(params))
						System.out.println("Reservations deleted");
					else
						System.out.println("Deletion rejected");
				} else if (params[0].equalsIgnoreCase("Print")) {
					Room.printReservations(params[1]);
				}
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Book for a reservation using the give parameters.
	 * @param params A string array of inputs needed to
	 * book for a room.
	 */
	private static void book(String[] params) {
		ListIterator<Room> i = Room.getAllRooms().listIterator();
		Room room = null;
		boolean booked = false;
		BookingInputs inputs = new BookingInputs(params);
		
		while (i.hasNext() && booked == false) {
			room = i.next();
			if(room.getCapacity() >= inputs.getCapacity()) {
				if(room.foundReservations(inputs.getMonth(), 
						inputs.getDate(), inputs.getTime(), inputs.getNumWeeks()) == 0) {
					booked = Reservation.createReservation(inputs, room);
				}
			}
		}
		if (booked == true)
			System.out.println("Room " + room.getRoomName() + " assigned");
		else
			System.out.println("Booking rejected");
	}
	
	/**
	 * Change a reservation according to the new requirements
	 * such as new month, date, time or title.
	 * @param params A string array of inputs value needed
	 * to change a certain number of reservations.
	 */
	private static void change(String[] params) {
		String[] deleteParams = {"Delete", params[1], params[2],
				params[3], params[4], params[5], params[6]};
		String[] bookingParams = {"Book", params[1], params[7],
				params[3], params[8], params[9], params[10], 
				params[11], params[12]};
		
		if (delete(deleteParams))
			book(bookingParams);
		else
			System.out.println("Change rejected");
	}
	
	/**
	 * Remove a number of reservations according to the number
	 * of reservations defined in the inputs.
	 * @param params A string array of inputs value needed
	 * to delete the number of reservations.
	 * @return True if reservations are deleted. False otherwise.
	 */
	private static boolean delete(String[] params) {
		DeleteInputs inputs = new DeleteInputs(params);
		Room room = Room.findRoomByName(inputs.getRoom());
		
		if (room != null) {
			if (room.foundReservations(inputs.getMonth(), 
				inputs.getDate(), inputs.getTime(), inputs.getNumWeeks()) == inputs.getNumWeeks())
			return (Reservation.deleteReservation(inputs, room));
		}
		return false;
	}
}
