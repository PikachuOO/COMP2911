
public class RoomInputs {
	public RoomInputs(String[] params) {
		this.name = params[2];
		this.capacity = Integer.parseInt(params[1]);
	}
	
	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}

	private String name;
	private int capacity;
}
