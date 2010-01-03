// Listing 2-7
public class SayHello
{
   public static void main( String args[] )
   {
      Name name = new Name();
      name.setFirstName( args[0] );
      System.out.println( name.toString() );
   }
}