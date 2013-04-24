
public class Car implements Part {
	
	public Car() {
		this.chassis = new Chassis();
		this.engine = new Engine();
	}
	
	public Car(int doorNumber, int wheelNumber, int seatNumber) {
		this.chassis = new Chassis(doorNumber, wheelNumber, seatNumber);
		this.engine = new Engine();
	}

	@Override
	public int getWeight() {
		return chassis.getWeight() + engine.getWeight();
	}

	private Chassis chassis;
	private Engine engine;
}
