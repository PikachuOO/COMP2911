import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;


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
		int numberOfDays = DAYS_IN_WEEKS * numWeeks;
		this.endDate = startDate;
		this.endDate.add(Calendar.DATE, numberOfDays);
	}
	
	/**
	 * Set the time of reservation.
	 * @param time An integer that specifies the start time of the reservation.
	 * @param duration An integer that specifies the number of hours.
	 */
	public void setReservationTime(int time, int duration) {
		this.startTime = Calendar.getInstance();
		this.startTime.set(Calendar.HOUR_OF_DAY, time);
		this.endTime.set(Calendar.HOUR_OF_DAY, startTime.get(Calendar.HOUR_OF_DAY) + duration);
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
		this.room = Room.findRoom(capacity);
	}
}
