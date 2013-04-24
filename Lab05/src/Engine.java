
public class Engine implements Part {
	
	public Engine() {
		weight = 200;
	}
	
	@Override
	public int getWeight() {
		return this.weight;
	}
	
	private int weight;
}
