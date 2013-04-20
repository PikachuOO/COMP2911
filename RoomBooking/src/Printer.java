import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Printer {	
	/**
	 * Print all the existing reservation for a give room name.
	 * This method prints the user of the reservation, the month and date
	 * when the reservation starts, and the time and number of hours
	 * the reservation lasts for.
	 * @param name A string that specifies the name of the room
	 * for which its reservations are to be printed.
	 */
	public static void printReservations(String name, File output) {
		Room room = Room.findRoomByName(name);
		if (room != null) {
			writeToFile(room.getRoomName(), output);
			for (Reservation booking : room.getReservations()) {
				String contents = booking.getUser().getName() + " " +
						MonthConverter.convertMonthToString(booking.getReservationMonth()) + 
						" " + booking.getReservationDate() + " " +
						booking.getReservationTime() + " " +
						booking.getReservationDuration() + " " +
						booking.getTitle();
				writeToFile(contents, output);
			}
		}
	}
	
	/**
	 * This method writes texts to output file.
	 * @param contents A string that contains
	 * the contents of the things needed to write into
	 * the output file.
	 */
	public static void writeToFile(String contents, File output) {
		try {
			fop = new FileOutputStream(output, true);
			// if file doesn't exists, then create it
			if (!output.exists()) {
				output.createNewFile();
			}
 
			// get the content in bytes
			byte[] contentInBytes = contents.getBytes();
 
			fop.write(contentInBytes);
			fop.write(13);
			fop.write(10);
			fop.flush();
 
		} catch (IOException e) {
			System.out.println("File writing error occured. Nothing was written.");
		}
	}
	
	public static void closeFile() {
		try {
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static FileOutputStream fop;
}
