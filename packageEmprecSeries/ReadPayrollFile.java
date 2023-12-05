 import com.jhaley.x1.Emprec;
  import com.jhaley.x1.Emprec_Iface;
   import com.jhaley.x1.HoursRate;


import java.io.*;
import java.awt.*;
import java.awt.event.*;

import java.text.DecimalFormat;  // TO FORMAT DOUBLES

import java.text.SimpleDateFormat; // TO FORMAT DATES
import java.util.Date; // TO FORMAT DATES


public class ReadPayrollFile extends Frame
             implements ActionListener {

 
   Record employee;

   private TextField RecNumberField,  NameField, DependentsField, AgeField, HoursField,
                 RateField, JobTitleField, GenderField, GrossPayField, FedTaxField, StateTaxField, DateField;

  

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private DataInputStream input;

   // Constructor -- initialize the Frame 
   public ReadPayrollFile()
   {
      super( "Read Client File" );

      // Open the file
      try {
          //open a file
         input = new DataInputStream(
                     new FileInputStream( "payroll.txt" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 400, 500 );
      setLayout( new GridLayout( 13, 2 ) );


       // add Text Fields
       add( new Label(" Date"));
       DateField = new TextField();
       DateField.setEditable(false);
       add(DateField);
       
       add( new Label( " Record Number" ) );
       RecNumberField = new TextField();
       RecNumberField.setEditable( false );
       add( RecNumberField );
       
       add( new Label( " Job Title" ) );
       JobTitleField = new TextField();
       JobTitleField.setEditable(false);
       add( JobTitleField );

       add( new Label( " Name" ) );
       NameField = new TextField();
       NameField.setEditable( false );
       add(  NameField );

       add( new Label( " Age" ) );
       AgeField = new TextField(  );
       AgeField.setEditable(false);
       add(  AgeField );
       
       add(new Label(" Dependents "));
       DependentsField = new TextField();
       DependentsField.setEditable(false);
       add(DependentsField);
       
       add(new Label(" Gender "));
       GenderField = new TextField();
       GenderField.setEditable(false);
       add(GenderField);

       add( new Label( "Hours" ) );
       HoursField = new TextField();
       HoursField.setEditable( false );
       add( HoursField );

       add( new Label( "Rate" ) );
       RateField = new TextField();
       RateField.setEditable( false );
       add( RateField );
       
       //add new text fields
       add( new Label("Gross Pay") );
       GrossPayField = new TextField();
       GrossPayField.setEditable( false );
       add(GrossPayField);
       
       add( new Label( "Federal Tax" ) );
       FedTaxField = new TextField();
       FedTaxField.setEditable( false );
       add(FedTaxField);
       
       add( new Label("State Tax") );
       StateTaxField = new TextField();
       StateTaxField.setEditable( false );
       add(StateTaxField);

       next = new Button( "Next" );
       next.addActionListener( this );
       add( next );

       done = new Button( "Done" );
       done.addActionListener( this );
       add( done );

       setVisible( true );
   }

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == next )
         readRecord();
      else
         closeFile();
   }

   public void readRecord() //read record from a file
   {
       DecimalFormat twoDigits = new DecimalFormat( "0.00" );
       DecimalFormat dollar = new DecimalFormat( "$.00" );
       
      //define temporary variables
      int recnumber = 0;
      int age = 0;
      int depTemp = 0;
      String name, jobTitle;
      double h,r;
      char gender;

      // input the values from the file
      try {
         //read data from a file
         recnumber = input.readInt();
         jobTitle = input.readUTF(); 
         name = input.readUTF();
		 age = input.readInt();
         depTemp = input.readInt();
         gender = input.readChar();
         h = input.readDouble();
         r=input.readDouble();
    
        //create new instance of Emprec object
        employee=new Record(recnumber, jobTitle, name, age, depTemp, gender, h, r);


        System.out.println(employee.toString()); //toString()
        
        //format date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy  hh:mm");
        Date date = employee.getDate();
		
		//show data on fields
        DateField.setText(String.valueOf(dateFormat.format(date)));
		
        RecNumberField.setText( String.valueOf( recnumber ) );
       
	   JobTitleField.setText(jobTitle);
        
		NameField.setText( name );
       
	   AgeField.setText(String.valueOf(age));
       
	   DependentsField.setText(String.valueOf(depTemp));
       
	   GenderField.setText(String.valueOf(gender));
       
	   HoursField.setText( String.valueOf( twoDigits.format(h) ) );
       
	   RateField.setText( String.valueOf( dollar.format(r) ) );
       
	   GrossPayField.setText( String.valueOf ( dollar.format ( employee.calc_gross_pay() ) ) );
       
	   FedTaxField.setText( String.valueOf( dollar.format(employee.calc_fed_tax(h, r))));
       
	   StateTaxField.setText( String.valueOf( dollar.format(employee.calc_state_tax(h, r))));

      }
      catch ( EOFException eof ) { //end of file exception
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" + e.toString() );
         System.exit( 1 );
      }
   }//end readRecord()

   private void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" + e.toString() );
         System.exit( 1 );
      }
   }

   public static void main( String args[] )
   {
      new ReadPayrollFile();
   }
}
