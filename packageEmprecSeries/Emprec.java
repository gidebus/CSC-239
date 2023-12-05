
package com.jhaley.x1;

import java.text.DecimalFormat;
import java.util.Date;

public class Emprec extends HoursRate implements Emprec_Iface{
        
        //define properties
        public int record;
        public String jobTitle;
        public String name;
        public int age;
        public int dependents;
        public char gender;
        public Date date;
    
        //constructor
        public Emprec( int record, String jobTitle, String name, int age, int dependents, char gender, double hours, double rate)
        {
            super(hours, rate);
            
            this.record=record;
            this.jobTitle=jobTitle;
            this.name=name;
            this.age=age;
            this.dependents=dependents;
            this.gender = gender;
            date = new Date(); //initialize a date
            
        }
    
        public Date getDate(){
            return date;
        }
        
        //interface method implementation
        public double calc_gross_pay()
        {
            
            return ( getHours() * getRate() );
            
        }// calc_gross_pay
        
        //interface method implementation
        public double calc_fed_tax(double hours,double rate)
        {
            
            double yearly_income;
            
            yearly_income = hours * rate * TOTAL_WEEKS; //52 - weeks per year
            
            if (yearly_income < YEAR_INCOME_S) return (hours * rate * TAX_RATE_ONE);
            
            else if ( yearly_income < YEAR_INCOME_M) return (hours * rate* TAX_RATE_TWO);
            
            else return (hours * rate * TAX_RATE_THREE);
            
            
        }// calc_fed_tax
        
        
        //interface method implementation
        public double calc_state_tax(double hours, double rate)
        {
            
            return (hours * rate * STATE_TAX_RATE);
            
        }// calc_state_tax
        
        public  String toString()
        {
            DecimalFormat twoDigits = new DecimalFormat( "0.00" );
            DecimalFormat dollar = new DecimalFormat( "$.00" );
            
            return
            ("\n Record: "+ this.record +
             "\n Job title: "+ this.jobTitle +
             "\n Name: "+ this.name +
             "\n Age: "+ this.age +
             "\n Dependents: " + this.dependents +
             "\n Gender: " + this.gender +
             "\n Hours: " + twoDigits.format(getHours()) +
             "\n Rate: " + dollar.format(getRate()) +
             "\n Gross Pay: " + dollar.format(calc_gross_pay()) +
             "\n Federal Tax: " + dollar.format(calc_fed_tax(getHours(), getRate())) +
             "\n State Tax: " + dollar.format(  calc_state_tax(getHours(), getRate()))
);//return
            
            
        }//toString
        
    }
