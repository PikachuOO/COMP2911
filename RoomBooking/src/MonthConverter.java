import java.util.Calendar;


public class MonthConverter {

	public static int convertMonthToInt(String month) {
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
	
	public static String convertMonthToString(int month) {
		String monthInString = "";
		switch (month) {
		case 1:
			monthInString = "Jan";
			break;
		case 2:
			monthInString = "Feb";
			break;
		case 3:
			monthInString = "Mar";
			break;
		case 4:
			monthInString = "Apr";
			break;
		case 5:
			monthInString = "May";
			break;
		case 6:
			monthInString = "June";
			break;
		case 7:
			monthInString = "July";
			break;
		case 8:
			monthInString = "Aug";
			break;
		case 9:
			monthInString = "Sep";
			break;
		case 10:
			monthInString = "Oct";
			break;
		case 11:
			monthInString = "Nov";
			break;
		case 12:
			monthInString = "Dec";
			break;
		}
		return monthInString;
	}
}
