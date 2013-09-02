public class DuplicateValueException extends Exception 
{
   // no-argument constructor specifies default error message
   public DuplicateValueException() 
   {
      super( "Duplicate Values are not supported" );
   }
   
   // constructor to allow customized error message
   public DuplicateValueException( String message )
   {
      super( message );
   }
} // end class DuplicateValueException