package cp213;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;


/**
 * Handles the GUI portion of the vending machine. May use other GUI classes for
 * individual elements of the vending machine. Should use the VendModel for all
 * control logic.
 *
 * @author Melissa Pinto
 * @version 2024-10-03
 */
@SuppressWarnings("serial")
public class VendView extends JFrame implements ActionListener {
	//buttons
	JButton vendButton = new JButton("Vend");
	JButton numberButton = new JButton("A0");
	JButton numberButton2 = new JButton("A1");
	JButton numberButton3 = new JButton("A2");
	JButton numberButton4 = new JButton("B0");
	JButton numberButton5 = new JButton("B1");
	JButton numberButton6 = new JButton("B2");
	JButton numberButton7 = new JButton("C0");
	JButton numberButton8 = new JButton("C1");
	JButton numberButton9 = new JButton("C2");
	JButton fiveCents = new JButton("5\u00A2");
	JButton tenCents = new JButton("10\u00A2");
	JButton twentyfiveCents = new JButton("25\u00A2");
	JButton oneDollar = new JButton("$1");
	JButton twoDollar = new JButton("$2");
	JButton fiveDollar = new JButton("$5");
	JButton tenDollar = new JButton("$10");

	double itemTotal = 0;
	Map<String, String> item;
	JLabel itemCostLabel = new JLabel();


	//item selection labels
	JLabel itemSelectionLabel = new JLabel("");
	JLabel itemSelectionLabel_1 = new JLabel("");
	JLabel itemSelectionLabel_2 = new JLabel("");
	JLabel itemSelectionLabel_3 = new JLabel("");
	JLabel itemSelectionLabel_4 = new JLabel("");
	JLabel itemSelectionLabel_5 = new JLabel("");
	JLabel itemSelectionLabel_6 = new JLabel("");
	JLabel itemSelectionLabel_7 = new JLabel("");
	JLabel itemSelectionLabel_8 = new JLabel("");

	//item counts
	int chocoCount = 0;
	int cokeCount = 0;
	int lemCount = 0;
	int sprCount = 0;
	int granCount = 0;
	int mentCount = 0;
	int ricCount = 0;
	int cookCount = 0;
	int craCount = 0;

	//output labels
	JLabel messageLabel = new JLabel("");
	JLabel statusLabel = new JLabel("");

	//money input 
	JLabel moneyInput = new JLabel("");
	double moneyInputCount = 0;

	//Other parts of the GUI design
	private final JLabel lblNewLabel_2 = new JLabel("Status:");
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	JLabel backgroundImage = new JLabel("");
	private final JPanel panel_6 = new JPanel();
	
	//Money in the machine. Will get "Machine out of money - Contact Operator" if out of change
	double change = 5.00;
	private final JLabel lblNewLabel_2_1 = new JLabel("Change:");
	private final JLabel changeLabel = new JLabel("");
	JButton btnNewTransaction = new JButton("New Transaction");
	JButton btnCancelSelection = new JButton("Cancel Selection");

	//item images
	JLabel chocolate = new JLabel();
	JLabel chocolate_1 = new JLabel();
	JLabel chocolate_2 = new JLabel();
	JLabel chocolate_2_1 = new JLabel();
	JLabel chocolate_2_2 = new JLabel();
	JLabel chocolate_2_3 = new JLabel();
	JLabel chocolate_2_3_1 = new JLabel();
	JLabel chocolate_2_3_2 = new JLabel();
	JLabel chocolate_2_3_3 = new JLabel();
	private final JLabel openLabel = new JLabel("");

	public VendView() {
		//Creating the Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 520);

		//inner panel setup
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 800, 520);
		getContentPane().add(panel);
		panel.setLayout(null);

		//background image
		backgroundImage.setIcon(new ImageIcon(new ImageIcon("vending machine.jpg").getImage().getScaledInstance(336, 491, Image.SCALE_DEFAULT)));
		
		//vend button
		vendButton.setFont(new Font("Arial", Font.BOLD, 16));
		vendButton.setBounds(537, 361, 216, 60);
		vendButton.addActionListener(this);
		panel.add(openLabel);
		panel.add(vendButton);
		vendButton.addActionListener(this);
		
		//open machine image
		openLabel.setBounds(26, 333, 306, 132);
		openLabel.setIcon(new ImageIcon(new ImageIcon("openimg.gif").getImage().getScaledInstance(336, 491, Image.SCALE_DEFAULT)));
		openLabel.setVisible(false);
		
