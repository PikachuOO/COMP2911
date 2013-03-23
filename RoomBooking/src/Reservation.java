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
	
	public Reservation() {
		
	}
	
	/**
	 * Set the dates of reservation for the duration.
	 * @param month An integer that specifies the month of the year.
	 * @param date An integer that specifies the date of the month.
	 * @param numWeeks An integer that specifies the number of weeks
	 * the reservation will be going for.
	 */
	public void setReservationDates(int month, int date, int numWeeks) {
		this.startDate = Calendar.getInstance();
		this.startDate.set(Calendar.MONTH, month);
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
	
	public void setRoom(int capacity) {
		this.room = room.findRoom(capacity);
	}
	/**
	 * Verify if the room is reserved at a specific time or not.
	 * @param room The room that needs to check its availability.
	 * @return True if the room is reserved for the time slot and
	 * False otherwise.
	 */
	public static boolean isRoomReserved(Room room) {
		
		return false;
	}
}
