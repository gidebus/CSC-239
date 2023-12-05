import java.io.*;


public class Record {
   private int record;
   private String name;
   private String jobtitle;
   private int age;
   private int dependents;	
   private double hours;
   private double rate;
   private double salary;

   
// Read a record from the specified RandomAccessFile
   public void read( RandomAccessFile file ) throws IOException
   {
      record = file.readInt();

      char n[] = new char[ 15 ];

      for ( int i = 0; i < n.length; i++ )
         n[ i ] = file.readChar();

      name = new String( n );


      char title[] = new char[ 15 ];

      for ( int i = 0; i < title.length; i++ )
         title[ i ] = file.readChar();

      jobtitle = new String( title );
     
     age         = file.readInt();
     dependents  = file.readInt();
     hours       = file.readDouble();
     rate        = file.readDouble();
     salary 	 = file.readDouble();
      
   }//read

   // Write a record to the specified RandomAccessFile
   public void write( RandomAccessFile file ) throws IOException
   {
      StringBuffer buf;

      file.writeInt(record );

      if ( name != null ) 
         buf = new StringBuffer( name );
      else 
         buf = new StringBuffer( 15 );

      buf.setLength( 15 );

      file.writeChars( buf.toString() );

      if ( jobtitle != null ) 
         buf = new StringBuffer( jobtitle );
      else 
         buf = new StringBuffer( 15 );

      buf.setLength( 15 );

      file.writeChars( buf.toString() );
	
      file.writeInt( age );
      file.writeInt( dependents );
      file.writeDouble( hours);
      file.writeDouble( rate );
      file.writeDouble( salary);
     
   }//write

   public void setrecord( int r ) { record = r; }

   public int getrecord() { return record; }

   public void setname( String n ) { name = n; }

   public String getname() { return name; }

   public void setjobtitle( String j ) { jobtitle = j; }

   public String getjobtitle() { return jobtitle; }

   public void setage( int a ) { age = a; }

   public int getage() { return age; }

   public void setdependents( int d ) { dependents = d; }

   public int getdependents() { return dependents;}

   public void sethours( double h ) { hours = h; }

   public double gethours() { return hours;}

   public void setrate( double rt ) { rate = rt; }

   public double getrate() { return rate;}

   public void setsalary( double s ) { salary = s; }

   public double getsalary() { return salary;}



   // NOTE: This method contains a hard coded value for the
   // size of a record of information.
   public static int size() { return 96; }
}//Record