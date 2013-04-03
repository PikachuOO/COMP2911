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
		
	public Reservation(User user, int capacity, String title) {
		setUser(user);
		setRoom(capacity);
		setTitle(title);
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Set the dates of reservation for the duration.
	 * @param month An integer that specifies the month of the year.
	 * @param date An integer that specifies the date of the month.
	 * @param numWeeks An integer that specifies the number of weeks
	 * the reservation will be going for.
	 */
	public void setReservationDates(String month, int date, int numWeeks) {
		this.startDate = Calendar.getInstance();
		this.startDate.set(Calendar.MONTH, convertMonth(month));
		this.startDate.set(Calendar.DATE, date);
		int numberOfDays = DAYS_IN_WEEKS * numWeeks;
		this.endDate = startDate;
		this.endDate.add(Calendar.DATE, numberOfDays);
	}
	
	private int convertMonth(String month) {
		int monthInNum = 0;
		switch (month) {
		case "Jan":
			monthInNum = Calendar.JANUARY;
			break;
		case "Feb":
			monthInNum = Calendar.FEBRUARY;
			break;
		case "Mar":
			monthInNum = Calendar.MARCH;
			break;
		case "Apr":
			monthInNum = Calendar.APRIL;
			break;
		case "May":
			monthInNum = Calendar.MAY;
			break;
		case "Jun":
			monthInNum = Calendar.JUNE;
			break;
		case "Jul":
			monthInNum = Calendar.JULY;
			break;
		case "Aug":
			monthInNum = Calendar.AUGUST;
			break;
		case "Sep":
			monthInNum = Calendar.SEPTEMBER;
			break;
		case "Oct":
			monthInNum = Calendar.OCTOBER;
			break;
		case "Nov":
			monthInNum = Calendar.NOVEMBER;
			break;
		case "Dec":
			monthInNum = Calendar.DECEMBER;
			break;
		}
		return monthInNum;
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
		this.room = room.findRoom(capacity);
	}
}
