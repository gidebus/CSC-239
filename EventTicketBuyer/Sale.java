
public interface Sale {
    
    public double SalesTax = 0.0625;
    public double Discount = 0.25;
    public double SidesPrice =  150.00;
    public double CenterPrice = 235.00;
    public double TerracePrice = 500.00;

    public double calculateTotal();
    public double calculateSalesTax();
    public double calculateDiscount();
    public double calculateGrandTotal();
}
