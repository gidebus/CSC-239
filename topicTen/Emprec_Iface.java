
public interface Emprec_Iface{
  
  //define and initialize costs
  
  public double VIPDiscount = 0.90;

  public double JuniorStylistRate = 1.00;
  public double SeniorStylistRate = 1.50;
  public double MasterStylistRate = 2.00;
  
  public double WashAndBlowdryCost = 30.00;
  public double HaircutCost = 50.00;
  public double ColoringCost = 100.00;
  public double PermingCost = 120.00;
  
  public double WashAndBlowdryHour = 0.50;
  public double HaircutHour = 1.00;
  public double ColoringHour= 3.00;
  public double CurlingHour = 2.50;
  
  
  
  public double calcRegularCost();
  
  public double calcVIPCost();
  
  public double calcHourNeeded();
  
}


