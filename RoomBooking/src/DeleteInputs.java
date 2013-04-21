
public class DeleteInputs extends Inputs {

	/**
	 * An array of all parameters needed to delete
	 * a reservation.
	 * @param params Array of params of the values needed.
	 */
	public DeleteInputs(String[] params) {
		super(params);
		this.room = params[2];
	}
	
	/**
	 * Get the room name in the current input.
	 * @return A string that specifies the name
	 * of the room.
	 */
	public String getRoom() {
		return room;
	}

	private String room;
}
