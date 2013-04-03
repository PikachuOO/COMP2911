import java.util.Iterator;
import java.util.LinkedList;


public class Room {
	private int capacity;
	private String roomName;
	private LinkedList<Reservation> reservations;
	
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
	
	public void addReservation(Reservation reservation) {
//		reservations.add(reservation);
	}
	
	/**
	 * Get capacity of the current room object.
	 * @return An integer that defines the capacity of the room.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Set capacity of the current room object.
	 * @param capacity An integer that defines the capacity to be
	 * set to the room.
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Set name of the room.
	 * @param roomName an input String as the name of the room
	 * to be set.
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

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
	
	public static boolean containReservation(Reservation reservation) {
		
		
		return false;
	}
	
	/**
	 * Find a room with a matching capacity.
	 * @param capacity An integer that defines the number of people
	 * it can store.
	 * @return The room that matches the requirement.
	 */
	public Room findRoom(int capacity) {
		Iterator<Room> iterator = rooms.iterator();
		while (iterator.hasNext())
			if (iterator.next().getCapacity() >= capacity)
				return iterator.next();
		return null;
	}

	private static final LinkedList<Room> rooms = new LinkedList<Room>();
}
