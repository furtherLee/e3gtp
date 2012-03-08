package e3gtp.entity;

import e3gtp.exception.IllegalParamException;

public class COLOR extends Entity{

	public static enum Type{
		WHITE, BLACK
	}
	
	private final Type color;
	
	public COLOR(Type color){
		this.color = color;
	}
	
	public String format(){
		switch(color){
			case WHITE:
				return "w";
			case BLACK:
				return "b";
			default:
				throw new IllegalParamException();
		}
	}
	
}
