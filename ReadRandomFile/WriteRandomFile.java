
import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class WriteRandomFile extends Frame 
             implements ActionListener {

   private TextField recordField, nameField,
                     jobtitleField,ageField, dependentsField,
            	     hoursField, rateField, salaryField;


   private Button enter,  
                  done;   

  
   private RandomAccessFile output;  
   private Record data;
   

   public WriteRandomFile()
   {
      super( "Write to random access file" );

      data = new Record();

      try {
         output = new RandomAccessFile( "payroll.dat", "rw" );
      }//try
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }//catch

      setSize( 600, 300 );
      setLayout( new GridLayout( 9, 2 ) );
      setFont(new Font("verdana",Font.BOLD,12));  
      
      // create the components of the Frame

      add( new Label( "Record Number" ) );
      recordField = new TextField();
      add( recordField );

      add( new Label( "Name" ) );
      nameField = new TextField( 20 );
      add( nameField );      

      add( new Label( "Job Title" ) );
      jobtitleField = new TextField();
      add( jobtitleField );

      add( new Label( "Age" ) );
      ageField = new TextField( 20 );
      add( ageField );
        
      add( new Label( "Dependents" ) );
      dependentsField = new TextField( 20 );
      add( dependentsField );

      add( new Label( "Hours" ) );
      hoursField = new TextField( 20 );
      add( hoursField );
      
      add( new Label( "Rate" ) );
      rateField = new TextField(20);
      add( rateField );
	
      add( new Label( "Salary" ) );
      salaryField = new TextField( 20 );
      add( salaryField );
	    
      enter = new Button( "Enter" );
      enter.addActionListener( this );
      add( enter );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }//WriteRandomFile




   public void addRecord()
   {
      int recordNumber = 0;
      int age, dependents; 
      Double d, e, f;    



      if ( !recordField.getText().equals( "" ) ) {

         try {
            	recordNumber = Integer.parseInt( recordField.getText() );
	     } 

        catch(NumberFormatException nfe) {
              System.err.println("Record Number must be entered as an Integer");       
             }

            if ( recordNumber > 0 && recordNumber <=100 ) {
               
	       	data.setrecord( recordNumber);
        
         try {
	       data.setname( nameField.getText() );
               data.setjobtitle( jobtitleField.getText() ); 

	       age = 
		Integer.parseInt( ageField.getText() );
	       data.setage( age );
           }

         catch(NumberFormatException nfe) {
              System.err.println("Age must be entered as an Integer");       
             }

         try {
 	       dependents = 
		Integer.parseInt( dependentsField.getText() );
               data.setdependents( dependents );
	     }
	 catch(NumberFormatException nfe) {
              System.err.println("Number of Dependents must be entered as an Integer");       
             }
          
	 try {
               d = new Double ( hoursField.getText() );
               data.sethours( d.doubleValue() );
             }
        catch(NumberFormatException nfe) {
              System.err.println("Hours must be entered as a double");     
             }
	try {
               e = new Double ( rateField.getText() );
               data.setrate( e.doubleValue() );
  	     }
	catch(NumberFormatException nfe) {
              System.err.println( "Rate must be entered as a double" );       
             }
	try {
               f = new Double ( salaryField.getText() );
               data.setsalary( f.doubleValue() );
  	     }
        catch(NumberFormatException nfe) {
              System.err.println( "Salary must be entered as a double" );       
             }

        try{   
            output.seek(
                  (long) ( recordNumber-1 ) * Record.size() );
               data.write( output );
	    
	               }   
	catch ( IOException io ) {
            System.err.println(
               "Error during write to file\n" +
               io.toString() );
            System.exit( 1 );
         }//catch
         
   
	/* 
	 
	 //NOW ADD 50 RECORDS !!!!!
	 try{
           output.seek(output.length()); //seek to the end of the file
		
			System.out.println("output length now " + output.length());
            
	for ( int i = 0; i < 50; i++ )
          	    data.write( output ); // write fifty additional records	   
         }   
	catch ( IOException io ) {
            System.err.println(
               "Error during write to file\n" +
               io.toString() );
            System.exit( 1 );
         }//catch     
            
		*/	
			
}//if   ??if ( !recordField.getText().equals( "" ) ) {     LINE 

   
	    
	    
	    
	    
	        recordField.setText( "" );
            nameField.setText( "" );
            jobtitleField.setText( "" );
	        ageField.setText( "" );
            dependentsField.setText( "" );
            hoursField.setText( "" );
            rateField.setText( "" );
            salaryField.setText( "" );


	}//add record
	
 
         }// if


   public void actionPerformed( ActionEvent e )
   {
      addRecord();
      
      if ( e.getSource() == done ) {
         try {
            output.close();
         }//try
         catch ( IOException io ) {
            System.err.println( "File not closed properly\n" + io.toString() );
			
         }//catch

         System.exit( 0 );
      }//if
   }//actionPerformed


  
   // Instantiate a WriteRandomFile object and start the program
 
 public static void main( String args[] )
   {
   	 new WriteRandomFile();

   }//main


}//WriteRandomFile