package e3gtp.command;

import e3gtp.entity.INT;

public class BoardSize extends Command{

	public static final String name = "boardsize";
	
	public BoardSize(int size){
		super(name);
		this.args.add(new INT(size));
	}
	
	public BoardSize(int id, int size){
		super(id, name);
		this.args.add(new INT(size));
	}
	
	public int getSize(){
		return ((INT)this.args.get(0)).getInt();
	}
	
}
