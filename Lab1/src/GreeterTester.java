public class GreeterTester {
   public static void main(String[] args) {
      Greeter worldGreeter = new Greeter("World");
      String greeting = worldGreeter.sayHello();
      // This should output 'Hello, World!'
      System.out.println(greeting);
      
      Greeter daveGreeter = new Greeter("Dave");
      String daveGreeting = daveGreeter.sayHello();
      // This should output 'Hello, Dave!'
      System.out.println(daveGreeting);
      
      // This let daveGreeter points to
      // worldGreeter
      daveGreeter = worldGreeter;
      // This should output 'Hello, World!'
      System.out.println(daveGreeter.sayHello());
      
      // This should output 'Hello, Janet'
      daveGreeter.setName("Janet");
      System.out.println(daveGreeter.sayHello());
   }
}