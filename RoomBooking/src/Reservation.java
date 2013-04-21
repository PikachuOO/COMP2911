import java.util.Calendar;


public class Reservation {

	/**
	 * Create a new reservation and assign all associate
	 * values accordingly.
	 * @param params The list of parameters/values.
	 */
	public static void createReservation(BookingInputs inputs, Room room) {
		User user = inputs.getUser();
		Reservation reservation = new Reservation(user, room, inputs.getTitle());
		
		if (HOURS_IN_DAY - inputs.getTime() < inputs.getDuration())
			System.out.println("No reservation for " + user.getName() +
					" for " + inputs.getCapacity() + " for " + inputs.getNumWeeks() +
					" weeks starting " + inputs.getMonth() + " " + inputs.getDate() +
					" at " + inputs.getTime() + " is done.");
		else
			for (int i = 0; i < inputs.getNumWeeks(); i++) {
				reservation.setReservationTime(inputs.getTime(), inputs.getDuration());
				reservation.setReservationDates(inputs.getMonth(), inputs.getDate(), i);
				reservation.room.addReservation(reservation);
				reservation = new Reservation(user, room, inputs.getTitle());
			}
	}
	
	/**
	 * Delete the reservation(s) specified by the list
	 * of parameters from the input file.
	 * @param params A list of values that specify the room
	 * of reservation, the time and date of reservation.
	 */
	public static boolean deleteReservation(DeleteInputs inputs, Room room) {
		Calendar tempDate = Calendar.getInstance();
		tempDate.set(Calendar.MONTH, inputs.getMonth());
		tempDate.set(Calendar.HOUR_OF_DAY, inputs.getTime());
		int date = inputs.getDate();
		boolean deleted = false;
		
		for (int i = 0; i < inputs.getNumWeeks(); i++) {
			int numDays = DAYS_IN_WEEKS * i;
			tempDate.set(Calendar.DATE, date + numDays);
			Reservation booking = room.findReservation(tempDate.get(Calendar.MONTH), 
					tempDate.get(Calendar.DATE), tempDate.get(Calendar.HOUR_OF_DAY));
			room.removeReservation(booking);
			deleted = true;
		}
		return deleted;		
	}
	
	/**
	 * Get the name of the person who made the reservation.
	 * @return A string that specifies the name of the user.
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * This method returns the start date of the
	 * reservation.
	 * @return An integer that specifies the date.
	 */
	public int getReservationDate() {
		return reservationDate.get(Calendar.DATE);
	}
	
	/**
	 * This method returns the start month of the reservation.
	 * @return An integer that specifies the month.
	 * Note that this function returns an integer where 'January'
	 *  is equal to 0, 'February' is equal to 1. Hence, it is recommended
	 *  to use the conversion method in MonthConverter.
	 */
	public int getReservationMonth() {
		return reservationDate.get(Calendar.MONTH);
	}
	
	/**
	 * Get the start time of the reservation.
	 * The time is in 24 hour mode.
	 * @return An integer that specifies the time.
	 */
	public int getReservationTime() {
		return startTime.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Get the end time of the reservation.
	 * The time is in 24 hour mode.
	 * @return An integer that specifies the time.
	 */
	public int getReservationEndTime() {
		return endTime.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Get the number of hours for the reservation.
	 * @return AN integer that specifies the number
	 * of hours in the reservation.
	 */
	public int getReservationDuration() {
		if (endTime.get(Calendar.HOUR_OF_DAY) == 0)
			return HOURS_IN_DAY - startTime.get(Calendar.HOUR_OF_DAY);
		return endTime.get(Calendar.HOUR_OF_DAY) - startTime.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Get the title of the reservation
	 * @return A string of the name of the reservation
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Create a new reservation object with the name of the person
	 * who books for the room, the number of people the reservation is
	 * for the the title of the reservation.
	 * @param user The user who books for the reservation.
	 * @param capacity The number of people the reservation is need for.
	 * This is needed to look for a room with the correct capacity.
	 * @param title The title of the reservation.
	 */
	private Reservation(User user, Room room, String title) {
		setUser(user);
		this.room = room;
		setTitle(title);
	}

	/**
	 * Set the user the the reservation.
	 * @param user Name of the user booking the room.
	 */
	private void setUser(User user) {
		this.user = user;
	}

	/**
	 * Set the dates of reservation for the duration.
	 * @param month An integer that specifies the month of the year.
	 * @param date An integer that specifies the date of the month.
	 * @param numWeeks An integer that specifies the number of weeks
	 * the reservation will be going for.
	 */
	private void setReservationDates(int month, int date, int n) {
		this.reservationDate = Calendar.getInstance();
		int numDays = DAYS_IN_WEEKS * n;
		this.reservationDate.set(Calendar.MONTH, month);
		this.reservationDate.set(Calendar.DATE, date + numDays);
	}
	
	/**
	 * Set the time of reservation.
	 * @param time An integer that specifies the start time of the reservation.
	 * @param duration An integer that specifies the number of hours.
	 */
	private void setReservationTime(int time, int duration) {
		this.startTime = Calendar.getInstance();
		this.startTime.set(Calendar.HOUR_OF_DAY, time);
		this.endTime = Calendar.getInstance();
		this.endTime.set(Calendar.HOUR_OF_DAY, startTime.get(Calendar.HOUR_OF_DAY) + duration);
	}
	
	/**
	 * Set the title of the reservation
	 * @param title A string that defines the name of
	 * the reservation.
	 */
	private void setTitle(String title) {
		this.title = title;
	}
	
	private static final int DAYS_IN_WEEKS = 7;
	private static final int HOURS_IN_DAY = 24;
	private String title;
	private Calendar reservationDate;
	private Calendar startTime, endTime;
	private User user;
	private Room room;
}
