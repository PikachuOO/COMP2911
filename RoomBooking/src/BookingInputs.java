
public class BookingInputs extends Inputs {

	
	public BookingInputs(String[] params) {
		super(params);
		this.capacity = Integer.parseInt(params[2]);
		this.duration = Integer.parseInt(params[7]);
		this.title = params[8];
	}
	
	public int getCapacity() {
		return capacity;
	}

	public int getDuration() {
		return duration;
	}

	public String getTitle() {
		return title;
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

	private int capacity;
	private int duration;
	private String title;
}
