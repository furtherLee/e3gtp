package e3gtp.entity;

import e3gtp.exception.IllegalParamException;

public class VERTEX extends Entity{
	
	private final boolean isPass;
	
	private final int column;
	
	private final int row;
	
	
	public VERTEX(){
		this.isPass = true;
		this.column = 0;
		this.row = 0;
	}
	
	public VERTEX(int column, int row){
		this.column = column;
		this.row = row;
		this.isPass = false;
	}
	
	public VERTEX(String column, int row){
		if(column.length() != 1)
			throw new IllegalParamException();
		this.column = column.charAt(0) - 64;
		this.row = row;
		this.isPass = false;
		
	}
	
	public String format(){
		if(isPass)
			return "pass";
		
		return (char)column + "" + row;
	}
	
}
