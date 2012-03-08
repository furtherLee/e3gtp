package e3gtp.command;

import e3gtp.entity.MOVE;

public class Play extends Command{
	
	public static final String name = "play";
	
	public Play(MOVE move){
		super(name);
		this.args.add(move);
	}
	
	public Play(int id, MOVE move){
		super(id, name);
		this.args.add(move);
	}
	
	public MOVE getMove(){
		return (MOVE)this.args.get(0);
	}
}
