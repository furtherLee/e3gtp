package e3gtp.entity;

public class ALTER extends Entity{
	private final Entity x;
	private final Entity y;
	
	public ALTER(Entity x, Entity y){
		this.x = x;
		this.y = y;
	};
	
	public String format(){
		return x.format() + "|" + y.format();
	}
	
	public Entity getX(){
		return x;
	}
	
	public Entity getY(){
		return y;
	}
}
