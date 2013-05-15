
public class JobData {
	public JobData(Job j, boolean isJob) {
		this.job = j;
		this.isJob = isJob;
	}
	
	public void setCost(double cost2) {
		this.cost = cost2;
	}
	
	public void setHeuristic(double h) {
		this.heuristic = h;
	}
	
	public Job getJob() {
		return this.job;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public boolean isJob() {
		return this.isJob;
	}
	
	public double getHeuristic() {
		return this.heuristic;
	}
	
	private Job job;
	private double heuristic;
	private double cost;
	private boolean isJob;
}
