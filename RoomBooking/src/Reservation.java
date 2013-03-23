import java.util.LinkedList;


public class Reservation {
	private Reservation reservation;
	private String reservationTitle;
	private Room room;
	private Day reservationDays;
	private User user;
	
	private Reservation(String name, int capacity, int numWeeks, String month, int date, int time, int duration, String title) {
		this.user.setName(name);
		room = room.findRoom(capacity);
	}
	
	public static void reserve(String name, int capacity, int numWeeks, String month, int date, int time, int duration, String title) {
		Reservation reservation = new Reservation(name, capacity, numWeeks, month, date, time, duration, title);
		reservations.add(reservation);
	}
	
	/**
	 * Verify if the room is reserved at a specific time or not.
	 * @param room The room that needs to check its availability.
	 * @return True if the room is reserved for the time slot and
	 * False otherwise.
	 */
	public static boolean isRoomReserved(Room room) {
		
		return false;
	}
	
	private static LinkedList<Reservation> reservations = new LinkedList<Reservation>();
}