		//item button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 192, 203));
		buttonPanel.setBounds(356, 21, 200, 103);
		panel.add(buttonPanel);
		numberButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton.setMargin(new Insets(2, 4, 2, 4));

		//layout for item buttons
		numberButton.addActionListener(this);
		buttonPanel.setLayout(new GridLayout(3, 3, 0, 0));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy=0;
		gbc.gridx=0;
		buttonPanel.add(numberButton);
		numberButton2.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton2.setMargin(new Insets(2, 4, 2, 4));

		numberButton2.addActionListener(this);
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.fill = GridBagConstraints.HORIZONTAL;
		gbc2.gridy=0;
		gbc2.gridx=1;
		buttonPanel.add(numberButton2);
		numberButton3.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton3.setMargin(new Insets(2, 4, 2, 4));
		
				numberButton3.addActionListener(this);
				GridBagConstraints gbc3 = new GridBagConstraints();
				gbc3.fill = GridBagConstraints.HORIZONTAL;
				gbc3.gridy=0;
				gbc3.gridx=2;
				buttonPanel.add(numberButton3);
		numberButton5.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton5.setMargin(new Insets(2, 4, 2, 4));

		numberButton5.addActionListener(this);
		numberButton4.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton4.setMargin(new Insets(2, 4, 2, 4));
		
				numberButton4.addActionListener(this);
				GridBagConstraints gbc4 = new GridBagConstraints();
				gbc4.fill = GridBagConstraints.HORIZONTAL;
				gbc4.gridy=1;
				gbc4.gridx=0;
				buttonPanel.add(numberButton4);
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.fill = GridBagConstraints.HORIZONTAL;
		gbc5.gridy=1;
		gbc5.gridx=1;
		buttonPanel.add(numberButton5);
		numberButton6.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton6.setMargin(new Insets(2, 4, 2, 4));

		numberButton6.addActionListener(this);
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.fill = GridBagConstraints.HORIZONTAL;
		gbc6.gridy=1;
		gbc6.gridx=2;
		buttonPanel.add(numberButton6);
		numberButton7.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton7.setMargin(new Insets(2, 4, 2, 4));
		
				numberButton7.addActionListener(this);
				buttonPanel.add(numberButton7);
		numberButton8.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton8.setMargin(new Insets(2, 4, 2, 4));
		
				numberButton8.addActionListener(this);
				buttonPanel.add(numberButton8);
		numberButton9.setAlignmentX(Component.CENTER_ALIGNMENT);
		numberButton9.setMargin(new Insets(2, 4, 2, 4));
		
				numberButton9.addActionListener(this);
				buttonPanel.add(numberButton9);
						GridBagConstraints gbc7 = new GridBagConstraints();
						gbc7.fill = GridBagConstraints.HORIZONTAL;
						gbc7.gridy=2;
						gbc7.gridx=0;
				GridBagConstraints gbc8 = new GridBagConstraints();
				gbc8.fill = GridBagConstraints.HORIZONTAL;
				gbc8.gridy=2;
				gbc8.gridx=1;
		GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.fill = GridBagConstraints.HORIZONTAL;
		gbc9.gridy=2;
		gbc9.gridx=2;

		//panel for money buttons
		JPanel buttonPanel_1 = new JPanel();
		buttonPanel_1.setBackground(new Color(216, 191, 216));
		buttonPanel_1.setBounds(356, 287, 148, 129);
		panel.add(buttonPanel_1);
		fiveCents.setMargin(new Insets(2, 4, 2, 4));
		fiveCents.setFont(new Font("Tahoma", Font.PLAIN, 9));
		fiveCents.setPreferredSize(new Dimension(47, 25));

		//action listeners for money buttons
		fiveCents.addActionListener(this);
		tenCents.setMargin(new Insets(2, 4, 2, 4));
		tenCents.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tenCents.setPreferredSize(new Dimension(47, 25));
		tenCents.addActionListener(this);
		twentyfiveCents.setMargin(new Insets(2, 4, 2, 4));
		twentyfiveCents.setFont(new Font("Tahoma", Font.PLAIN, 9));
		twentyfiveCents.setPreferredSize(new Dimension(47, 25));
		twentyfiveCents.addActionListener(this);
		oneDollar.setMargin(new Insets(2, 4, 2, 4));
		oneDollar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		oneDollar.setPreferredSize(new Dimension(47, 25));
		oneDollar.addActionListener(this);
		twoDollar.setMargin(new Insets(2, 4, 2, 4));
		twoDollar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		twoDollar.setPreferredSize(new Dimension(47, 25));
		twoDollar.addActionListener(this);
		fiveDollar.setMargin(new Insets(2, 4, 2, 4));
		fiveDollar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		fiveDollar.setPreferredSize(new Dimension(47, 25));
		fiveDollar.addActionListener(this);

