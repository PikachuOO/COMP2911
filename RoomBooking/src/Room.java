import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Room {
	
	/**
	 * Create a room object and add room into the list of rooms.
	 * @param capacity An integer that specifies the number of people 
	 * it can store.
	 * @param name A String that specifies the name of the room.
	 * @throws Exception Exception throws when the room already exists.
	 */
	public static void createRoom(RoomInputs inputs, File output) {
		Room room = new Room(inputs.getCapacity(), inputs.getName());
		if(!Room.containRoom(room))
			rooms.add(room);
		System.out.println("Room " + room.getRoomName() + " assigned");
//		Printer.writeToFile("Room " + room.getRoomName() + " assigned", output);
	}
	
	/**
	 * Add a new reservation to the list of reservations of the room.
	 * @param reservation A reservation with all values set.
	 */
	public void addReservation(Reservation reservation) {
		getReservations().add(reservation);
	}
	
	/**
	 * Remove a given reservation in the list of reservations of the room
	 * that invoked the method.
	 * @param reservation The reservation that will be deleted.
	 */
	public void removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
	}
	
	/**
	 * This method gets the list of all existing reservations
	 * in the room that invoked this method.
	 * @return A linked list of reservations for the room.
	 */
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
	public Reservation findReservation(int month, int date, int time) {
		for (Reservation booking : this.getReservations()) {
 			if (booking.getReservationMonth() == month &&
				booking.getReservationDate() == date &&
				(booking.getReservationEndTime() > time ||
				booking.getReservationTime() == time))				
				return booking;
		}
		return null;
	}
	
	
	public boolean foundReservations(int month, int date, int time, int duration) {
		boolean state = false;
		Calendar tempDate = Calendar.getInstance();
		for (int i = 0; i < duration; i++) {
			int numDays = 7 * i;
			tempDate.set(Calendar.MONTH, month);
			tempDate.set(Calendar.DATE, date + numDays);
			if (this.findReservation(tempDate.get(Calendar.MONTH), tempDate.get(Calendar.DATE), time) != null)
				state = true;
		}
		return state;
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
	 * Return the list of all the rooms in the system.
	 * @return A list of all the rooms.
	 */
	public static List<Room> getAllRooms() {
		return Collections.unmodifiableList(rooms);
	}
	
	/**
	 * Print all the existing reservation for a give room name.
	 * This method prints the user of the reservation, the month and date
	 * when the reservation starts, and the time and number of hours
	 * the reservation lasts for.
	 * @param name A string that specifies the name of the room
	 * for which its reservations are to be printed.
	 */
	public static void printReservations(String name, File output) {
		Room room = findRoomByName(name);
		if (room != null) {
			for (Reservation booking : room.getReservations()) {
				System.out.println(booking.getUser().getName() + " " +
						MonthConverter.convertMonthToString(booking.getReservationMonth()) + 
						" " + booking.getReservationDate() + " " +
						booking.getReservationTime() + " " +
						booking.getReservationDuration() + " " +
						booking.getTitle());
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
