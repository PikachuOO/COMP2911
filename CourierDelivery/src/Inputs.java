
public class Inputs {

	public Inputs(String params[]) {
		if (Integer.parseInt(params[1]) < 0 ||
				Integer.parseInt(params[2]) < 0 ||
				Integer.parseInt(params[4]) < 0 ||
				Integer.parseInt(params[5]) < 0)
			throw new NumberFormatException("Invalid inputs.");
		this.from[0] = Integer.parseInt(params[1]);
		this.from[1] = Integer.parseInt(params[2]);
		this.to[0] = Integer.parseInt(params[4]);
		this.to[1] = Integer.parseInt(params[5]);
	}
	
	public int[] getFrom() {
		return this.from;
	}
	
	public int[] getTo() {
		return this.to;
	}
	
	private int[] from = new int[2];
	private int[] to = new int[2];
}
