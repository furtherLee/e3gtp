package e3gtp.entity;

public class BOOLEAN extends Entity{
	
	boolean b;
	
	public BOOLEAN(boolean b){
		this.b = b;
	}
	
	public String format(){
		return b? "true":"false";
	}
}
