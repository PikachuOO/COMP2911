
public class Inputs {
	
	public Inputs(String[] params) {
		this.user = new User(params[1]);
		this.numWeeks = Integer.parseInt(params[3]);
		this.month = MonthConverter.convertMonthToInt(params[4]);
		this.date = Integer.parseInt(params[5]);
		this.time = Integer.parseInt(params[6]);
	}
	
	public User getUser() {
		return this.user;
	}
	
	public int getNumWeeks() {
		return numWeeks;
	}

	public int getMonth() {
		return this.month;
	}
	
	public int getDate() {
		return this.date;
	}
	
	public int getTime() {
		return this.time;
	}
	
	private User user;
	private int numWeeks;
	private int month;
	private int date;
	private int time;
}
