import java.io.*;

public class CreateRandomFile {
   private Record blank;
   private RandomAccessFile file;

   public CreateRandomFile()
   {
      blank = new Record();

      try {
         file = new RandomAccessFile( "payroll.dat", "rw" );
																// file.seek(file.length());
					for ( int i = 0; i < 100; i++ )
							blank.write( file );
        file.close();
      }//try
      catch( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }//catch

	

   }//CreateRandomFile

   public static void main( String args[] )
   {
      new CreateRandomFile();
   }//main   
}//CreateRandomFile

