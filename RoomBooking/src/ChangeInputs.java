
public class ChangeInputs extends Inputs {

	public ChangeInputs(String[] params) {
		super(params);
		this.room = params[2];
		this.newCapacity = Integer.parseInt(params[7]);
		this.newMonth = MonthConverter.convertMonthToInt(params[8]);
		this.newDate = Integer.parseInt(params[9]);
		this.newTime = Integer.parseInt(params[10]);
		this.newDuration = Integer.parseInt(params[11]);
		this.newTitle = params[12];
	}
	
	public String getRoom() {
		return room;
	}
	
	public int getNewCapacity() {
		return newCapacity;
	}

	public int getNewMonth() {
		return newMonth;
	}

	public int getNewDate() {
		return newDate;
	}

	public int getNewTime() {
		return newTime;
	}

	public int getNewDuration() {
		return newDuration;
	}

	public String getNewTitle() {
		return newTitle;
	}
	
	@Override
	public User getUser() {
		return super.getUser();
	}
	
	@Override
	public int getMonth() {
		return super.getMonth();
	}
	
	@Override
	public int getDate() {
		return super.getDate();
	}
	
	@Override
	public int getTime() {
		return super.getTime();
	}

	private String room;
	private int newCapacity;
	private int newMonth;
	private int newDate;
	private int newTime;
	private int newDuration;
	private String newTitle;
}
