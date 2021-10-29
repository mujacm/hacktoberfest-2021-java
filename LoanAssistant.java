package loanassistant;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;



public class LoanAssistant extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loanbalance;
	private JTextField interestrate;
	private JTextField noofpayments;
	private JTextField monthlypayment;
	private JTextArea loananalysis;
	private JButton computebtn;
	private JButton newanalysisbtn;
	private JButton exitbtn;
	private JButton paymentbtn;
	private JButton monthbtn;
	Color lightYellow = new Color(255, 255, 128);
	boolean computePayment;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					LoanAssistant frame = new LoanAssistant();
				
					frame.setTitle("Loan Assistant");
					frame.setVisible(true);				
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public LoanAssistant() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\bank.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300,150,1014,597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.lightGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoanBalance = new JLabel("Loan Balance");
		lblLoanBalance.setFont(new Font("Tahoma",Font.PLAIN,20));
		lblLoanBalance.setBounds(58, 50, 130, 50);
		contentPane.add(lblLoanBalance);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblInterestRate.setBounds(58, 152, 130, 43);
		contentPane.add(lblInterestRate);
		
		JLabel lblNumberOfPayments = new JLabel("Number of Payments");
		lblNumberOfPayments.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblNumberOfPayments.setBounds(58, 243, 200, 29);
		contentPane.add(lblNumberOfPayments);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment");
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblMonthlyPayment.setBounds(58, 324, 170, 36);
		contentPane.add(lblMonthlyPayment);
		
		JLabel lblLoanAnalysis = new JLabel("Loan Analysis:");
		lblLoanAnalysis.setFont(new Font("Tahoma", Font.PLAIN,20));
		lblLoanAnalysis.setBounds(600, 50, 150, 36);
		contentPane.add(lblLoanAnalysis);
		
		loanbalance = new JTextField();
		loanbalance.setFont(new Font("Tahoma",Font.PLAIN, 25));
		loanbalance.setBounds(255, 50, 228, 50);
		contentPane.add(loanbalance);
		loanbalance.setColumns(10);
		
		interestrate = new JTextField();
		interestrate.setFont(new Font("Tahoma",Font.PLAIN, 25));
		interestrate.setBounds(255 , 151, 228, 50);
		contentPane.add(interestrate);
		interestrate.setColumns(10);
		
		noofpayments = new JTextField();
		noofpayments.setFont(new Font("Tahoma", Font.PLAIN, 25));
		noofpayments.setBounds(255, 235, 228, 50);
		contentPane.add(noofpayments);
		noofpayments.setColumns(10);
		
		monthlypayment = new JTextField();
		monthlypayment.setFont(new Font("Tahoma", Font.PLAIN, 25));
		monthlypayment.setBounds(255, 320, 228, 50);
		contentPane.add(monthlypayment);
		monthlypayment.setColumns(10);
		
		loananalysis = new JTextArea();
		loananalysis.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loananalysis.setBounds(600, 100, 370, 350);
		loananalysis.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		contentPane.add(loananalysis);
		loananalysis.setColumns(10);
		
		computebtn = new JButton("Compute Monthly Payment");
		computebtn.setFont(new Font("Tahoma", Font.BOLD,20));
		computebtn.setBounds(90, 405, 350, 50);
		contentPane.add(computebtn);
		
		computebtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				computebtnActionPerformed(e);
			}

			private void computebtnActionPerformed(ActionEvent e) {
				
				double balance,interest,payment;
				int months;
				double monthlyInterest, multiplier;
				double loanBalance, finalPayment;
				
				if(validateDecimalNumber(loanbalance)) {
					balance = Double.valueOf(loanbalance.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.","Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(validateDecimalNumber(interestrate)) {
					interest = Double.valueOf(interestrate.getText()).doubleValue();
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate enty.\nPlease correct.","Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				monthlyInterest = interest/1200;
				
				if(!computePayment) {
					
					if(validateDecimalNumber(noofpayments)) {
						months = Integer.valueOf(noofpayments.getText()).intValue();
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or empty No of Payments.\nPlease correct","Monthly Payments Input Error", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(interest == 0)
					{
						payment = balance/months;
					}
					else
					{
					multiplier = Math.pow(1 + monthlyInterest, months);
				
					payment = balance * monthlyInterest * multiplier /(multiplier-1);
					}
				
					monthlypayment.setText(new DecimalFormat("0.00").format(payment));
			}
			else
			{
				if(validateDecimalNumber(monthlypayment)) {
					payment = Double.valueOf(monthlypayment.getText()).doubleValue();
					if(payment <= (balance*monthlyInterest+1.0))
					{
						if(JOptionPane.showConfirmDialog(null, "Minimum payments must be $ "+new DecimalFormat("0.00").format((int)(balance*monthlyInterest+1.0))+"\n"+"Do You want to use the minimum payment?","Input Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
						{
							monthlypayment.setText(new DecimalFormat("0.00").format((int)(balance*monthlyInterest+1.0)));
							payment = Double.valueOf(monthlypayment.getText()).doubleValue();
						}
						else
						{
							monthlypayment.requestFocus();
							return;
						}
					}
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment.\nPlease corect.","Number of Payment Error Meaasge",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(interest == 0)
				{
					months = (int)(balance/payment);
				}
				else {
				months = (int)((Math.log(payment)-Math.log(payment-balance*monthlyInterest))/Math.log(1+monthlyInterest));
				}
				noofpayments.setText(String.valueOf(months));
			}
			

			
			loananalysis.setText("Loan Balance: $"+new DecimalFormat("0.00").format(balance));
			loananalysis.append("\n"+"Interest Rate: "+new DecimalFormat("0.00").format(interest)+"%");
			
			loanBalance = balance;
			
			for(int paymentNumber = 1; paymentNumber <= months-1; paymentNumber++) {
				loanBalance += loanBalance * monthlyInterest-payment;  
			}
			
			finalPayment = loanBalance;
			if(finalPayment>payment)
			{
				loanBalance += loanBalance * monthlyInterest - payment;
				finalPayment = loanBalance;
				months++;
				
				noofpayments.setText(String.valueOf(months));
			}
			
			loananalysis.append("\n\n" + String.valueOf(months-1)+" Payments of $" +new DecimalFormat("0.00").format(payment));
			loananalysis.append("\n"+"Final Payments of"+ new DecimalFormat("0.00").format(finalPayment));
			loananalysis.append("\n"+"Total Payments: $"+new DecimalFormat("0.00").format((months-1)*payment+finalPayment));
			loananalysis.append("\n"+"Interest Paid: $"+new DecimalFormat("0.00").format((months-1)*payment+finalPayment-balance));
			computebtn.setEnabled(false);
			newanalysisbtn.setEnabled(true);
			newanalysisbtn.requestFocus();
		}
		});
			
			
		
		newanalysisbtn = new JButton("New Loan Analysis");
		newanalysisbtn.setFont(new Font("Tahoma", Font.BOLD,20));
		newanalysisbtn.setBounds(130, 480, 250, 50);
		newanalysisbtn.setEnabled(false);
		contentPane.add(newanalysisbtn);
		
		newanalysisbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				newanalysisbtnActionPerformed(e);
			}

			private void newanalysisbtnActionPerformed(ActionEvent e) {
				
				if(computePayment)
				{
					noofpayments.setText("");
				}
				else
				{
					monthlypayment.setText("");
				}
				loananalysis.setText("");
				computebtn.setEnabled(true);
				newanalysisbtn.setEnabled(false);
				loanbalance.requestFocus();
			}
		});
		
		exitbtn = new JButton("Exit");
		exitbtn.setFont(new Font("Tahoma", Font.BOLD,20));
		exitbtn.setBounds(730, 480, 100, 50);
		contentPane.add(exitbtn);
		
		exitbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				exitbtnActionPerformed(e);
			}

			private void exitbtnActionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		paymentbtn = new JButton("X");
		paymentbtn.setFont(new Font("Tahoma", Font.BOLD,20));
		paymentbtn.setBounds(500, 235, 80, 50);
		contentPane.add(paymentbtn);
		
		paymentbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				paymentbtnActionPerformed(e);
			}
			
			private void paymentbtnActionPerformed(ActionEvent e)
			{
				computePayment = true;
				paymentbtn.setVisible(false);
				monthbtn.setVisible(true);
				monthlypayment.setEditable(true);
				monthlypayment.setBackground(Color.WHITE);
				monthlypayment.setFocusable(true);
				noofpayments.setText("");
				noofpayments.setEditable(false);
				noofpayments.setBackground(lightYellow);
				noofpayments.setFocusable(false);
				computebtn.setText("Compute Number of Payments");
				loanbalance.requestFocus();
			}
		});
		
		monthbtn = new JButton("X");
		monthbtn.setFont(new Font("Tahoma", Font.BOLD,20));
		monthbtn.setBounds(500, 320, 80, 50);
		contentPane.add(monthbtn);
		
		monthbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				monthbtnActionPerformed(e);
			}

			private void monthbtnActionPerformed(ActionEvent e) {
				computePayment = false;
				paymentbtn.setVisible(true);
				monthbtn.setVisible(false);
				monthlypayment.setText("");
				monthlypayment.setEditable(false);
				monthlypayment.setBackground(lightYellow);
				monthlypayment.setFocusable(false);
				noofpayments.setEditable(true);
				noofpayments.setBackground(Color.WHITE);
				noofpayments.setFocusable(true);
				
				computebtn.setText("Compute Monthly Payments");
				loanbalance.requestFocus();
			}
		});
		
		monthbtn.doClick();
		
		monthbtn.setFocusable(false);
		paymentbtn.setFocusable(false);
		loananalysis.setFocusable(false);
		exitbtn.setFocusable(false);
		
		
		
		loanbalance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loanbalanceActionPerformed(e);
				
			}

			private void loanbalanceActionPerformed(ActionEvent e) {
				loanbalance.transferFocus();
				
			}
			
		});	
		
		interestrate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				interestrateActionPerformed(e);
				
			}

			private void interestrateActionPerformed(ActionEvent e) {
				interestrate.transferFocus();
				
			}
			
		});
		
		monthlypayment.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e)
			{
				monthlypaymentActionPerformed(e);
			}
			private void monthlypaymentActionPerformed(ActionEvent e2) {
				monthlypayment.transferFocus();
				
			}
		});
		
		noofpayments.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				noofpaymentsActionPerformed(e);
			}

			private void noofpaymentsActionPerformed(ActionEvent e) {
				noofpayments.transferFocus();
				
			}
			
		});
		
		
		
		
	
		
		
		
		
		
		
		
		
		
	}


	public boolean validateDecimalNumber(JTextField textField)
	{
		String s = textField.getText().trim();
		boolean hasDecimal = false;
		boolean valid = true;
		
		if(s.length()==0)
		{
			valid = false;
		}
		else
		{
			for(int i=0;i<s.length();i++)
			{
				char c = s.charAt(i);
				if(c>='0' && c<='9')
				{
					continue;
				}
				else if(c=='.' && !hasDecimal)
				{
					hasDecimal = true;
				}
				else
				{
					valid = false;
				}
			}
		}
		
		textField.setText(s);
		if(!valid)
		{
			textField.requestFocus();
		}
		return (valid);
	}
	

}
