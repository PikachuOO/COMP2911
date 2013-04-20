
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

	@Override
	public User getUser() {
		return super.getUser();
	}

	@Override
	public int getMonth() {
		return super.getMonth();
	}

	@Override
	public int getDate() {
		return super.getDate();
	}

	@Override
	public int getTime() {
		return super.getTime();
	}

	private String room;
}
