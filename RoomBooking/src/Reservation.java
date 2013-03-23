import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;


public class Reservation {

	private static final int DAYS_IN_WEEKS = 7;
	private String title;
	private Date start;
	private Date end;
	private Calendar startDate;
	private Calendar endDate;
	private User user;
	private Room room;
	
	public Reservation(String userName, int capacity, int numWeeks, String month, int date, int time, int duration, String title) {
	}
	
	public void setDates(int month, int date, int numWeeks) {
		startDate = Calendar.getInstance();
		startDate.set(Calendar.MONTH, month);
		startDate.set(Calendar.DATE, date);
		int numberOfDays = DAYS_IN_WEEKS * numWeeks;
		endDate = startDate;
		endDate.add(Calendar.DATE, numberOfDays);		
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
