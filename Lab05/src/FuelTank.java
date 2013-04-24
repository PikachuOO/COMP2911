
public class FuelTank implements Part {
	public FuelTank() {
		this.weight = 100;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
	private int weight;
}
