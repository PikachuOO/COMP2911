import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
   A telephone that takes simulated keystrokes and voice input
   from the user and simulates spoken text.
*/
public class TelephoneManager
{
   /**
      Construct phone object.
      @param aScanner that reads text from a character-input stream
 * @param aSystem 
   */
   public TelephoneManager(Scanner aScanner, MailSystem aSystem)
   {
      scanner = aScanner;
      system = aSystem;
      connections = new ArrayList<Connection>();
   }

   /**
      Speak a message to System.out.
      @param output the text that will be "spoken"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Loops reading user input and passes the input to the
      Connection object's methods dial, record or hang up.
      @param c the connection that connects this phone to the
      voice mail system
   */
   public void run()
   {
	  /*String id = "";
	  Connection c = new Connection(system, this);
	  c.setId(id);*/
	   Connection c = null; // this is the active connection
      boolean more = true;
      while (more)
      {
         String input = scanner.nextLine();
	   	 
         if (input == null) return;
         if (input.equalsIgnoreCase("H")) {
            c.hangup();
            //id = "";
         }
         else if (input.equalsIgnoreCase("Q"))
            more = false;
         /*else if ("1234567890#".indexOf(input.substring(0, input.length() - 1)) >= 0) {
        	 if (input.endsWith(":")) {
        		 input = input.substring(0, input.length()-1);
        		 id += input;
        		 c.dial(input);
        	 }
        	 else {
        		 Iterator<Connection> iter = connections.iterator();
        		 while (iter.hasNext()) {
        			 if (iter.next().getId().equals(id))
        				 c = iter.next();
        			 else {
        				 c = new Connection(system, this);
        				 c.setId(id);
        				 connections.add(c);
        			 }
        		 }
        		 c.setId(id);
        		 if (!connections.contains(c))
        			 connections.add(c);
        		 c.dial(input);
        	 }
         }*/
         else if (input.endsWith(":")) {
        	 int id = new Integer(input.substring(0, input.length()-1));
        	 
        	 Boolean foundConnection = false;
        	// search through the connections.. for the connection... matching on id.
        	 for (Connection checkC : connections) {
        		 if (checkC.getId() == id) {
        			 c = checkC;
        			 foundConnection = true;
        			 break;
        		 }
        	 }
        	 
        	 // if we don't find anything then, create the new connection.
        	 if (foundConnection == false) {
        		 c = new Connection(system, this, id);
        		 connections.add(c);
        	 }
        	 
        	 
         }
         else if (input.length() == 1
            && "1234567890#".indexOf(input) >= 0)
            c.dial(input);
         else
            c.record(input);
      }
   }

   private Scanner scanner;
   private MailSystem system;
   private ArrayList<Connection> connections; // = new ArrayList<Connection>();
}
