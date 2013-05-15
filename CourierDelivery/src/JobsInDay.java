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
		Job start = new Job(home, home);
		JobData currentPoint = new JobData(start, false);
		currentPoint.setCost(0);
		Coordinate previousPostion = null;
		unvisitedJobs.add(currentPoint);
		
		while(unvisitedJobs.size() > 0) {
			currentPoint = unvisitedJobs.poll();
			
			if (visitedJobs.contains(currentPoint))
				continue;
			
			visitedJobs.add(currentPoint);
			totalCost += currentPoint.getCost() - currentPoint.getHeuristic();
			
//			if (previousPostion != null)
//				System.out.println("Move from " + previousPostion.getX() + 
//					" " + previousPostion.getY() + " to " + currentPoint.getPoint().getX()
//					+ " " + currentPoint.getPoint().getY());
			
			if (currentPoint.isJob()) {
				currentPoint = deliverJob(currentPoint.getJob());
				unvisitedJobs.clear();
			}
			
			for (Job j : this.jobs) {
				if (alreadyVisited(j))
					continue;
				JobData jd = new JobData(j, true);
				double cost = Job.calculateDistance(currentPoint.getJob().getFrom(), jd.getJob().getFrom());
				jd.setHeuristic(Job.calculateHeuristic(currentPoint.getJob().getFrom(), jd.getJob().getTo()));
				jd.setCost(cost + jd.getHeuristic());
				unvisitedJobs.add(jd);
			}
			previousPostion = currentPoint.getJob().getFrom();
		}
		System.out.println("cost = " + totalCost);
		System.out.println(visitedJobs.size() + " nodes explored");
	}
	
	private JobData deliverJob(Job j) {
		int[] arr = {j.getTo().getX(), j.getTo().getY()};
		Job to = new Job(arr, arr);
		JobData endPoint = new JobData(to, false);
		totalCost += j.getDistance();
		
//		if (j.getFrom().getX() != j.getTo().getX() ||
//				j.getFrom().getY() != j.getFrom().getY())
			System.out.println("Carry from " + j.getFrom().getX() + " " + j.getFrom().getY()
					+ " to " + j.getTo().getX() + " " + j.getTo().getY());		
		
		return endPoint;
	}
	
	private boolean alreadyVisited(Job j) {
		for(JobData jd : visitedJobs) {
			if (jd.getJob() == j)
				return true;
		}
		return false;
	}
	
	private LinkedList<Job> jobs;
	private static final int[] home = {0, 0};
	private PriorityQueue<JobData> unvisitedJobs = new PriorityQueue<JobData>(100, new Comparator<JobData>() {

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
