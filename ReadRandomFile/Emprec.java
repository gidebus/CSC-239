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
