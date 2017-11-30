package object.practice2;

public class OverdraftExcetpion extends Exception {
	public OverdraftExcetpion(){
		
	}
	
	public OverdraftExcetpion(String msg){
		super(msg);
	}
}
