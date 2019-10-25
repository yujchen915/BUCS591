

import java.awt.EventQueue;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
	private static ArrayList<Customer> customers=new ArrayList<Customer>();
	private static ArrayList<Manager> managers=new ArrayList<Manager>();
	private static ArrayList<Income> incomes=new ArrayList<Income>();
	private static ArrayList<Loan> loans=new ArrayList<Loan>();
	private static ArrayList<Transaction> transactions=new ArrayList<Transaction>();
	
	public static void init(){
		customers.add(new Customer("Bob","bob","00000","1234567892"));
		customers.add(new Customer("Mary","ma","00000","7894561230"));
		managers.add(new Manager("Lisa","lisa","11111","1452368959"));
		
		customers.get(0).createChecking(new Checking(new Account("Bob","bob","00000","1234567892"),"000000000001","123456",new Balance()));
		customers.get(0).addLoan(new Loan(new Currency("Dollar",100),(float)0.1,6,"John"));
		customers.get(0).addTransaction(new Transaction(new Currency("Dollar",100),new Date(),customers.get(0).getUser(),customers.get(1).getUser(),"000000000001","000000000002"));
		customers.get(1).createChecking(new Checking(new Account("Mary","ma","00000","7894561230"),"000000000002","123456",new Balance()));
		customers.get(0).createSaving(new Saving(new Account("Bob","bob","00000","1234567892"),"000000000002","123456",new Balance()));
		customers.get(1).createSaving(new Saving(new Account("Mary","ma","00000","7894561230"),"000000000003","123456",new Balance()));
		customers.get(0).getSaving().setBalance(new Balance());
		customers.get(0).getChecking().getBalance().setDollar(new Currency("Dollar",100));
		customers.get(0).getSaving().getBalance().setDollar(new Currency("Dollar",100));
		
		for(int i=0;i<customers.size();i++){  //add loans' income into the whole incomes			 
			 for(int j=0;j<customers.get(i).getLoans().size();j++){
				 incomes.add(new Income(customers.get(i).getLoans().get(j).getLoanTotal(),"Loan"));
			 }
		 }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login = new Login(customers,managers,incomes,loans,transactions);
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