		//add money buttons to panel
		buttonPanel_1.add(fiveCents);
		buttonPanel_1.add(tenCents);
		buttonPanel_1.add(twentyfiveCents);
		buttonPanel_1.add(oneDollar);
		buttonPanel_1.add(twoDollar);
		buttonPanel_1.add(fiveDollar);
		tenDollar.setMargin(new Insets(2, 4, 2, 4));
		tenDollar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		tenDollar.setPreferredSize(new Dimension(47, 25));
		buttonPanel_1.add(tenDollar);
		tenDollar.addActionListener(this);

		//item selection title label
		JLabel lblNewLabel = new JLabel("Item Selection:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(364, 187, 89, 14);
		panel.add(lblNewLabel);
		itemSelectionLabel.setBounds(458, 187, 106, 14);
		panel.add(itemSelectionLabel);

		//item cost title label
		JLabel lblItemCost = new JLabel();
		lblItemCost.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemCost.setBounds(364, 162, 80, 14);
		lblItemCost.setText("Your Total: $");
		panel.add(lblItemCost);

		//item cost output label
		itemCostLabel.setBackground(Color.WHITE);
		itemCostLabel.setBounds(446, 162, 99, 14);

		panel.add(itemCostLabel);
		
		//money title label
		JLabel lblMoneyInput = new JLabel("Money Input:");
		lblMoneyInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMoneyInput.setBounds(364, 438, 89, 14);
		panel.add(lblMoneyInput);
		
		// money input label
		JLabel moneyInputLabel = new JLabel("");
		moneyInputLabel.setBounds(458, 333, 80, 14);
		panel.add(moneyInputLabel);
		messageLabel.setForeground(Color.RED);
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 10));

		//out of stock label
		messageLabel.setBounds(364, 135, 422, 14);
		messageLabel.setText(" is out of stock");
		panel.add(messageLabel);

		//item selection labels
		itemSelectionLabel_1.setBackground(Color.WHITE);
		itemSelectionLabel_1.setBounds(458, 204, 106, 14);
		panel.add(itemSelectionLabel_1);

		itemSelectionLabel_2.setBackground(Color.WHITE);
		itemSelectionLabel_2.setBounds(458, 221, 106, 14);
		panel.add(itemSelectionLabel_2);

		itemSelectionLabel_3.setBackground(Color.WHITE);
		itemSelectionLabel_3.setBounds(570, 187, 106, 14);
		panel.add(itemSelectionLabel_3);

		itemSelectionLabel_4.setBackground(Color.WHITE);
		itemSelectionLabel_4.setBounds(570, 204, 106, 14);
		panel.add(itemSelectionLabel_4);

		itemSelectionLabel_5.setBackground(Color.WHITE);
		itemSelectionLabel_5.setBounds(570, 221, 106, 14);
		panel.add(itemSelectionLabel_5);

		itemSelectionLabel_6.setBackground(Color.WHITE);
		itemSelectionLabel_6.setBounds(680, 221, 106, 14);
		panel.add(itemSelectionLabel_6);

		itemSelectionLabel_7.setBackground(Color.WHITE);
		itemSelectionLabel_7.setBounds(680, 204, 106, 14);
		panel.add(itemSelectionLabel_7);

		itemSelectionLabel_8.setBackground(Color.WHITE);
		itemSelectionLabel_8.setBounds(680, 187, 106, 14);
		panel.add(itemSelectionLabel_8);

		//status title label
		JLabel lblNewLabel_1 = new JLabel("Status:");
		panel.add(lblNewLabel_1);

		//panel for cancel button
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(356, 185, 420, 94);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		//cancel button
		btnCancelSelection.setBounds(280, 67, 136, 23);
		panel_1.add(btnCancelSelection);
		btnCancelSelection.addActionListener(this);

		//finish panel
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 224, 230));
		panel_2.setBounds(514, 287, 262, 178);
		panel.add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 11, 53, 23);
		panel_2.add(lblNewLabel_2);
		statusLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		statusLabel.setBounds(53, 11, 205, 23);
		panel_2.add(statusLabel);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(10, 35, 53, 23);

		panel_2.add(lblNewLabel_2_1);
		changeLabel.setBounds(60, 35, 199, 23);

		panel_2.add(changeLabel);

		//new transaction button
		btnNewTransaction.addActionListener(this);
		btnNewTransaction.setBounds(24, 144, 215, 23);
		panel_2.add(btnNewTransaction);
		
		//money input panel
		panel_3.setBackground(new Color(216, 191, 216));
		panel_3.setBounds(356, 427, 148, 38);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		//money input label
		moneyInput.setBounds(91, 11, 57, 14);
		panel_3.add(moneyInput);
		
		//total cost panel
		panel_4.setBackground(new Color(245, 222, 179));
		panel_4.setBounds(356, 158, 420, 23);
		panel.add(panel_4);
		
		//out of stock panel
		panel_5.setBackground(new Color(173, 216, 230));
		panel_5.setBounds(356, 130, 420, 23);
		panel.add(panel_5);
		
		//inside machine panel
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(26, 11, 306, 320);
		panel.add(panel_6);
		panel_6.setLayout(null);

		//item images
		chocolate.setBounds(30, 41, 54, 54);
		panel_6.add(chocolate);
		chocolate.setIcon(new ImageIcon(new ImageIcon("chocolate-bar-small.png").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_1.setBounds(120, 41, 54, 54);
		panel_6.add(chocolate_1);
		chocolate_1.setIcon(new ImageIcon(new ImageIcon("coke.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2.setBounds(215, 41, 54, 54);
		panel_6.add(chocolate_2);
		chocolate_2.setIcon(new ImageIcon(new ImageIcon("lemon.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_1.setBounds(30, 134, 54, 54);
		panel_6.add(chocolate_2_1);
		chocolate_2_1.setIcon(new ImageIcon(new ImageIcon("sprite.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_3_1.setBounds(30, 219, 54, 54);
		panel_6.add(chocolate_2_3_1);
		chocolate_2_3_1.setIcon(new ImageIcon(new ImageIcon("ricecrisp.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_2.setBounds(120, 134, 54, 54);
		panel_6.add(chocolate_2_2);
		chocolate_2_2.setIcon(new ImageIcon(new ImageIcon("granola.jpeg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_3.setBounds(215, 134, 54, 54);
		panel_6.add(chocolate_2_3);
		chocolate_2_3.setIcon(new ImageIcon(new ImageIcon("mentos.png").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_3_2.setBounds(120, 219, 54, 54);
		panel_6.add(chocolate_2_3_2);
		chocolate_2_3_2.setIcon(new ImageIcon(new ImageIcon("cookie.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));

		chocolate_2_3_3.setBounds(215, 219, 54, 54);
		panel_6.add(chocolate_2_3_3);
		chocolate_2_3_3.setIcon(new ImageIcon(new ImageIcon("crackers.jpg").getImage().getScaledInstance(54, 54, Image.SCALE_DEFAULT)));
		
		//item identification labels
		JLabel lblA = new JLabel("A0");
		lblA.setBounds(51, 26, 46, 14);
		panel_6.add(lblA);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_2 = new JLabel("A1");
		lblA_2.setBounds(141, 26, 46, 14);
		panel_6.add(lblA_2);
		lblA_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_3 = new JLabel("A2");
		lblA_3.setBounds(235, 26, 46, 14);
		panel_6.add(lblA_3);
		lblA_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_1 = new JLabel("B0");
		lblA_1.setBounds(51, 118, 46, 14);
		panel_6.add(lblA_1);
		lblA_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_5 = new JLabel("B1");
		lblA_5.setBounds(141, 118, 46, 14);
		panel_6.add(lblA_5);
		lblA_5.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_6 = new JLabel("B2");
		lblA_6.setBounds(235, 118, 46, 14);
		panel_6.add(lblA_6);
		lblA_6.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_8 = new JLabel("C1");
		lblA_8.setBounds(141, 203, 46, 14);
		panel_6.add(lblA_8);
		lblA_8.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_7 = new JLabel("C2");
		lblA_7.setBounds(235, 203, 46, 14);
		panel_6.add(lblA_7);
		lblA_7.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblA_4 = new JLabel("C0");
		lblA_4.setBounds(51, 203, 46, 14);
		panel_6.add(lblA_4);
		lblA_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//background image
		backgroundImage.setBounds(10, 11, 336, 455);
		panel.add(backgroundImage);

		//instructions panel
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(176, 224, 230));
		panel_7.setBounds(566, 21, 210, 38);
		panel.add(panel_7);
		panel_7.setLayout(null);

		//instructions label
		JLabel lblNewLabel_3 = new JLabel("<-- Choose an item here");
		lblNewLabel_3.setBounds(10, 11, 190, 14);
		panel_7.add(lblNewLabel_3);

		//program title panel
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBackground(new Color(176, 224, 230));
		panel_7_1.setBounds(566, 70, 210, 54);
		panel.add(panel_7_1);

		//program title label
		JLabel lblNewLabel_3_1 = new JLabel("Vending Machine");
		lblNewLabel_3_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(10, 11, 190, 32);
		panel_7_1.add(lblNewLabel_3_1);
		messageLabel.setVisible(false);

		//make frame visible
		setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//action for A0 button
		if (e.getSource() == numberButton) {
			item = VendModel.costItems();
			String itemCost = item.get("Chocolate");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			chocoCount = chocoCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Chocolate");
			itemSelectionLabel.setText(" Chocolate(" + chocoCount + ")" );
			if (chocoCount >= Integer.parseInt(itemAmount)){
				String choco = "Chocolate";
				chocolate.setVisible(false);
				outOfStock(choco);
				numberButton.setEnabled(false);
			}
		}

		//action for A1 button
		if (e.getSource() == numberButton2) {
			item = VendModel.costItems();
			String itemCost = item.get("Coke");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			cokeCount = cokeCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Coke");
			itemSelectionLabel_3.setText(" Coke(" + cokeCount + ")" );
			if (cokeCount >= Integer.parseInt(itemAmount)){
				String coke = "Coke";
				chocolate_1.setVisible(false);
				outOfStock(coke);
				numberButton2.setEnabled(false);
			}
		}

		//action for A2 button
		if (e.getSource() == numberButton3) {
			item = VendModel.costItems();
			String itemCost = item.get("Lemonade");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			lemCount = lemCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Lemonade");
			itemSelectionLabel_8.setText(" Lemonade(" + lemCount + ")" );
			if (lemCount >= Integer.parseInt(itemAmount)){
				String lem = "Lemonade";
				outOfStock(lem);
				chocolate_2.setVisible(false);
				numberButton3.setEnabled(false);
			}
		}

		//action for B0 button
		if (e.getSource() == numberButton4) {
			item = VendModel.costItems();
			String itemCost = item.get("Sprite");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			sprCount = sprCount + 1;
			System.out.print(sprCount);
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Sprite");
			itemSelectionLabel_1.setText(" Sprite(" + sprCount + ")" );
			if (sprCount >= Integer.parseInt(itemAmount)){
				String spr = "Sprite";
				outOfStock(spr);
				chocolate_2_1.setVisible(false);
				numberButton4.setEnabled(false);
			}
		}

		//action for B1 button
		if (e.getSource() == numberButton5) {
			item = VendModel.costItems();
			String itemCost = item.get("Granola Bar");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			granCount = granCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Granola Bar");
			itemSelectionLabel_4.setText(" Granola Bar(" + granCount + ")" );
			if (granCount >= Integer.parseInt(itemAmount)){
				String gran = "Granola Bar";
				outOfStock(gran);
				chocolate_2_2.setVisible(false);
				numberButton5.setEnabled(false);
			}
		}

		//action for B2 button
		if (e.getSource() == numberButton6) {
			item = VendModel.costItems();
			String itemCost = item.get("Mentos");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			mentCount = mentCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Mentos");
			itemSelectionLabel_7.setText(" Mentos(" + mentCount + ")" );
			if (mentCount >= Integer.parseInt(itemAmount)){
				String ment = "Mentos";
				outOfStock(ment);
				chocolate_2_3.setVisible(false);
				numberButton6.setEnabled(false);
			}
		}

		//action for C0 button
		if (e.getSource() == numberButton7) {
			item = VendModel.costItems();
			String itemCost = item.get("Rice Crispy");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			ricCount = ricCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Rice Crispy");
			itemSelectionLabel_2.setText(" Rice Crispy(" + ricCount + ")" );
			if (ricCount >= Integer.parseInt(itemAmount)){
				String rice = "Rice Crispy";
				outOfStock(rice);
				chocolate_2_3_1.setVisible(false);
				numberButton7.setEnabled(false);
			}
		}

		//action for C1 button
		if (e.getSource() == numberButton8) {
			item = VendModel.costItems();
			String itemCost = item.get("Cookie");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			cookCount = cookCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Cookie");
			itemSelectionLabel_5.setText(" Cookie(" + cookCount + ")" );
			if (cookCount >= Integer.parseInt(itemAmount)){
				String cookie = "Cookie";
				outOfStock(cookie);
				chocolate_2_3_2.setVisible(false);
				numberButton8.setEnabled(false);
			}
		}

		//action for C2 button
		if (e.getSource() == numberButton9) {
			item = VendModel.costItems();
			String itemCost = item.get("Crackers");
			itemTotal =  Double.parseDouble(itemCost) + itemTotal;
			itemCostLabel.setText(Double.toString(itemTotal));
			craCount = craCount + 1;
			Map<String, String> itemNumber = VendModel.numberOfItems();
			String itemAmount = itemNumber.get("Crackers");
			itemSelectionLabel_6.setText(" Crackers(" + craCount + ")" );
			if (craCount >= Integer.parseInt(itemAmount)){
				String crackers = "Crackers";
				outOfStock(crackers);
				chocolate_2_3_3.setVisible(false);
				numberButton9.setEnabled(false);
			}
		}

		//action for cancel button
		if (e.getSource() == btnCancelSelection) {
			itemCostLabel.setText("");
			itemSelectionLabel.setText("");
			itemSelectionLabel_1.setText("");
			itemSelectionLabel_2.setText("");
			itemSelectionLabel_3.setText("");
			itemSelectionLabel_4.setText("");
			itemSelectionLabel_5.setText("");
			itemSelectionLabel_6.setText("");
			itemSelectionLabel_7.setText("");
			itemSelectionLabel_8.setText("");
			itemTotal = 0;
			moneyInputCount = 0;
			moneyInput.setText("");
			changeLabel.setText("");
			statusLabel.setText("");

		}

		//action for 5 cents button
		if (e.getSource() == fiveCents) {
			moneyInputCount = moneyInputCount + 0.05;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 10 cents button
		if (e.getSource() == tenCents) {
			moneyInputCount = moneyInputCount + 0.10;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 25 cents button
		if (e.getSource() == twentyfiveCents) {
			moneyInputCount = moneyInputCount + 0.25;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 1 dollar button
		if (e.getSource() == oneDollar) {
			moneyInputCount = moneyInputCount + 1.00;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 2 button
		if (e.getSource() == twoDollar) {
			moneyInputCount = moneyInputCount + 2.00;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 5 button
		if (e.getSource() == fiveDollar) {
			moneyInputCount = moneyInputCount + 5.00;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		//action for 10 button
		if (e.getSource() == tenDollar) {
			moneyInputCount = moneyInputCount + 10.00;
			moneyInput.setText(Double.toString(moneyInputCount));
		}
		
		

		//action for vend button

		if (e.getSource() == vendButton) {

		    double doubMoneyInput = 0;
		    double doubCost = Double.parseDouble(itemCostLabel.getText());

		    // Check if money input is empty or invalid
		    if (moneyInput.getText().isEmpty()) {
		        statusLabel.setForeground(Color.RED);
		        statusLabel.setText("Please insert money to complete transaction.");
		        return;
		    }

		    // Try to parse the money input, and catch any exceptions for invalid input
		    try {
		        doubMoneyInput = Double.parseDouble(moneyInput.getText());
		    } catch (NumberFormatException ex) {
		        statusLabel.setForeground(Color.RED);
		        statusLabel.setText("Invalid money input. Please enter a valid amount.");
		        return;
		    }

		    if (doubMoneyInput <= 0) {
		        statusLabel.setForeground(Color.RED);
		        statusLabel.setText("Please insert money to complete transaction.");
		        return;
		    }

		    if (doubMoneyInput < doubCost) {
		        statusLabel.setForeground(Color.RED);
		        statusLabel.setText("Not enough money inputted!");
		    } else if (doubMoneyInput > doubCost) {
		        double changeDifference = doubMoneyInput - doubCost;

		        if (change - changeDifference >= 0) {
		            change = change - changeDifference + itemTotal;
		            changeLabel.setText("Your change is: $" + String.format("%.2f", changeDifference));
		            statusLabel.setForeground(Color.RED);
		            statusLabel.setText("Vending! Enjoy your food :)");
		            itemCostLabel.setText("");
					itemSelectionLabel.setText("");
					itemSelectionLabel_1.setText("");
					itemSelectionLabel_2.setText("");
					itemSelectionLabel_3.setText("");
					itemSelectionLabel_4.setText("");
					itemSelectionLabel_5.setText("");
					itemSelectionLabel_6.setText("");
					itemSelectionLabel_7.setText("");
					itemSelectionLabel_8.setText("");
					moneyInputCount = 0;
					moneyInput.setText("");
					openLabel.setVisible(true);
					// Disable all buttons except the "New Transaction" button
			        disableAllButtonsExceptNewTransaction();
		        } else {
		        	statusLabel.setForeground(Color.RED);
		        	statusLabel.setFont(new Font("Tacoma", Font.PLAIN, 9));
		            statusLabel.setText("Machine out of money - Contact Operator");
		        }
		    } else {
		    	statusLabel.setForeground(Color.RED);
		        statusLabel.setText("Vending! Enjoy your food :)");
		        itemCostLabel.setText("");
				itemSelectionLabel.setText("");
				itemSelectionLabel_1.setText("");
				itemSelectionLabel_2.setText("");
				itemSelectionLabel_3.setText("");
				itemSelectionLabel_4.setText("");
				itemSelectionLabel_5.setText("");
				itemSelectionLabel_6.setText("");
				itemSelectionLabel_7.setText("");
				itemSelectionLabel_8.setText("");
				change = change + itemTotal;
				moneyInputCount = 0;
				moneyInput.setText("");
				openLabel.setVisible(true);
				// Disable all buttons except the "New Transaction" button
		        disableAllButtonsExceptNewTransaction();
		    }
		}

		if (e.getSource() == btnNewTransaction){
			enableAllButtonsExceptNewTransaction();
			changeLabel.setText("");
			statusLabel.setText("");
			statusLabel.setForeground(Color.black);
			itemTotal = 0;
			openLabel.setVisible(false);
		}

	}

	//method for when an item is out of stock
	private void outOfStock(String item) {
		messageLabel.setVisible(true);
		messageLabel.setText(" " + item + messageLabel.getText());

		

	}
	
	// Helper method to disable all buttons except the "New Transaction" button
	private void disableAllButtonsExceptNewTransaction() {
	    numberButton.setEnabled(false);
	    numberButton2.setEnabled(false);
	    numberButton3.setEnabled(false);
	    numberButton4.setEnabled(false);
	    numberButton5.setEnabled(false);
	    numberButton6.setEnabled(false);
	    numberButton7.setEnabled(false);
	    numberButton8.setEnabled(false);
	    numberButton9.setEnabled(false);

	    fiveCents.setEnabled(false);
	    tenCents.setEnabled(false);
	    twentyfiveCents.setEnabled(false);
	    oneDollar.setEnabled(false);
	    twoDollar.setEnabled(false);
	    fiveDollar.setEnabled(false);
	    tenDollar.setEnabled(false);
	    
	    btnCancelSelection.setEnabled(false);
	    vendButton.setEnabled(false);

	    // Keep only the New Transaction button enabled
	    btnNewTransaction.setEnabled(true);
	}
	
	// Helper method to disable all buttons except the "New Transaction" button
		private void enableAllButtonsExceptNewTransaction() {
		    numberButton.setEnabled(true);
		    numberButton2.setEnabled(true);
		    numberButton3.setEnabled(true);
		    numberButton4.setEnabled(true);
		    numberButton5.setEnabled(true);
		    numberButton6.setEnabled(true);
		    numberButton7.setEnabled(true);
		    numberButton8.setEnabled(true);
		    numberButton9.setEnabled(true);

		    fiveCents.setEnabled(true);
		    tenCents.setEnabled(true);
		    twentyfiveCents.setEnabled(true);
		    oneDollar.setEnabled(true);
		    twoDollar.setEnabled(true);
		    fiveDollar.setEnabled(true);
		    tenDollar.setEnabled(true);
		    
		    btnCancelSelection.setEnabled(true);
		    vendButton.setEnabled(true);

		}

}
