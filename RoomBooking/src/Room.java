import java.util.Iterator;
import java.util.LinkedList;


public class Room {
	
	/**
	 * Create a room object and add room into the list of rooms.
	 * @param capacity An integer that specifies the number of people 
	 * it can store.
	 * @param name A String that specifies the name of the room.
	 * @throws Exception Exception throws when the room already exists.
	 */
	public static void createRoom(int capacity, String name) throws Exception {
		Room room = new Room(capacity, name);
		if(!Room.containRoom(room))
			rooms.add(room);
		else
			throw new Exception("Room has been added");
		System.out.println("Room " + name + " assigned");
		System.out.println(rooms.size() + " rooms have been assigned.");
	}
	
	public void addReservation(Reservation reservation) {
		getReservations().add(reservation);
	}
	
	public void removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
	}
	
	public LinkedList<Reservation> getReservations() {
		return this.reservations;
	}
	
	/**
	 * Get capacity of the current room object.
	 * @return An integer that defines the capacity of the room.
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Get the name of the current room object.
	 * @return A String - The name of the room.
	 */
	public String getRoomName() {
		return this.roomName;
	}
	
	/**
	 * Check if a room already exists in terms of it's name.
	 * @param room The room to be checked.
	 * @return True if the room already exists and False otherwise.
	 */
	public static boolean containRoom(Room room) {
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext())
			if(iterator.next().getRoomName().equals(room.getRoomName()))
				return true;
		return false;
	}
	
	/**
	 * This method verifies if a given reservation exists
	 * for the room assigned.
	 * @param reservation The reservation slot that is needed
	 * to verify.
	 * @return True if the room has been booked out for the given
	 * reservation slot, False otherwise.
	 */
	public boolean containReservation(Reservation reservation) {
		// Only checks for the date and time of the reservation.
		// As it does not really matter who booked the time slot or
		// what the time slot was booked for. So is the duration as
		// the start time of the slot tells us an overlap occurs.
		// Use 'AND' because all these have to be the same
		// for the time slot to be booked away, else the time slot
		// is available.
		for (Reservation booking : this.getReservations()) {
			if (booking.getReservationMonth() == reservation.getReservationMonth() &&
				booking.getReservationDate() == reservation.getReservationDate() &&
				booking.getReservationTime() == reservation.getReservationTime()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Find the reservation from the list of reservations
	 * of the room that calls the function.
	 * @param user A string that specifies the name of
	 * the user who booked the time slot.
	 * @param month An integer that specifies the month of
	 * the reservation.
	 * @param date An integer that specifies the date of
	 * the reservation.
	 * @param time An integer that specifies the start time of
	 * the reservation.
	 * @return The reservation with the matching values.
	 */
	public Reservation findReservation(User user, int month, int date, int time) {
		for (Reservation booking : this.getReservations()) {
			if (booking.getUser().getName().equals(user.getName()) &&
				booking.getReservationMonth() == month &&
				booking.getReservationDate() == date &&
				booking.getReservationTime() == time)
				return booking;		
		}
		return null;
	}
	
	/**
	 * Find a room with a matching capacity.
	 * @param capacity An integer that defines the number of people
	 * it can store.
	 * @return The room that matches the requirement.
	 */
	public static Room findRoomByCapacity(int capacity) {
		for (Room r : rooms) {
			if (r.capacity >= capacity)
				return r;
		}
		return null;
	}
	
	/**
	 * Find a room with a matching name.
	 * @param roomName A string that defines the name of the room.
	 * @return The room with the matching name.
	 */
	public static Room findRoomByName(String roomName) {
		for (Room r : rooms) {
			if (r.roomName.equals(roomName))
				return r;
		}
		return null;
	}
	
	/**
	 * Print all the existing reservation for a give room name.
	 * This method prints the user of the reservation, the month and date
	 * when the reservation starts, and the time and number of hours
	 * the reservation lasts for.
	 * @param name A string that specifies the name of the room
	 * for which its reservations are to be printed.
	 */
	public static void printReservations(String name) {
		Room room = findRoomByName(name);
		if (room != null) {
			for (Reservation booking : room.getReservations()) {
				System.out.print(booking.getUser().getName() + " ");
				System.out.print(MonthConverter.convertMonthToString(booking.getReservationMonth()) + " ");
				System.out.print(booking.getReservationDate() + " ");
				System.out.print(booking.getReservationTime() + " ");
				System.out.print(booking.getReservationDuration() + " ");
				System.out.println(booking.getTitle());
			}
		}
	}
	
	/**
	 * Construct a Room object with it's name and capacity specified.
	 * @param capacity the number of people a room can store.
	 * @param name the name of the room.
	 */
	private Room(int capacity, String name) {
		setCapacity(capacity);
		setRoomName(name);
		reservations = new LinkedList<Reservation>();
	}
	
	/**
	 * Set capacity of the current room object.
	 * @param capacity An integer that defines the capacity to be
	 * set to the room.
	 */
	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Set name of the room.
	 * @param roomName an input String as the name of the room
	 * to be set.
	 */
	private void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	private int capacity;
	private String roomName;
	private LinkedList<Reservation> reservations;

	private static final LinkedList<Room> rooms = new LinkedList<Room>();
}
