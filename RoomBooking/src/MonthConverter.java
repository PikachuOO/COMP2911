import java.text.DateFormatSymbols;
import java.util.Calendar;


public class MonthConverter {

	/**
	 * Convert the month input from the original input text file
	 * the the associated value using Calendar. This is used for
	 * easy month and date calculation.
	 * @param month The 'month' string from the original input text file.
	 * @return The value associated with the input 'month' string.
	 */
	public static int convertMonthToInt(String month) {
		int monthInNum = 0;
		if (month.equals("Jan"))
			monthInNum = Calendar.JANUARY;
		else if (month.equals("Feb"))
			monthInNum = Calendar.FEBRUARY;
		else if (month.equals("Mar"))
			monthInNum = Calendar.MARCH;
		else if (month.equals("Apr"))
			monthInNum = Calendar.APRIL;
		else if (month.equals("May"))
			monthInNum = Calendar.MAY;
		else if (month.equals("Jun"))
			monthInNum = Calendar.JUNE;
		else if (month.equals("Jul"))
			monthInNum = Calendar.JULY;
		else if (month.equals("Aug"))
			monthInNum = Calendar.AUGUST;
		else if (month.equals("Sep"))
			monthInNum = Calendar.SEPTEMBER;
		else if (month.equals("Oct"))
			monthInNum = Calendar.OCTOBER;
		else if (month.equals("Nov"))
			monthInNum = Calendar.NOVEMBER;
		else if (month.equals("Dec"))
			monthInNum = Calendar.DECEMBER;
		return monthInNum;
	}
	
	/**
	 * Given a value from the Calendar class, convert it into the
	 * name of the month in 3-letter convention. E.g. at parameter 
	 * equals Calendar.JANUARY, this method will return "Jan".
	 * @param month The integer that defines the value of a month.
	 * @return The string with the associated month value converted from
	 * Calendar.
	 */
	public static String convertMonthToString(int month) {
		return (new DateFormatSymbols().getShortMonths()[month]);
	}
}
