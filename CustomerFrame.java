

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnBalance;	
	private JButton btnShowTranscation;	
	private JButton btnDeposit;	
	private JButton btnWithdraw;	
	private JButton btnLoan;
	private Customer customer=new Customer("","","","");
	private ArrayList<Manager> managers=new ArrayList<Manager>();
	private ArrayList<Customer> customers=new ArrayList<Customer>();
	private ArrayList<Income> incomes=new ArrayList<Income>();
	private ArrayList<Loan> loans=new ArrayList<Loan>();
	private ArrayList<Transaction> transactions=new ArrayList<Transaction>();
	
	private JButton btnCloseAccount;
	private JButton btnLogOut;
	private JButton btnOpenSaving;
	
	/**
	 * Create the frame.
	 */
	public CustomerFrame(Customer customer,ArrayList<Customer> customers,ArrayList<Manager> managers,
			ArrayList<Income> incomes,ArrayList<Loan> loans,ArrayList<Transaction> transactions) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.customer=customer;
		this.customers=customers;
		this.managers=managers;
		this.incomes=incomes;
		this.loans=loans;
		this.transactions=transactions;
		init();
		addAction();
	}
	
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	
	public void setCustomers(ArrayList<Customer> customers){
		this.customers=customers;
	}
	
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
	
	public ArrayList<Income> getIncomes(){
		return this.incomes;
	}
	
	public ArrayList<Transaction> getTransactions(){
		return this.transactions;
	}
	
	public ArrayList<Loan> getLoans(){
		return this.loans;
	}
	
	public void setIncomes(ArrayList<Income> incomes){
		this.incomes=incomes;
	}
	
	public void setTransactions(ArrayList<Transaction> transactions){
		this.transactions=transactions;
	}
	
	public void setLoans(ArrayList<Loan> loans){
		this.loans=loans;
	}
	
	public void init(){
		btnBalance = new JButton("Balance");
		btnBalance.setBounds(62, 57, 129, 29);
		contentPane.add(btnBalance);
		
		btnShowTranscation = new JButton("Transcation");
		btnShowTranscation.setBounds(62, 120, 129, 29);
		contentPane.add(btnShowTranscation);
		
		btnDeposit = new JButton("Deposit");

		btnDeposit.setBounds(291, 57, 131, 29);
		contentPane.add(btnDeposit);
		
		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(291, 120, 131, 29);
		contentPane.add(btnWithdraw);
		
		btnLoan = new JButton("Loan");
		btnLoan.setBounds(62, 183, 129, 29);
		contentPane.add(btnLoan);
		
		btnCloseAccount = new JButton("Close Account");
		btnCloseAccount.setBounds(292, 183, 130, 29);
		contentPane.add(btnCloseAccount);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(393, 10, 93, 23);
		contentPane.add(btnLogOut);
		
		btnOpenSaving = new JButton("Open Saving");
		btnOpenSaving.setBounds(62, 250, 129, 29);
		contentPane.add(btnOpenSaving);
		
	}
	
	public void addAction(){
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositFrame depositframe=new DepositFrame(getCustomer(),getIncomes());
				depositframe.setVisible(true);
				setCustomer(depositframe.getCustomer());
				setIncomes(depositframe.getIncomes());
			}
		});
		
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//test();
				BalanceFrame balanceframe=new BalanceFrame(getCustomer());
				//balanceframe.setCustomer(getCustomer());
				balanceframe.setVisible(true);
			}
		});
		
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithDrawFrame withdrawframe=new WithDrawFrame(getCustomer(),getIncomes());
				withdrawframe.setVisible(true);
				setCustomer(withdrawframe.getCustomer());
				setIncomes(withdrawframe.getIncomes());
			}
		});
		
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanFrame loanframe=new LoanFrame(getCustomer(),loans,getIncomes());
				loanframe.setVisible(true);
				setCustomer(loanframe.getCustomer());
				setLoans(loanframe.getLoans());
			}
		});
		
		btnShowTranscation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionFrame transactionframe=new TransactionFrame(getCustomer(),customers,getIncomes(),transactions);
				transactionframe.setVisible(true);
				setCustomer(transactionframe.getCustomer());
				setCustomers(transactionframe.getCustomers());
				setIncomes(transactionframe.getIncomes());
				setTransactions(transactionframe.getTransactions());
			}
		});
		
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAccountFrame closeaccountframe=new CloseAccountFrame(getCustomer(),customers,managers,getIncomes(),getLoans(),getTransactions());
				closeaccountframe.setVisible(true);
				setCustomer(closeaccountframe.getCustomer());
				setCustomers(closeaccountframe.getCustomers());
				setIncomes(closeaccountframe.getIncomes());
				dispose();
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login=new Login(customers,managers,incomes,loans,transactions);
				login.setVisible(true);
			}
		});
		
		btnOpenSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customer.getSaving()==null){
					customer.createSaving(new Saving(customer.getUser(),getNewSavingAccount(),customer.getChecking().getMoneypassword(),new Balance()));
					if(customer.getChecking().getBalance().getDollar().getMoney()>=5){
						customer.getChecking().getBalance().substract(new Currency("Dollar",5));
						incomes.add(new Income(new Currency("Dollar",5),"Open account"));
						reminder("Open saving account successfully!");
					}else{
						reminder("You do not have enough money to open!");
					}
				}else{
					reminder("You already have saving account!");
				}
			}
		});
		
	}
	
	public String getNewSavingAccount(){     //create new saving account number
		 Random rand=new Random();
	     String newAccount="";
	     for(int a=0;a<12;a++){
	    	 newAccount+=rand.nextInt(10);
	     }
	     for(int i=0;i<customers.size();i++){   // check if the account number exist
	    	 if(customers.get(i).getSaving()!=null){
		    	 while(newAccount.equals(customers.get(i).getSaving().getAccountNumber())){	
		    		 Random rands=new Random();
			    	 String newAccounts="";
			    	 for(int a=0;a<12;a++){
			    	     newAccounts+=rand.nextInt(10);
			    	 }
			    	 newAccount=newAccounts;
		    	 }
	    	 }		
	     }
	     return newAccount;
	}
	
	public void reminder(String str){
		Object[] okObjects = new Object[] {"OK"};
		JOptionPane.showOptionDialog(null, str, "Message", 
				JOptionPane.OK_OPTION,JOptionPane.WARNING_MESSAGE,null,okObjects,null);
	}

}
