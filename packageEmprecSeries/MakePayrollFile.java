 import com.jhaley.x1.Emprec;
  import com.jhaley.x1.Emprec_Iface;
   import com.jhaley.x1.HoursRate;
 
 import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MakePayrollFile extends Frame //Frame class represents top-level window with a title and border
             implements ActionListener { //ActionListener interface - receive action events

 
   // text components that allow for editing of single line of text
   private TextField RecNumberField,  NameField, DependentsField,
                 AgeField, HoursField,RateField, JobTitleField, GenderField;
                 
   private Button enter,  // send record to file
                  done;   // quit program

   // Application other pieces
   private DataOutputStream output;  

   public MakePayrollFile() //constructor
   {
      super( "Payroll File -  Write" );

      // Open the file
      try {
         output = new DataOutputStream(
                      new FileOutputStream( "payroll.txt" ) );
      }
      catch ( IOException e ) {
         System.err.println( "File not opened properly\n" +
                             e.toString() );
         System.exit( 1 );
      }      

      setSize( 400, 400 ); // set frame size
      setLayout( new GridLayout( 9, 2 ) ); // create layout with 8 rows and 2 columns
                            
      // create the components of the Frame
      add( new Label( " Record Number" ) );
      RecNumberField = new TextField();
      add( RecNumberField );
       
      add( new Label( " Job Title" ) ); //add new text field
      JobTitleField = new TextField();
      add( JobTitleField );

      add( new Label( " Name" ) );
      NameField = new TextField(  );
      add(  NameField );      

      add( new Label( " Age" ) );
      AgeField = new TextField(  );
      add(  AgeField );
       
      add(new Label(" Dependents "));
      DependentsField = new TextField();
      add(DependentsField);
       
      add(new Label(" Gender "));
      GenderField = new TextField();
      add(GenderField);

      add( new Label( " Hours" ) );
      HoursField = new TextField( );
      add( HoursField );

      add( new Label( " Rate" ) );
      RateField = new TextField(  );
      add( RateField );

      enter = new Button( " Enter" );
      enter.addActionListener( this );
      add( enter );      

      done = new Button( "  Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  //set visibility of frame
      HoursField.requestFocus(); //set mouse focus in a field Hours
   }

                 
   public void actionPerformed( ActionEvent e ) //get mouse events
   {
       if ( e.getSource() == enter ) addRecord(); //add new record

      if ( e.getSource() == done ) { //close a file
         try {
            output.close();
         }
         catch ( IOException io ) {
            System.err.println( "File not closed properly\n" + io.toString() );
            System.exit( 1 );
         }

         System.exit( 0 );
      }
   }


   public void addRecord(){
       //define temporary variables
       int recNumber = 0;
       int ageTemp = 0;
       int depenTemp = 0;
       Double h,r;
       char genderTemp;

        if(!RecNumberField.getText().equals( "" )) { //check if input is not empty

           try{
              recNumber = Integer.parseInt( RecNumberField.getText());

            if ( recNumber > 0 ) { //if account number is more than zero
               output.writeInt( recNumber ); //write integer RecNumber to a file
               output.writeUTF( JobTitleField.getText() );
               output.writeUTF( NameField.getText() );
            
             try{
                 ageTemp = Integer.parseInt(AgeField.getText()); //convert str to int
                 output.writeInt(ageTemp); //write age
                 
             }catch(NumberFormatException nfe){
                 System.err.println("Age must be an integer" );
             }
              
              try{
                  depenTemp = Integer.parseInt(DependentsField.getText());
                  output.writeInt(depenTemp);
                  
              }catch(NumberFormatException nfe){
                  System.err.println("You must enter an integer number" );
              }
              
              try{
                  genderTemp = GenderField.getText().charAt(0);
                  output.writeChar(genderTemp);
                  
              }catch(IndexOutOfBoundsException nfe){
                  System.err.println( "Gender must be entered as a one character or a String" );
              }
              
              try{
                  h = new Double ( HoursField.getText() );
                  output.writeDouble( h.doubleValue() );
                  
              }catch(NumberFormatException nfe){
                  System.err.println("Number must be entered as a Double");
              }
              
              try{
              
                  r = new Double ( RateField.getText() );
                  output.writeDouble( r.doubleValue() );
                  
              }catch(NumberFormatException nfe){
                  System.err.println("Number must be entered as a Double");
              }
                

         }//if statement

          // clear the TextFields
          RecNumberField.setText( "" );
          JobTitleField.setText("");
          NameField.setText( "" );
          AgeField.setText("");
          GenderField.setText("");
          DependentsField.setText("");
          HoursField.setText( "" );
          RateField.setText("");
          
    }catch(NumberFormatException nfe){
        System.err.println("You must enter an integer number" );
        
    }catch ( IOException io ) {
            System.err.println("Error during write to file\n" + io.toString() );
            System.exit( 1 );
    }
            
  }//if
       
}//addRecord


   public static void main( String args[] )
   {
      new MakePayrollFile();
   }
}
