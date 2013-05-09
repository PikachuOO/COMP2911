import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Sandy
 *
 */
public class CourierDelivery {

	public static void main(String args[]) {
		try {
			Scanner inputScanner = new Scanner(new File(args[0]));
			JobsInDay myJobs = new JobsInDay();
			
			while (inputScanner.hasNext()) {
				String s = inputScanner.nextLine();
				String[] params = s.split(" ");
				
				if (params[0].equals("Job")) {
					Inputs inputs = new Inputs(params);
					myJobs.addJob(inputs.getFrom(), inputs.getTo());
				}
			}
			
			
			LinkedList<Job> jobs = myJobs.getJobs();
			for (Job j : jobs) {
				System.out.println("From (" + j.getFrom().getX() + "," + j.getFrom().getY()
						+ ") to (" + j.getTo().getX() + "," + j.getTo().getY() + ").");
			}
			
			myJobs.getJobPath();
			
			inputScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
}
