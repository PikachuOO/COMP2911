
public class BookingInputs extends Inputs {

	/**
	 * Create a new input instance specific for booking.
	 * Accepts a string array of values needed to make a
	 * booking.
	 * @param params A string array of values needed to make a
	 * booking
	 */
	public BookingInputs(String[] params) {
		super(params);
		this.capacity = Integer.parseInt(params[2]);
		this.duration = Integer.parseInt(params[7]);
		this.title = params[8];
	}
	
	/**
	 * Get the capacity needed for the room in the current
	 * inpupt.
	 * @return An integer that specifies the capacity.
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Get the duration of the reservation in the current
	 * input.
	 * @return An integer that specifies the duration of
	 * the reservation.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Get the title of the reservation in the current input
	 * @return A String that specifies the title of the 
	 * reservation.
	 */
	public String getTitle() {
		return title;
	}

	private int capacity;
	private int duration;
	private String title;
}
