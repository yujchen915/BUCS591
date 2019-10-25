

public class Loan {
	private Currency loan=new Currency("",0);
	private float interest;
	private int loanlength;
	private String collateral;
	
	public Loan(){
		//this.loan=new Currency("",0);
		this.interest=0;
		this.loanlength=0;
	}
	
	public Loan(Currency currency,float interest,int loanlength, String collateral){
		this.loan=currency;
		this.interest=interest;
		this.loanlength=loanlength;
		this.collateral=collateral;
	}
	
	public Currency getLoan(){
		return this.loan;
	}
	
	public float getIntesest(){
		return this.interest;
	}
	
	public int getLoanLength(){
		return this.loanlength;
	}
	
	public String getCollateral(){
		return this.collateral;
	}
	
	public void setLoan(Currency currency){
		this.loan=currency;
	}
	
	public void setIntesest(float interest){
		this.interest=interest;
	}
	
	public void setLoanLength(int loanlength){
		this.loanlength=loanlength;
	}
	
	public void setCollateral(String collateral){
		this.collateral=collateral;
	}
	
	public Currency getLoanTotal(){   //get the income of loan
		double income=0;
		if(this.loan.getMark().equalsIgnoreCase("Dollar")){
			income=this.loan.getMoney()*0.1;
		}
		if(this.loan.getMark().equalsIgnoreCase("RMB")){
			income=this.loan.getMoney()*0.1;
		}
		if(this.loan.getMark().equalsIgnoreCase("Euro")){
			income=this.loan.getMoney()*0.1;
		}
		return new Currency(this.loan.getMark(),income);
	}

}
