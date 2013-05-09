import java.io.File;
import java.io.FileNotFoundException;
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
					String from[] = {params[1], params[2]};
					String to[] = {params[4], params[5]};
					myJobs.addJob(from, to);
				}
			}
			
			inputScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
}
