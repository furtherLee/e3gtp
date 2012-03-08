package e3gtp.entity;

public class FLOAT extends Entity{
	
	final float f;
	
	public FLOAT(float f){
		this.f = f;
	}
	
	public float getFloat(){
		return f;
	}
	
	public String format(){
		return f + "";
	}
	
}
