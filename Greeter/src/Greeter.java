/**
   A class for producing simple greetings.
*/

public class Greeter
{
   /**
      Constructs a Greeter object that can greet a person or 
      entity.
      @param aName the name of the person or entity who should
      be addressed in the greetings.
   */
   public Greeter(String aName)
   {
      name = aName;
   }

   /**
      Greet with a "Hello" message.
      @return a message containing "Hello" and the name of
      the greeted person or entity.
   */
   public String sayHello()
   {
      return "Hello, " + name + "!";
   }

   /**
      Set the name field of class to the input string.
      @param aName a String for the name to be called.
   */
   public void setName(String aName) {
      name = aName;
   }

   private String name;
}