
public class Inputs {
	
	public Inputs(String[] params) {
		this.user = new User(params[1]);
		this.numWeeks = Integer.parseInt(params[3]);
		this.month = MonthConverter.convertMonthToInt(params[4]);
		this.date = Integer.parseInt(params[5]);
		this.time = Integer.parseInt(params[6]);
	}
	
	/**
	 * Get the User object of the current input.
	 * @return A User object.
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Get the number of weeks in the current input.
	 * @return An integer that specifies the number of weeks
	 * in the input.
	 */
	public int getNumWeeks() {
		return numWeeks;
	}

	/**
	 * Get the month value in the current input.
	 * @return An integer that specifies the month value.
	 */
	public int getMonth() {
		return this.month;
	}
	
	/**
	 * Get the date value in the current input.
	 * @return An integer that specifies the date value.
	 */
	public int getDate() {
		return this.date;
	}
	
	/**
	 * Get the time value in the current input.
	 * @return An integer that specifies the time value.
	 */
	public int getTime() {
		return this.time;
	}
	
	private User user;
	private int numWeeks;
	private int month;
	private int date;
	private int time;
}
