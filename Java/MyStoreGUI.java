import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;

//Bozhidar Stoyanov, 0353616
//This is a virtual store GUI application in which one may choose from an array of computer related services.

public class MyStoreGUI {
	
	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyStoreGUI myStore = new MyStoreGUI();
					myStore.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MyStoreGUI() {  //create application
		initialize();
	}


	private void initialize() {  //initialize the frame
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnExit = new JButton("Exit");  //Exit button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				System.exit(0);
			}
		});
		btnExit.setBounds(185, 387, 89, 23);
		frame.getContentPane().add(btnExit);
		
		// Set up check box buttons. They can all be selected unlike the radio buttons
		JCheckBox cboxIHD = new JCheckBox("Install Hard Drive ($25.00)");
		cboxIHD.setBounds(24, 38, 171, 23);
		frame.getContentPane().add(cboxIHD);
		
		JCheckBox cboxIR = new JCheckBox("Install RAM ($15.00)");
		cboxIR.setBounds(24, 64, 145, 23);
		frame.getContentPane().add(cboxIR);
		
		JCheckBox cboxRV = new JCheckBox("Remove Virus ($50.00)");
		cboxRV.setBounds(24, 90, 167, 23);
		frame.getContentPane().add(cboxRV);
		
		JCheckBox cboxHD = new JCheckBox("Format Hard Drive ($80.00)");
		cboxHD.setBounds(24, 116, 207, 23);
		frame.getContentPane().add(cboxHD);
		
		JCheckBox cboxHL = new JCheckBox("Quote Hourly Labor ($10.00)");
		cboxHL.setBounds(24, 142, 228, 23);
		frame.getContentPane().add(cboxHL);
		
		//Radio buttons
		JRadioButton rbtnYW = new JRadioButton("1 year warranty $30");
		rbtnYW.setBounds(24, 205, 171, 23);
		frame.getContentPane().add(rbtnYW);
		
		JRadioButton rbtn2YW = new JRadioButton("2 year warranty $50");
		rbtn2YW.setBounds(24, 231, 171, 23);
		frame.getContentPane().add(rbtn2YW);
		
		JRadioButton rbtnD = new JRadioButton("Decline $0");
		rbtnD.setBounds(24, 257, 130, 23);
		frame.getContentPane().add(rbtnD);
		
		//Set up radio buttons so only one is selected 
		rbtnYW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnYW.isSelected()){
					rbtn2YW.setSelected(false);
					rbtnD.setSelected(false);
				}
			}
		});
		
		rbtn2YW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtn2YW.isSelected()){
					rbtnYW.setSelected(false);
					rbtnD.setSelected(false);
				}
			}
		});
		
		rbtnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnD.isSelected()){
					rbtnYW.setSelected(false);
					rbtn2YW.setSelected(false);
				}
			}
		});
		
		//Set up labels for our GUI
		JLabel lblWarranty = new JLabel("Warranty");
		lblWarranty.setBounds(24, 189, 55, 14);
		frame.getContentPane().add(lblWarranty);
		
		JLabel lblStandardServices = new JLabel("Standard Services");
		lblStandardServices.setBounds(24, 17, 167, 14);
		frame.getContentPane().add(lblStandardServices);
		
		JLabel lblHourlyServices = new JLabel("Hourly Services");
		lblHourlyServices.setBounds(24, 297, 100, 14);
		frame.getContentPane().add(lblHourlyServices);
		
		JLabel lblNewLabel = new JLabel("Parts Cost:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(24, 322, 100, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hours of Labour:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(24, 348, 130, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane userPartsCost = new JTextPane(); //user inputs cost of parts
		userPartsCost.setBounds(185, 316, 89, 20);
		frame.getContentPane().add(userPartsCost);
		
		JTextPane userHOL = new JTextPane(); //user inputs hours of labor
		userHOL.setBounds(185, 348, 89, 20);
		frame.getContentPane().add(userHOL);
		
		JButton btnCalculate = new JButton("Calculate Charges"); //Calculate button where all the services are added up
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalM = 0;
				double partsCost = 0;
				double hrsLabor = 0;
			
				
				if(userPartsCost.getText().trim().equals("")== false){  //if user inputs a value in the text field this executes
					if(userPartsCost.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){ //if user enters anything else but integers this wont execute and there wont be any error
						partsCost = Double.parseDouble(userPartsCost.getText());
					}
					
				}
			
				if(userHOL.getText().trim().equals("")==false){ //same here, if the text field is empty this code will not run and wont result in error
					if(userHOL.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){ //check if the user input is an integer
						hrsLabor = (Double.parseDouble(userHOL.getText()))*25; 
					}
					
				}
			
	
				totalM += partsCost + hrsLabor; //add total with the parts and hours of labor
				
				if(rbtnYW.isSelected()){
					totalM += 30;
				}
				else if(rbtn2YW.isSelected()){
					totalM += 50;
				}
				
				if(cboxIHD.isSelected()){ //install Hard Drive 25$
					totalM += 25;
				}
				if(cboxIR.isSelected()){ //install ram 15$
					totalM += 15;
				}
				if(cboxRV.isSelected()){ //remove virus 50$
					totalM += 50;
				}
				if(cboxHD.isSelected()){ //format hard drive 80$
					totalM += 80;
				}
			
				if(cboxHL.isSelected()){ //quote hourly labor 10$... add all the services here
					totalM += 10;
				}
				
				JOptionPane.showMessageDialog(null, String.format("Your total is: $%.2f", totalM)); //Display total cost in a JOptionPane
			
				
			}
		});
		btnCalculate.setBounds(24, 387, 145, 23);
		frame.getContentPane().add(btnCalculate);
		
	}
}
