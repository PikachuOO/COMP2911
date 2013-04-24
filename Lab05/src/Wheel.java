
public class Wheel implements Part {
	
	public Wheel() {
		this.weight = 40;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
	private int weight;
}
