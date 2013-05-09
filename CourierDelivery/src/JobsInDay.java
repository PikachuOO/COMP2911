import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 
 * @author Sandy
 *
 */
public class JobsInDay {

	/**
	 * Create a list of new jobs for the day.
	 */
	public JobsInDay() {
		jobs = new LinkedList<Job>();
	}
	
	/**
	 * Add a delivery job to the list of jobs
	 * of the day.
	 * @param from The coordinates in array of String
	 * for the starting point of the job.
	 * @param to The coordinates in array of String for
	 * the ending point of the job.
	 */
	public void addJob(int[] from, int[] to) {
		Job j = new Job(from, to);
		jobs.add(j);
	}
	
	/**
	 * Get the list of jobs in the day.
	 * @return A linked-list of jobs of the day.
	 */
	public LinkedList<Job> getJobs() {
		return this.jobs;
	}
	
	public void getJobPath() {
		JobData currentPoint = new JobData(home, false);
		currentPoint.setCost(0);
		Coordinate previousPostion = null;
		unvisitedJobs.add(currentPoint);
		
		while(unvisitedJobs.size() > 0) {
			currentPoint = unvisitedJobs.poll();
			
			if (visitedJobs.contains(currentPoint))
				continue;
			
			visitedJobs.add(currentPoint);
			totalCost += currentPoint.getCost();
			
			if (previousPostion != null)
				System.out.println("Move from " + previousPostion.getX() + 
					" " + previousPostion.getY() + " to " + currentPoint.getPoint().getX()
					+ " " + currentPoint.getPoint().getY());
			
			if (currentPoint.isJob()) {
				currentPoint = deliverJob(currentPoint.getPoint());
				unvisitedJobs.clear();
			}
			
			for (Job j : this.jobs) {
				if (alreadyVisited(j.getFrom()))
					continue;
				JobData jd = new JobData(j.getFrom(), true);
				int cost = Job.calculateDistance(currentPoint.getPoint(), jd.getPoint());
				jd.setCost(cost);
				unvisitedJobs.add(jd);
			}
			previousPostion = currentPoint.getPoint();
		}
		System.out.println("cost = " + totalCost);
		System.out.println(visitedJobs.size() + " nodes explored");
	}
	
	private JobData deliverJob(Coordinate from) {
		Coordinate to = null;
		for (Job j : this.jobs) {
			if (j.getFrom() == from) {
				to = j.getTo();
				totalCost += j.getDistance();
				break;
			}
		}
		
		JobData endPoint = new JobData(to, false);
		
		if (from.getX() != to.getX() ||
				from.getY() != to.getY())
			System.out.println("Carry from " + from.getX() + " " + from.getY()
					+ " to " + to.getX() + " " + to.getY());		
		
		return endPoint;
	}
	
	private boolean alreadyVisited(Coordinate c) {
		for(JobData jd : visitedJobs) {
			if (jd.getPoint() == c)
				return true;
		}
		return false;
	}
	
	private LinkedList<Job> jobs;
	private static final Coordinate home = new Coordinate(0, 0);
	private PriorityQueue<JobData> unvisitedJobs = new PriorityQueue<>(100, new Comparator<JobData>() {

		@Override
		public int compare(JobData o1, JobData o2) {
			if (o1.getCost() > o2.getCost())
				return 1;
			else if (o1.getCost() < o2.getCost())
				return -1;
			return 0;
		}
	});
	private LinkedList<JobData> visitedJobs = new LinkedList<JobData>();
	private int totalCost = 0;
}
