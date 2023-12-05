import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ReadAReceipt extends Frame implements ActionListener {

   EventTicket Ticket;

   private TextField priceField, nameField, quantityField, zoneField, dateField, totalField, discountField, salesTaxField, afterDiscountField, assistanceField, grandTotalField;	
   private Button next, done; 

   private DataInputStream input;

   //Constructor -- initialize the Frame 
   public ReadAReceipt() {
      super("Here is your receipt!");

      // Open the file
      try {
         input = new DataInputStream(new FileInputStream("receipt.dat"));
      }
      catch (IOException e) {
         System.err.println("File not opened properly\n" + e.toString());
         System.exit(1);
      }      

      setSize( 500, 400 );
      setLayout( new GridLayout( 12,2 ) );
      setBackground(Color.LIGHT_GRAY);

      // Get the size of the screen and center the window
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (((screenSize.width - this.getWidth()) / 1) / 2); 
      int y = (((screenSize.height - this.getHeight()) / 2) / 2);
      this.setLocation(x, y);

      // create the components of the Frame
      add(new Label("Event Name"));
      nameField = new TextField(20);
      nameField.setEditable(false);
      nameField.setForeground(Color.LIGHT_GRAY);
      add(nameField); 

      add(new Label("Event Date"));
      dateField = new TextField(20);
      dateField.setEditable(false);
      dateField.setForeground(Color.LIGHT_GRAY);
      add(dateField); 

      add(new Label("Zone"));
      zoneField = new TextField(20);
      zoneField.setEditable(false);
      zoneField.setForeground(Color.LIGHT_GRAY);
      add(zoneField);

      add(new Label("Wheelchair Assistance"));
      assistanceField = new TextField(20);
      assistanceField.setEditable(false);
      assistanceField.setForeground(Color.LIGHT_GRAY);
      add(assistanceField);

      add(new Label(" Price per Ticket"));
      priceField = new TextField(20);
      priceField.setEditable(false);
      priceField.setForeground(Color.LIGHT_GRAY);
      add(priceField);      

      add(new Label("Quantity"));
      quantityField = new TextField(20);
      quantityField.setEditable(false);
      quantityField.setForeground(Color.LIGHT_GRAY);
      add(quantityField);

      add(new Label("Discount"));
      discountField = new TextField(20);
      discountField.setEditable(false);
      discountField.setForeground(Color.LIGHT_GRAY);
      add(discountField);

      add(new Label("Total"));
      totalField = new TextField(20);
      totalField.setEditable(false);
      totalField.setForeground(Color.LIGHT_GRAY);
      add(totalField);

      add(new Label("Sales Tax"));
      salesTaxField = new TextField(20);
      salesTaxField.setEditable(false);
      salesTaxField.setForeground(Color.LIGHT_GRAY);
      add(salesTaxField);

      add(new Label("Discount"));
      afterDiscountField = new TextField(20);
      afterDiscountField.setEditable(false);
      afterDiscountField.setForeground(Color.LIGHT_GRAY);
      add(afterDiscountField);

      add(new Label("Grand Total"));
      grandTotalField = new TextField(20);
      grandTotalField.setEditable(false);
      grandTotalField.setForeground(Color.LIGHT_GRAY);
      add(grandTotalField);

      next = new Button("Next");
      next.addActionListener(this);
      add(next);      

      done = new Button("Done");
      done.addActionListener(this);
      add(done);       

      setVisible(true);  
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == next)
         readRecord();
      else
         closeFile();
   }

   public void readRecord() {
      String name;
      String date;
      char zone;
      char needsAssistance;
      Double price;
      int quantity;
      boolean hasDiscount;

      // input the values from the file
      try {
         name = input.readUTF();
         date = input.readUTF();
         zone = input.readChar();
         needsAssistance = input.readChar();
         price = input.readDouble(); 
         quantity = input.readInt();
         hasDiscount = input.readBoolean();
 
         Ticket = new EventTicket(name, date, zone, needsAssistance, price, quantity, hasDiscount);

         System.out.println(Ticket);
         
         NumberFormat fmt = NumberFormat.getCurrencyInstance();

         nameField.setText(name);
         dateField.setText(Ticket.date);
         zoneField.setText(String.valueOf(zone));
         assistanceField.setText(String.valueOf(needsAssistance));
         priceField.setText(String.valueOf(price));
         quantityField.setText(String.valueOf(quantity));
         discountField.setText(hasDiscount ? "Military Discount" : "No Discount");
 
         totalField.setText(String.valueOf(fmt.format(Ticket.calculateTotal()))); //format text
         salesTaxField.setText(String.valueOf(fmt.format(Ticket.calculateSalesTax()))); //format text
         afterDiscountField.setText(String.valueOf(fmt.format(Ticket.calculateDiscount()))); 
         grandTotalField.setText(String.valueOf(fmt.format(Ticket.calculateGrandTotal())));

      }
      catch (EOFException eof) {
         closeFile();
      }
      catch (IOException e) {
         System.err.println("Error during read from file\n" + e.toString());
         System.exit(1);
      }
   }

   private void closeFile() {
      try {
         input.close();
         System.exit(0);
      }
      catch (IOException e) {
         System.err.println("Error closing file\n" + e.toString());
         System.exit(1);
      }
   }
   public static void main(String args[]) {
      new ReadAReceipt();
   }

}


