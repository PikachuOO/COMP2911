import java.util.Calendar;


public class Reservation {

	private static final int DAYS_IN_WEEKS = 7;
	private String title;
	private Calendar reservationDate;
	private Calendar startTime, endTime;
	private User user;
	private Room room;
		
	private Reservation(User user, int capacity, String title) {
		setUser(user);
		setRoom(capacity);
		setTitle(title);
	}

	/**
	 * Get the name of the person who made the reservation.
	 * @return A string that specifies the name of the user.
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Set the user the the reservation.
	 * @param user Name of the user booking the room.
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Create a new reservation and assign all associate
	 * values accordingly.
	 * @param params The list of parameters/values.
	 * @return
	 * @throws Exception
	 */
	public static void createReservation(String[] params) {
		User user = new User(params[1]);
		
		for (int i = 0; i < Integer.parseInt(params[3]); i++) {
			Reservation reservation = new Reservation(user, Integer.parseInt(params[2]), params[8]);
			reservation.setReservationTime(Integer.parseInt(params[6]), Integer.parseInt(params[7]));
			reservation.setReservationDates(params[4], Integer.parseInt(params[5]), i);
			if (!reservation.room.containReservation(reservation))
				reservation.room.addReservation(reservation);
			else
				System.out.println("Time slot reserved. No reservation was made.");
		}
	}

	/**
	 * Set the dates of reservation for the duration.
	 * @param month An integer that specifies the month of the year.
	 * @param date An integer that specifies the date of the month.
	 * @param numWeeks An integer that specifies the number of weeks
	 * the reservation will be going for.
	 */
	private void setReservationDates(String month, int date, int n) {
		this.reservationDate = Calendar.getInstance();
		int numDays = DAYS_IN_WEEKS * n;
		this.reservationDate.set(Calendar.MONTH, MonthConverter.convertMonthToInt(month));
		this.reservationDate.set(Calendar.DATE, date + numDays);
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
	 * Set the time of reservation.
	 * @param time An integer that specifies the start time of the reservation.
	 * @param duration An integer that specifies the number of hours.
	 */
	public void setReservationTime(int time, int duration) {
		this.startTime = Calendar.getInstance();
		this.startTime.set(Calendar.HOUR_OF_DAY, time);
		this.endTime = Calendar.getInstance();
		this.endTime.set(Calendar.HOUR_OF_DAY, startTime.get(Calendar.HOUR_OF_DAY) + duration);
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
	 * Get the number of hours for the reservation.
	 * @return AN integer that specifies the number
	 * of hours in the reservation.
	 */
	public int getReservationDuration() {
		return endTime.get(Calendar.HOUR_OF_DAY) - startTime.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Set the title of the reservation
	 * @param title A string that defines the name of
	 * the reservation.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Get the title of the reservation
	 * @return A string of the name of the reservation
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Get the room with a fitting capacity.
	 * @param capacity An integer that specifies the number of
	 * people have to store.
	 */
	public void setRoom(int capacity) {
		this.room = Room.findRoomByCapacity(capacity);
	}
}
