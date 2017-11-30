package object.practice2;

public class Account {
	protected double balance;
	
	public Account(double balance){
		this.balance = balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amt){
		balance = balance + amt;
	}
	
	public void withdraw(double amt) throws OverdraftExcetpion{
		if(balance<amt)
			throw new OverdraftExcetpion("balance not enouth for withdraw");
		balance = balance - amt;
	}
}
