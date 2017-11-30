package object.practice2;

public class CheckingAccount extends Account {
	private double overdraftProtection;
	
	public CheckingAccount(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}
	
	public CheckingAccount(double balance, double protect) {
		super(balance);
		this.overdraftProtection = protect; 
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void withdraw(double amt) throws OverdraftExcetpion{
		if(balance + overdraftProtection <amt)
			throw new OverdraftExcetpion("balance + overdraftProtection not enouth for withdraw");
		else if(balance<amt){
			balance = 0;
			overdraftProtection = amt - balance;
		}
		else
			balance = balance - amt;
	}
}
