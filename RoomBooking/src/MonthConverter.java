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
		case 0:
			monthInString = "Jan";
			break;
		case 1:
			monthInString = "Feb";
			break;
		case 2:
			monthInString = "Mar";
			break;
		case 3:
			monthInString = "Apr";
			break;
		case 4:
			monthInString = "May";
			break;
		case 5:
			monthInString = "June";
			break;
		case 6:
			monthInString = "July";
			break;
		case 7:
			monthInString = "Aug";
			break;
		case 8:
			monthInString = "Sep";
			break;
		case 9:
			monthInString = "Oct";
			break;
		case 10:
			monthInString = "Nov";
			break;
		case 11:
			monthInString = "Dec";
			break;
		}
		return monthInString;
	}
}
