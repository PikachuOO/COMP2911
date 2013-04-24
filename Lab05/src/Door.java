
public class Door implements Part {
	
	public Door() {
		this.weight = 30;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}

	private int weight;
}
