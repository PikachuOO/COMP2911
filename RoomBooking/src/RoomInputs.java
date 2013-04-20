
public class RoomInputs {
	
	/**
	 * Accept a list of parameters to create a room.
	 * @param params A list of room.
	 */
	public RoomInputs(String[] params) {
		this.name = params[2];
		this.capacity = Integer.parseInt(params[1]);
	}
	
	/**
	 * Get the name of the room in the input.
	 * @return A string that specifies the name of the room.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the capacity of the room in the input.
	 * @return An ingeger that specifies the capacity
	 * of the room.
	 */
	public int getCapacity() {
		return capacity;
	}

	private String name;
	private int capacity;
}
