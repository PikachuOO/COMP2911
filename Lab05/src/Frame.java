import java.util.LinkedList;


public class Frame implements Part {
	public Frame() {
		doors.add(new Door());
		windows = new Window();
		fuelTank = new FuelTank();
		seats.add(new Seat());
		steeringWheel = new SteeringWheel();
		gearBox = new GearBox();
		mirrors = new Mirror();
	}
	
	public Frame(int doorNumber, int seatNumber) {
		for (int i = 0; i < doorNumber; i++) {
			doors.add(new Door());
		}
		windows = new Window();
		fuelTank = new FuelTank();
		for (int i = 0; i < seatNumber; i++) {
			seats.add(new Seat());
		}
		steeringWheel = new SteeringWheel();
		gearBox = new GearBox();
		mirrors = new Mirror();
	}

	@Override
	public int getWeight() {
		return ((doors.size() * doors.element().getWeight()) + (windows.getWeight() * 5) + fuelTank.getWeight()	+ 
				(seats.size() * seats.element().getWeight()) + steeringWheel.getWeight() + gearBox.getWeight() +
				(mirrors.getWeight() * 3));
	}
	
	private LinkedList<Door> doors = new LinkedList<Door>();
	private Window windows;
	private FuelTank fuelTank;
	private LinkedList<Seat> seats = new LinkedList<Seat>();
	private SteeringWheel steeringWheel;
	private GearBox gearBox;
	private Mirror mirrors;
}