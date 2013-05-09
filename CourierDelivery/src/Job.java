
/**
 * This class stores the start and end point
 * of a job as well as the distance (cost)
 * between them.
 * @author Sandy
 *
 */
public class Job {
	
	/**
	 * Create a new job with the predefined
	 * coordinate points.
	 * @param from A set of (x,y) point for the starting
	 * point of the job.
	 * @param to A set of (x,y) point for the ending
	 * pint of the job.
	 */
	public Job(String from[], String to[]) {
		this.from = new Coordinate(Integer.parseInt(from[0]), Integer.parseInt(from[1]));
		this.to = new Coordinate(Integer.parseInt(to[0]), Integer.parseInt(to[1]));
		this.distance = calculateDistance(this.from, this.to);
	}
	
	/**
	 * Get the starting point of the job in (x,y).
	 * @return A set of coordinate point.
	 */
	public Coordinate getFrom() {
		return from;
	}
	
	/**
	 * Get the ending point of the job in (x,y).
	 * @return A set of coordinate point.
	 */
	public Coordinate getTo() {
		return to;
	}
	
	/**
	 * Get the distance of a job.
	 * @return Return the distance of the job.
	 */
	public int getDistance() {
		return this.distance;
	}
	
	/**
	 * Calculate the distance between 2 points.
	 * @param from The coordinate point of the starting point.
	 * @param to The coordinate point of the ending point.
	 * @return Return the distance between the 2 points in integer.
	 */
	public static int calculateDistance(Coordinate from, Coordinate to) {
		return (Math.abs(from.getX() - to.getX()) +
				Math.abs(from.getY() - to.getY()));
	}
	
	private Coordinate from;
	private Coordinate to;
	private int distance;
}
