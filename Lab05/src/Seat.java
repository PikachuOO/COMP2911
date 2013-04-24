
public class Seat implements Part {
	public Seat() {
		this.weight = 30;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
	private int weight;
}
