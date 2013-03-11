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
   }
}
