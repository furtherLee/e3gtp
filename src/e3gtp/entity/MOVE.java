package e3gtp.entity;

public class MOVE extends Entity{

	private final COLOR color;
	
	private final VERTEX vertex;
	
	public MOVE(COLOR color, VERTEX vertex){
		this.color = color;
		this.vertex = vertex;
	}
	
	public COLOR getColor(){
		return color;
	}
	
	public VERTEX getVertex(){
		return vertex;
	}
	
	public String format(){
		return color.format() + vertex;
	}
	
}
