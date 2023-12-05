	import java.io.*;
	import java.awt.*;
	import java.awt.event.*;

public class CreateAReceipt  extends Frame implements ActionListener {
	
	private TextField priceField, NameField, quantityField, dateField;							
	private Choice zoneField, discountField, assistanceField;

	private Button enter, done;

	class ZoneItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				updatePriceBasedOnZone();
			}
		}
		private void updatePriceBasedOnZone() {
			String selectedZone = zoneField.getSelectedItem();
	
			if(selectedZone.equals("Left of Stage") || selectedZone.equals("Right of Stage")) {
				priceField.setText(String.valueOf(Sale.SidesPrice));
			}
	
			if(selectedZone == "Center of Stage") {
				priceField.setText(String.valueOf(Sale.CenterPrice));
			}
	
			if(selectedZone == "Terrace - (VIP)") {
				priceField.setText(String.valueOf(Sale.TerracePrice));
			}
		}
	}

	private DataOutputStream output;  

	public CreateAReceipt() {
		super("Welcome To EventJavrite");

		// Open the file
		try {
			output = new DataOutputStream(new FileOutputStream("receipt.dat"));
		}
		catch ( IOException e ) {
			System.err.println( "File not opened properly\n" +
			e.toString() );
			System.exit( 1 );
		}      
	
		setSize( 500, 350 );
		setLayout( new GridLayout( 8, 2 ) );
	
		// Get the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (((screenSize.width - this.getWidth()) / 1) / 2); 
		int y = (((screenSize.height - this.getHeight()) / 2) / 2);
		this.setLocation(x, y);		

		// create the components of the Frame
		add(new Label(" Enter Event Name"));
		NameField = new TextField();
		add(NameField);  

		add(new Label(" Enter Event Date (MM-dd-yyyy):"));
		dateField = new TextField();
		add(dateField);  		
				
		add(new Label(" Select Zone"));
		zoneField = new Choice();
		zoneField.add("Left of Stage");
		zoneField.add("Center of Stage");
		zoneField.add("Right of Stage");
		zoneField.add("Terrace - (VIP)");
		zoneField.addItemListener(new ZoneItemListener());
		add(zoneField);

		add( new Label( "Do You Need Wheelchair Assistance?" ) );
		assistanceField = new Choice();
		assistanceField.add("Yes");
		assistanceField.add("No");
		add(assistanceField);
		
		add( new Label( " Price per Ticket" ) );
		priceField = new TextField();
		priceField.setEditable(false);
		priceField.setText(String.valueOf(Sale.SidesPrice)); // Default value
		priceField.setForeground(Color.LIGHT_GRAY);
		add(priceField );      

		add(new Label(" Enter Quantity"));
		quantityField = new TextField(  );
		add( quantityField );

		add( new Label( "Military Discount?" ) );
		discountField = new Choice();
		discountField.add("Yes");
		discountField.add("No");
		add(discountField);

		enter = new Button( "Enter" );
		enter.addActionListener( this );
		add( enter );      

		done = new Button( "Done" );
		done.addActionListener( this );
		add( done );       

		setVisible( true ); 
		NameField.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enter) addRecord();

		if (e.getSource() == done) {
			try {
				output.close();
			}
			catch (IOException io) {
				System.err.println("File not closed properly\n" + io.toString());
				System.exit(1);
			}

			System.exit(0);
		}
	}

	public void addRecord() {
		String tempItemName;
		String tempDate;
		char tempZone = ' ';
		char tempAssistance = ' ';		
		double tempPrice = 0.0;
		int tempQuantity = 0;
		boolean tempHasDiscount;

		if (!quantityField.getText().equals( "" )) {
			// output the values to the file
			try {
				tempItemName = NameField.getText();
				tempDate = dateField.getText();
				tempZone = zoneField.getSelectedItem().charAt(0);
				tempAssistance = assistanceField.getSelectedItem().charAt(0); 
				tempPrice = Double.parseDouble(priceField.getText());
				tempQuantity = Integer.parseInt( quantityField.getText());
				tempHasDiscount = discountField.getSelectedItem().equals("Yes");

				output.writeUTF(tempItemName);
				output.writeUTF(tempDate);
				output.writeChar(tempZone);
				output.writeChar(tempAssistance);
				output.writeDouble(tempPrice);
				output.writeInt(tempQuantity);
				output.writeBoolean(tempHasDiscount);
				
				// clear the TextFields
				NameField.setText( "" );
				dateField.setText("");
				zoneField.select(0);
				assistanceField.select(0);
				priceField.setText("");
				quantityField.setText( "" );
				discountField.select(0);
			}
			catch (NumberFormatException nfe) {
				System.err.println("You must enter valid numbers");
			}
			catch (IOException io) {
				System.err.println("Error during write to file\n" + io.toString());
				System.exit(1);
			}
		}
	}

	public static void main( String args[] )
	{
		new CreateAReceipt();
	}
}




