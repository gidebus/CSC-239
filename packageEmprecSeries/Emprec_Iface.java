package com.jhaley.x1;

public interface Emprec_Iface{
    
    //define and initialize taxRate
    public double TAX_RATE_ONE = 0.28;
    public double TAX_RATE_TWO = 0.32;
    public double TAX_RATE_THREE = 0.38;
    
    public double YEAR_INCOME_S = 30000.00;
    public double YEAR_INCOME_M = 50000.00;
    
    public double STATE_TAX_RATE = 0.0561;
    
    public int TOTAL_WEEKS = 52;
    
    public double calc_gross_pay();  //forward declaration
    
    public double calc_fed_tax(double hours,double rate);
    
    public double calc_state_tax(double hours, double rate);
}
