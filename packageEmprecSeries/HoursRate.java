package com.jhaley.x1;

//create class that hold data from hours and rate fields
public class HoursRate{
    public double hours;
    public double rate;
    
    //default constructor
    public HoursRate()
{
        this.hours = 0.00;
        this.rate = 0.00;
    }
    
    //constructor
    public HoursRate(double hours, double rate){
        this.hours = hours;
        this.rate = rate;
    }
    
    public HoursRate(String hours, String rate){
        try{
            this.hours = Double.valueOf(hours).doubleValue();
            this.rate = Double.valueOf(rate).doubleValue();
            
        }catch(NumberFormatException errmsg){
            System.out.println("Invalid format " + errmsg);
            
            this.hours = 0.00;
            this.rate = 0.00;
        }
    }
    
    //define accessor functions
    public double getHours(){
        return this.hours;
    }
    
    public double getRate(){
        return this.rate;
    }
}
