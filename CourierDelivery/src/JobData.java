
public class JobData {
	public JobData(Coordinate c, boolean isJob) {
		this.point = c;
		this.isJob = isJob;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Coordinate getPoint() {
		return this.point;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public boolean isJob() {
		return this.isJob;
	}
	
	private Coordinate point;
	private int cost;
	private boolean isJob;
}
