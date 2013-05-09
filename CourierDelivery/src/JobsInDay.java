import java.util.LinkedList;

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
	public void addJob(String from[], String to[]) {
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
		
	}
	
	private LinkedList<Job> jobs;
}
