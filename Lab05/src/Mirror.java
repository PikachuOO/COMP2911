
public class Mirror implements Part{
	public Mirror() {
		this.weight = 10;
	}

	@Override
	public int getWeight() {
		return this.weight;
	}
	
	private int weight;
}
