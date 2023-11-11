
import java.text.NumberFormat;

public class Emprec implements Emprec_Iface {
String phoneNum;
String name;
String email;  
boolean membership;
char gender;
String stylist;
String services;


public Emprec (String phoneNum, String name, String email, boolean membership,
                 String gender, String stylist, String services)
{

this.name=name;
this.phoneNum=phoneNum;
this.email=email;
this.membership=membership;
this.gender = gender.charAt(0);
this.stylist=stylist;
this.services=services;
}


Emprec ( String phoneNum,String name, String email,String membership,
        String gender,String stylist,String services)
{

try {
this.phoneNum=phoneNum;
this.name=name;
this.email=email;
this.membership=Boolean.parseBoolean(membership);
this.gender=gender.charAt(0);
this.stylist=stylist;
this.services=services;


}

catch(NumberFormatException errmsg)
{
System.out.println("Invalid format"+ errmsg);

  this.phoneNum = "";
  this.name  = "";  
  this.email =" ";
  this.gender = ' ';
  this.stylist= "";
  this.services = "";


}//catch

}//Emprec constructor !!!!

public double calcRegularCost()
{
  double regular_cost = 0.00;
  
// calulate cost for junior stylist
if (stylist.equals("Junior") && services.equals("wash/blowdry"))
regular_cost = JuniorStylistRate * WashAndBlowdryCost;
if (stylist.equals("Junior") && services.equals("Haircut"))
regular_cost = JuniorStylistRate * HaircutCost;
if (stylist.equals("Junior") && services.equals("Coloring"))
regular_cost = JuniorStylistRate * ColoringCost;
if (stylist.equals("Junior") && services.equals("Perming"))
regular_cost = JuniorStylistRate * PermingCost;

//calculate cost for senior stylist
if (stylist.equals("Senior") && services.equals("wash/blowdry"))
regular_cost = SeniorStylistRate * WashAndBlowdryCost;
if (stylist.equals("Senior") && services.equals("Haircut"))
regular_cost = SeniorStylistRate * HaircutCost;
if (stylist.equals("Senior") && services.equals("Coloring"))
regular_cost = SeniorStylistRate * ColoringCost;
if (stylist.equals("Senior") && services.equals("Perming"))
regular_cost = SeniorStylistRate * PermingCost;

//calculate cost for master stylist
if (stylist.equals("Master") && services.equals("wash/blowdry"))
regular_cost = MasterStylistRate * WashAndBlowdryCost;
if (stylist.equals("Master") && services.equals("Haircut"))
regular_cost = MasterStylistRate * HaircutCost;
if (stylist.equals("Master") && services.equals("Coloring"))
regular_cost = MasterStylistRate * ColoringCost;
if (stylist.equals("Master") && services.equals("Perming"))
regular_cost = MasterStylistRate * PermingCost;


return  (regular_cost);

}// calc_regular_cost


public double calcVIPCost ()
{

double vip_cost = calcRegularCost()* VIPDiscount;

return (vip_cost);

}// calc_vip_cost

public double calcHourNeeded() {
double hour_needed = 0.0;

if (services.equals("wash/blowdry"))
hour_needed = WashAndBlowdryHour;
if (services.equals("Haircut"))
hour_needed = HaircutHour;
if (services.equals("Coloring"))
hour_needed = ColoringHour;
if (services.equals("Curling"))
hour_needed = CurlingHour;

return (hour_needed);
} // calc_hour_needed


public  String toString()
{
 
 NumberFormat fmt = NumberFormat.getCurrencyInstance();

return
        (   "\n Phone Number:\t\t"+ this.phoneNum +
            "\n Name:\t\t\t"+ this.name +
            "\n Email:\t\t\t"+ this.email +
            "\n Membership Status:\t" + (this.membership ? "VIP Member":"Regular Member" ) +
            "\n Stylist Gender:\t\t"+ gender +
            "\n Stylist Level:\t\t" + stylist +
            "\n Service:\t\t" + services +
            "\n Regular Cost:\t\t"+ fmt.format(calcRegularCost()) +
            "\n VIP Cost:\t\t"+ fmt.format(calcVIPCost()) +
            "\n Hours Required:\t\t"+ calcHourNeeded()
            
        );

    }//toString


}// HairSalon

