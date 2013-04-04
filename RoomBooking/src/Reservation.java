import java.util.Calendar;


public class Reservation {

	private static final int DAYS_IN_WEEKS = 7;
	private String title;
	private Calendar startDate, endDate;
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
//		if (params.length != 9)
//			throw new Exception("Not enough information was given");
//		else {
			User user = new User(params[1]);
			Reservation reservation = new Reservation(user, Integer.parseInt(params[2]), params[8]);
			reservation.setReservationDates(params[4], Integer.parseInt(params[5]), Integer.parseInt(params[3]));
			reservation.setReservationTime(Integer.parseInt(params[6]), Integer.parseInt(params[7]));
			
			if (!reservation.room.containReservation(reservation))
				reservation.room.addReservation(reservation);
			
			System.out.println(reservation.room.getRoomName() + " is reserved for " +
							   reservation.user.getName() + " at " +
							   reservation.getReservationTime() + " for " +
							   reservation.getReservationDuration() + " hours starting from " +
							   MonthConverter.convertMonthToString(reservation.getReservationMonth()) + " " +
							   reservation.getReservationDate() + ".");
			
//			if (reservation.room.containReservation(reservation)) {
//				throw new Exception("Reservation exists. No reservation was done");
//			} else {
//				reservation.room.addReservation(reservation);
//			}
//		}
	}

	/**
	 * Set the dates of reservation for the duration.
	 * @param month An integer that specifies the month of the year.
	 * @param date An integer that specifies the date of the month.
	 * @param numWeeks An integer that specifies the number of weeks
	 * the reservation will be going for.
	 */
	private void setReservationDates(String month, int date, int numWeeks) {
		this.startDate = Calendar.getInstance();
		this.startDate.set(Calendar.MONTH, MonthConverter.convertMonthToInt(month));
		this.startDate.set(Calendar.DATE, date);
		int numberOfDays = DAYS_IN_WEEKS * numWeeks - 1;;
		this.endDate = Calendar.getInstance();
		this.endDate.set(Calendar.MONTH, startDate.get(Calendar.MONTH));
		this.endDate.set(Calendar.DATE, startDate.get(Calendar.DATE));
		this.endDate.add(Calendar.DATE, numberOfDays);
	}
	
	/**
	 * This method returns the start date of the
	 * reservation.
	 * @return An integer that specifies the date.
	 */
	public int getReservationDate() {
		return startDate.get(Calendar.DATE);
	}
	
	/**
	 * This method returns the start month of the reservation.
	 * @return An integer that specifies the month.
	 * Note that this function returns an integer where 'January'
	 *  is equal to 0, 'February' is equal to 1. Hence, it is recommended
	 *  to use the conversion method in MonthConverter.
	 */
	public int getReservationMonth() {
		return startDate.get(Calendar.MONTH);
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
