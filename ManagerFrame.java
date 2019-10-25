

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnDailyReport;
	private JButton btnCheckup;	
	//private Customer customer=new Customer("","","");	
	private ArrayList<Customer> customers=new ArrayList<Customer>();
	private ArrayList<Manager> managers=new ArrayList<Manager>();
	private ArrayList<Income> incomes=new ArrayList<Income>();
	private ArrayList<Loan> loans=new ArrayList<Loan>();
	private ArrayList<Transaction> transactions=new ArrayList<Transaction>();
	private JButton btnLogOut;
	private JButton btnIncome;
	private JButton btnPayment;
	/**
	 * Create the frame.
	 */
	public ManagerFrame(ArrayList<Customer> customers,ArrayList<Manager> managers, ArrayList<Income> incomes,
			ArrayList<Loan> loans,ArrayList<Transaction> transactions) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//this.customer=customer;
		this.customers=customers;
		this.managers=managers;
		this.incomes=incomes;
		this.loans=loans;
		this.transactions=transactions;
		init();
		addAction();
	}
	
	public void init(){
		btnDailyReport = new JButton("Daily Report");
		btnDailyReport.setBounds(54, 76, 118, 23);
		contentPane.add(btnDailyReport);
		
		btnCheckup = new JButton("Check-up");
		btnCheckup.setBounds(54, 172, 118, 23);
		contentPane.add(btnCheckup);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(331, 10, 93, 23);
		contentPane.add(btnLogOut);
		
		btnIncome = new JButton("Income");
		btnIncome.setBounds(245, 76, 118, 23);
		contentPane.add(btnIncome);
		
		btnPayment = new JButton("Payment");
		btnPayment.setBounds(245, 172, 118, 23);
		contentPane.add(btnPayment);
	}
	
	//public Customer getCustomer(){
		//return this.customer;
	//}
	
	public ArrayList<Income> getIncomes(){
		return this.incomes;
	}
	
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
	
	public ArrayList<Transaction> getTransactions(){
		return this.transactions;
	}
	
	public ArrayList<Loan> getLoans(){
		return this.loans;
	}
	
	public void setTransactions(ArrayList<Transaction> transactions){
		this.transactions=transactions;
	}
	
	public void setLoans(ArrayList<Loan> loans){
		this.loans=loans;
	}
	
	
	
	public void addAction(){
		btnDailyReport.addActionListener(new ActionListener() {   //daily report
			public void actionPerformed(ActionEvent e) {
				DailyReportFrame dailyreportfram=new DailyReportFrame(customers,transactions);
				dailyreportfram.setVisible(true);
			}
		});
		
		btnCheckup.addActionListener(new ActionListener() {      //check up a specific customer
			public void actionPerformed(ActionEvent e) {
				CheckupFrame checkupframe=new CheckupFrame(customers);
				checkupframe.setVisible(true);
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {        //log out and back to login
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login=new Login(customers,managers,getIncomes(),getLoans(),getTransactions());
				login.setVisible(true);
			}
		});
		
		btnIncome.addActionListener(new ActionListener() {          //see income
			public void actionPerformed(ActionEvent e) {
				IncomeFrame incomeframe=new IncomeFrame(getCustomers(),getIncomes());
				incomeframe.setVisible(true);
			}
		});
		
		btnPayment.addActionListener(new ActionListener() {         //see payment
			public void actionPerformed(ActionEvent e) {
				PaymentFrame paymentframe=new PaymentFrame(getCustomers());
				paymentframe.setVisible(true);
			}
		});
	}

}
