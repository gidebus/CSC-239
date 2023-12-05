
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


class Emprec {
	int record;
	String name;
	String jobtitle;
	int age;
	int dependents;	
	double hours;
	double rate;
	double salary;

Emprec(	int record, String name, String jobtitle, int age, int dependents, double hours, double rate, double salary)
{

this.record=record;
this.name=name;
this.jobtitle=jobtitle;
this.age=age;
this.dependents=dependents;	
this.hours=hours;
this.rate=rate;
this.salary=salary;

}//Emprec


Emprec(	String record, String name, String jobtitle, String age, String dependents, String hours, String rate, String salary)
{

try{
this.record=Integer.parseInt(record);
this.name=name;
this.jobtitle=jobtitle;
this.age=Integer.parseInt(age);
this.dependents=Integer.parseInt(dependents);	
this.hours=Double.valueOf(hours).doubleValue();
this.rate=Double.valueOf(rate).doubleValue();
this.salary=Double.valueOf(salary).doubleValue();
}

catch(NumberFormatException errmsg)
{
  System.out.println("Invalid format"+ errmsg);

     this.name  = "";
     this.hours = 0.0;
     this.rate  = 0.0;
     this.dependents = 0;

}//catch
}//Emprec




double calc_fed_tax(double hours,double rate)
{

  double yearly_income;

  yearly_income = hours * rate *52;

   if (yearly_income < 30000.00) return (hours * rate *.28);

   else if ( yearly_income < 50000.00 ) return (hours * rate* .32);

   else return (hours * rate * .38);


}// calc_fed_tax


double calc_gross_pay()
{

   return (hours * rate);

}// calc_gross_pay


double calc_state_tax(double hours, double rate)
{

  double state_tax;

  state_tax = hours * rate * .0561;

  return (state_tax);

}// calc_state_tax


double calc_fica_tax( double salary)
{

 double social_security_tax; 
 
 double medicare_tax_rate;

 social_security_tax = salary * .062;

 medicare_tax_rate = salary * .0145;

 return ( social_security_tax + medicare_tax_rate);

}// calc_fica_tax


public  String toString()
{

return
("\nEmployee Record Number "+record+
"\nEmployee name is "+name+
"\nEmployee job title is "+jobtitle+
"\nEmployee age is "+age+
"\nTotal number of dependents " +dependents+ 
"\nTotal hours worked "+hours+
"\nEmployee payrate "+rate+
"\nEmployee salary $"+salary +
"\nEmployee grosspay $"+calc_gross_pay() );

}//toString


}// Emprec


public class ReadRandomFile extends Frame 
             implements ActionListener {

EventTicket employee;

   private TextField recordField, nameField,
		     jobtitleField, ageField, dependentsField,
            	     hoursField, rateField, salaryField;

   private Button next,   // get next record in file
                  done;   // quit program

   // Application other pieces
   private RandomAccessFile input;  
   private Record data;

   // Constructor -- initialize the Frame
   public ReadRandomFile()
   {
      super( "Read Client File" );

      try {
         input = new RandomAccessFile( "payroll.dat", "r" );
      } //try
      catch ( IOException e ) {
         System.err.println( e.toString() );
         System.exit( 1 );
      }//catch

      data = new Record();

      setSize( 600, 300 );
      setFont(new Font("verdana",Font.BOLD,12));  
      setLayout( new GridLayout( 9, 2 ) );

      add( new Label( "Record Number" ) );
      recordField = new TextField();
      recordField.setEditable( false );
      add( recordField );

      add( new Label( "Name" ) );
      nameField = new TextField( 20 );
      nameField.setEditable( false );
      add( nameField );

      add( new Label( "Job Title" ) );
      jobtitleField = new TextField();
      jobtitleField.setEditable( false );
      add( jobtitleField );

      add( new Label( "Age" ) );
      ageField = new TextField( 20 );
      ageField.setEditable( false );
      add( ageField );
          
      add( new Label( "Dependents" ) );
      dependentsField = new TextField( 20 );
      dependentsField.setEditable( false );
      add( dependentsField );

      add( new Label( "Hours" ) );
      hoursField = new TextField( 20 );
      hoursField.setEditable( false );
      add( hoursField );
      
      add( new Label( "Rate" ) );
      rateField = new TextField( 20 );
      rateField.setEditable( false );
      add( rateField );
	
      add( new Label( "Salary" ) );
      salaryField = new TextField( 20 );
      salaryField.setEditable( false );
      add( salaryField );

      next = new Button( "Next" );
      next.addActionListener( this );
      add( next );      

      done = new Button( "Done" );
      done.addActionListener( this );
      add( done );       

      setVisible( true );  
   }//ReadRandomFile

   public void actionPerformed( ActionEvent e )
   {
      if ( e.getSource() == next )
         readRecord();
      else
         closeFile();
   } //actionPerformed

   public void readRecord()
   {
      
      DecimalFormat twoDigits = new DecimalFormat( "0.00" );
      DecimalFormat dollar = new DecimalFormat( "$.00" );    

      int record, age, dependents;
      String name, jobtitle;
      double hours, rate, salary;

      try {
       
	do {
            data.read( input );
         
	   record = data.getrecord();
           name = data.getname();
	   jobtitle = data.getjobtitle();
           age = data.getage();
           dependents = data.getdependents();
	   hours = data.gethours();
	   rate = data.getrate();
	   salary = data.getsalary(); 

	   employee=new EventTicket(record, name, jobtitle, age, dependents, hours, rate, salary);
	
	} while ( data.getrecord() == 0 );   	             
	
 	System.out.println(employee);  
        System.out.println("The State tax is $" + employee.calc_state_tax(employee.hours, employee.rate));
        System.out.println("The Federal tax is $" + employee.calc_fed_tax(employee.hours, employee.rate));
	System.out.println("The yearly fica taxes are $" + employee.calc_fica_tax(employee.salary));
       
	recordField.setText(String.valueOf( record ) );
        
        nameField.setText( name );
        
        jobtitleField.setText( jobtitle );
	
        ageField.setText( String.valueOf( age) );
	
        dependentsField.setText(String.valueOf( dependents) );
        
        hoursField.setText( String.valueOf(twoDigits.format( hours ) ));
        
        rateField.setText( String.valueOf(twoDigits.format( rate ) ));
        
        salaryField.setText( String.valueOf(dollar.format( salary ) ));
     }
      catch ( EOFException eof ) {
         closeFile();
      }
      catch ( IOException e ) {
         System.err.println( "Error during read from file\n" +
                             e.toString() );
         System.exit( 1 );
      }
	
		
   }//readRecord

   private void closeFile()
   {
      try {
         input.close();
         System.exit( 0 );
      }//try
      catch ( IOException e ) {
         System.err.println( "Error closing file\n" +
                             e.toString() );
         System.exit( 1 );
      }//catch
   }//closeFile
   
   // Instantiate a ReadRandomFile object and start the program
   public static void main( String args[] )
   {
      new ReadRandomFile();
   }//main
}//ReadRandomFile

