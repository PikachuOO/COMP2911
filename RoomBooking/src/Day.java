import java.util.LinkedList;


public class Day {
	private String month;
	private int date;
	
	private Day(String month, int date) {
		setMonth(month);
		setDate(date);
	}
	
	public static void addDays(String month, int date, int numWeeks) {
		for (int i = 0; i < DAYS_IN_WEEKS * numWeeks; i++) {
			Day day = new Day(month, date);
			days.add(day);
		}		
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	private static final LinkedList<Day> days = new LinkedList<Day>();
	private static final int DAYS_IN_WEEKS = 7;
}
