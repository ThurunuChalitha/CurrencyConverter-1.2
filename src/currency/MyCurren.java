package currency;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class MyCurren {

	private JFrame frmCurrencyConverter;
	private JTextField textInput;
	private JButton btnConvert;
	double usdTOgbp=0.73,usdTOlkr=199.58,usdTOjpy=109.79,usdTOcny=6.5,
			gbpTOlkr=271.93,gbpTOjpy=149.58,gbpTOcny=8.86,lkrTOjpy=0.55,
			lkrTOcny=0.033,jpyTOcny=0.059,usdTOinr=74.3,gbpTOinr=101.24,
			lkrTOinr=0.37,jpyTOinr=0.68,cnyTOinr=11.43;
	
	
	double val=0.0000 ;
	double amount=0.0000;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCurren window = new MyCurren();
					window.frmCurrencyConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyCurren() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrencyConverter = new JFrame();
		frmCurrencyConverter.setTitle("Currency Converter 1.0");
		frmCurrencyConverter.setIconImage(Toolkit.getDefaultToolkit().getImage(MyCurren.class.getResource("/currency/dollar.png")));
		frmCurrencyConverter.getContentPane().setBackground(new Color(245, 245, 245));
		frmCurrencyConverter.setBounds(100, 100, 921, 588);
		frmCurrencyConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrencyConverter.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CURRANCY CONVERTER");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 45));
		lblNewLabel.setBounds(183, 10, 549, 78);
		frmCurrencyConverter.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Convert  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(53, 217, 136, 31);
		frmCurrencyConverter.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Convert  to  :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(51, 271, 170, 31);
		frmCurrencyConverter.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Amount    =");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(53, 443, 170, 31);
		frmCurrencyConverter.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter the amount  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(53, 156, 258, 31);
		frmCurrencyConverter.getContentPane().add(lblNewLabel_1_2);
		
		textInput = new JTextField();
		textInput.setFont(new Font("Tahoma", Font.BOLD, 25));
		textInput.setBounds(344, 156, 149, 31);
		frmCurrencyConverter.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		
		JComboBox comboInput = new JComboBox();
		comboInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboInput.setModel(new DefaultComboBoxModel(new String[] {"USD($)", "GBP(\u00A3)", "JPY(\u00A5)", "INR(\u20B9)", "LKR(Rs)", "CNY(\u00A5)"}));
		comboInput.setBounds(344, 219, 149, 31);
		frmCurrencyConverter.getContentPane().add(comboInput);
		
		JComboBox comboOutput = new JComboBox();
		comboOutput.setModel(new DefaultComboBoxModel(new String[] {"USD($)", "GBP(\u00A3)", "JPY(\u00A5)", "INR(\u20B9)", "LKR(Rs)", "CNY(\u00A5)"}));
		comboOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboOutput.setBounds(344, 273, 149, 31);
		frmCurrencyConverter.getContentPane().add(comboOutput);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MyCurren.class.getResource("/currency/curren.png")));
		lblNewLabel_2.setBounds(634, 136, 231, 231);
		frmCurrencyConverter.getContentPane().add(lblNewLabel_2);
		
	
		JLabel lblOut = new JLabel("");
		lblOut.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblOut.setBounds(281, 443, 258, 31);
		frmCurrencyConverter.getContentPane().add(lblOut);
		
		
		JButton btnConvert = new JButton("CONVERT");
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConvert.setBounds(210, 366, 170, 45);
		frmCurrencyConverter.getContentPane().add(btnConvert);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    try {
			        Desktop desktop = null;
			        if (Desktop.isDesktopSupported()) {
			          desktop = Desktop.getDesktop();
			        }

			         desktop.open(new File("src/currency/Help.txt"));
			         } catch (IOException ioe) {
			        	 ioe.printStackTrace();
			        	 }
			    }
			});
		mntmNewMenuItem.setBounds(0, 0, 93, 24);
		frmCurrencyConverter.getContentPane().add(mntmNewMenuItem);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textInput.setText(" ");
				lblOut.setText(" ");
				textInput.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(430, 366, 142, 45);
		frmCurrencyConverter.getContentPane().add(btnClear);
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val*usdTOlkr;
					lblOut.setText("Rs "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val*usdTOgbp;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("$ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val*usdTOjpy;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val*usdTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="USD($)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val*usdTOinr;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val/usdTOgbp;
					lblOut.setText("$ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val*gbpTOjpy;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val*gbpTOinr;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val*gbpTOlkr;
					lblOut.setText("Rs "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="GBP(£)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val*gbpTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val/usdTOjpy;
					lblOut.setText("$ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val/gbpTOjpy;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val*jpyTOinr;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val/lkrTOjpy;
					lblOut.setText("Rs "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="JPY(¥)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val*jpyTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val/usdTOinr;
					lblOut.setText("$ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val/gbpTOinr;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val/jpyTOinr;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val/lkrTOinr;
					lblOut.setText("Rs "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="INR(₹)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val/cnyTOinr;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("Rs "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val/usdTOlkr;
					lblOut.setText("$ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val/gbpTOlkr;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val*lkrTOjpy;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val*lkrTOinr;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="LKR(Rs)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val*lkrTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="CNY(¥)") {
					double val =ExpNum();
					amount=val;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="USD($)") {
					double val =ExpNum();
					amount=val/usdTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="GBP(£)") {
					double val =ExpNum();
					amount=val/gbpTOcny;
					lblOut.setText("£ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="JPY(¥)") {
					double val =ExpNum();
					amount=val/jpyTOcny;
					lblOut.setText("¥ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="INR(₹)") {
					double val =ExpNum();
					amount=val*cnyTOinr;
					lblOut.setText("₹ "+String.valueOf(amount));
				}
				if(comboInput.getSelectedItem().toString()=="CNY(¥)" && comboOutput.getSelectedItem().toString()=="LKR(Rs)") {
					double val =ExpNum();
					amount=val/lkrTOcny;
					lblOut.setText("Rs "+String.valueOf(amount));
				}

							
			}
		});

	}
		
	public double  ExpNum() {
	
		try {
			amount=Double.parseDouble(textInput.getText());
			
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(btnConvert, e1);	
		}
		return amount;
	}
	

	private String getResource(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
