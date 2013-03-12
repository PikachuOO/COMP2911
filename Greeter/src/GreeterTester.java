import java.util.Scanner;

public class GreeterTester
{
   public static void main(String[] args)
   {
      Greeter worldGreeter = new Greeter("World");
      String greeting = worldGreeter.sayHello();
      Greeter daveGreeter = new Greeter("Dave");
      System.out.println(greeting);
      System.out.println(daveGreeter.sayHello());
      daveGreeter = worldGreeter;
      System.out.println(daveGreeter.sayHello());
      daveGreeter.setName("Janet");
      System.out.println(daveGreeter.sayHello());
      
      /**
       * Prompts for 2 inputs and compare if they are contained
       */
      Scanner input = new Scanner(System.in);
      if (input.nextLine().contains(input.nextLine()))
    	  System.out.println("The second string is contained in the first string");
      else
    	  System.out.println("Doesn't contain");
      input.close();
   }
}
