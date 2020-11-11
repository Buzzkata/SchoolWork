import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//Bozhidar Stoyanov, 0353616
//PRogram that rolls a dice and displays the value of the dice. User chooses the sides of the dice.
public class DiceGUI { 

	private JFrame frame;
	private int rollN = 1;
	private int rollValue;
	private int userS;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiceGUI diceG = new DiceGUI();
					diceG.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DiceGUI() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dieOptions = new JLabel("Dice options");
		dieOptions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dieOptions.setBounds(10, 11, 103, 23);
		frame.getContentPane().add(dieOptions);
		
		JLabel newDie = new JLabel("New dice");
		newDie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newDie.setBounds(20, 45, 75, 14);
		frame.getContentPane().add(newDie);
			
		JLabel numOfSides = new JLabel("Number of sides:");
		numOfSides.setFont(new Font("Tahoma", Font.PLAIN, 14));
		numOfSides.setBounds(22, 82, 114, 23);
		frame.getContentPane().add(numOfSides);
		
		JTextPane userNS = new JTextPane();
		userNS.setBounds(146, 82, 60, 20);
		frame.getContentPane().add(userNS);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				
				if(userNS.getText().trim().equals("")== false){
					if(userNS.getText().matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")){ //regex to make sure it is numbers
						userS = Integer.parseInt(userNS.getText());
					
					}
					else{
						JOptionPane.showMessageDialog(null,"Ivalid entry"); //if users enters anything else but numbers
					}
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreate.setBounds(64, 116, 114, 32);
		frame.getContentPane().add(btnCreate);
		
		JTextPane outputTxtPane = new JTextPane();
		outputTxtPane.setEditable(false);
		outputTxtPane.setBounds(330, 45, 217, 230);
		frame.getContentPane().add(outputTxtPane);
		
		
		JButton btnRoll = new JButton("Roll current dice");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dice dice = new Dice(userS);
				dice.roll();
				rollValue = dice.getSideUp();
				
				String a = Integer.toString(rollN);
				String rv = Integer.toString(rollValue);
				
				outputTxtPane.setText("Roll n:" + a + "-> value of: " + rv); //not sure how to display every dice round so I used the setText method
				
				rollN++;
				
			}
		});
		btnRoll.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRoll.setBounds(58, 222, 190, 49);
		frame.getContentPane().add(btnRoll);
		
		JLabel rollHistory = new JLabel("Roll history");
		rollHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rollHistory.setBounds(330, 16, 86, 14);
		frame.getContentPane().add(rollHistory);
		
	
	}
}
