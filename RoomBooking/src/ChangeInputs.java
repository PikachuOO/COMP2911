
public class ChangeInputs extends Inputs {

	/**
	 * Create an input instance for reservation modification.
	 * Accept a list of parameters that are needed
	 * to make a change in reservations.
	 * @param params A string array of all values needed.
	 */
	public ChangeInputs(String[] params) {
		super(params);
		this.room = params[2];
		this.newCapacity = Integer.parseInt(params[7]);
		this.newMonth = MonthConverter.convertMonthToInt(params[8]);
		this.newDate = Integer.parseInt(params[9]);
		this.newTime = Integer.parseInt(params[10]);
		this.newDuration = Integer.parseInt(params[11]);
		this.newTitle = params[12];
	}
	
	/**
	 * Get the name of the room in the current input.
	 * @return A String that specifies the name of the room.
	 */
	public String getRoom() {
		return room;
	}
	
	/**
	 * Get the new capacity to be assigned to the change in
	 * reservation.
	 * @return An integer that specifies the new capacity needed.
	 */
	public int getNewCapacity() {
		return newCapacity;
	}

	/**
	 * Get the new month that is to be assigned to the change
	 * in reservation.
	 * @return An integer that specifies the new month of the
	 * reservation.
	 */
	public int getNewMonth() {
		return newMonth;
	}

	/**
	 * Get the new date that is to be assigned to the change
	 * in reservation.
	 * @return An integer that specifies the new date of the
	 * reservation.
	 */
	public int getNewDate() {
		return newDate;
	}

	/**
	 * Get the new time that is to be assigned to the change
	 * in reservation.
	 * @return An integer that specifies the new time of 
	 * the reservation.
	 */
	public int getNewTime() {
		return newTime;
	}

	/**
	 * Get the new duration that is to be assigned to the change
	 * in reservation.
	 * @return An integer that specifies the new duration of 
	 * the reservation.
	 */
	public int getNewDuration() {
		return newDuration;
	}

	/**
	 * Get the new title that is to be assigned to the change
	 * in reservation.
	 * @return A string that specifies the new title of the
	 * reservation.
	 */
	public String getNewTitle() {
		return newTitle;
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
	private int newCapacity;
	private int newMonth;
	private int newDate;
	private int newTime;
	private int newDuration;
	private String newTitle;
}
