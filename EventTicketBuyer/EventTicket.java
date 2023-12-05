import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventTicket implements Sale {
  String name;
  String date;
  char zone;
  char needsAssistance;
  double price;
  int quantity;
  boolean hasDiscount;

  public EventTicket(String name, String date, char zone, char needsAssistance, double price, int quantity, boolean hasDiscount) {
    this.name = name;
    this.date = formatDate(date);
    this.zone = zone;
    this.needsAssistance = needsAssistance;
    this.price = price;
    this.quantity = quantity;
    this.hasDiscount = hasDiscount;
  }


  EventTicket(String name, String date, String zone, String needsAssistance, String price, String quantity, String hasDiscount) {
    try {
      this.name = name;
      this.date = date;
      this.zone = zone.charAt(0);
      this.needsAssistance = needsAssistance.charAt(0);
      this.price = Double.parseDouble(price);
      this.quantity = Integer.parseInt(quantity);
      this.hasDiscount = Boolean.parseBoolean(hasDiscount);
    }
    catch(NumberFormatException e)
    {
      System.out.println("Invalid format"+ e);

      this.name  = "";  
      this.date = "";
      this.zone = ' ';
      this.needsAssistance = ' ';
      this.price = 0.0;
      this.quantity= 0;
      this.hasDiscount = false;

    }

  }

  public double calculateTotal() {
    return  price * quantity;
  }

  public double calculateDiscount() {
    double discount;
    if(hasDiscount) {
      discount = calculateTotal() * Sale.Discount;
    } else {
      discount = 0;
    }
    return discount;
  }

  public double calculateSalesTax() {
    double salesTax = calculateTotal() * Sale.SalesTax;
    return salesTax;
  }

  public double calculateGrandTotal() {
    double grandTotal = calculateTotal() + calculateSalesTax() - calculateDiscount();
    return grandTotal;
  }

  public String formatDate(String dateString) {
    try {
      SimpleDateFormat inputDate = new SimpleDateFormat("MM-dd-yyyy");
      SimpleDateFormat outputDate = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
      Date date = inputDate.parse(dateString);
      return outputDate.format(date);
    } catch(Exception e) {
      return "Could not format date";
    }
  }

  public String toString() {
  
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    return (
      "\n Event Name:\t\t"+ this.name +
      "\n Event Date:\t\t"+ this.date +
      "\n Has: \t\t\t" + (this.hasDiscount ? "Military Discount":"No Discount" ) +
      "\n Zone:\t\t\t"+ zone +
      "\n Quantity:\t\t"+ quantity +
      "\n Wheelchair Assistance:\t"+ needsAssistance +
      "\n Unit Total:\t\t"+ fmt.format(price) +
      "\n Total Cost:\t\t"+ fmt.format(calculateTotal()) +
      "\n Discount:\t\t"+ fmt.format(calculateDiscount()) +
      "\n Sales Tax:\t\t"+ fmt.format(calculateSalesTax()) + 
      "\n Grand Total:\t\t"+ fmt.format(calculateSalesTax())
    );

  }

}

