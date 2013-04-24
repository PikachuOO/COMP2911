
public class Chassis implements Part{
	
	public Chassis() {
		this.weight = 150;
		this.frame = new Frame();
		this.wheel = new Wheel();
	}
	
	public Chassis(int doorNumber, int wheelNumber, int seatNumber) {
		this.weight = 150;
		this.frame = new Frame(doorNumber, seatNumber);
		this.wheel = new Wheel();
	}

	@Override
	public int getWeight() {
		return frame.getWeight() + (wheel.getWeight() * 4) + this.weight;
	}

	private int weight;
	private Frame frame;
	private Wheel wheel;
}
