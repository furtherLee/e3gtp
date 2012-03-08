package e3gtp.entity;

public class INT extends Entity{

	final int i;
	
	public INT(int i){
		this.i = i;
	}
	
	public int getInt(){
		return i;
	}
	
	public String format(){
		return i + "";
	}
	
}
