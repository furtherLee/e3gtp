package e3gtp.command;

import e3gtp.entity.INT;

public class PlaceFreeHandicap extends Command{

	public static final String name = "place_free_handicap";
	
	public PlaceFreeHandicap(INT numberOfStones){
		super(name);
		this.args.add(numberOfStones);
	}
	
	public PlaceFreeHandicap(int id, INT numberOfStones){
		super(id, name);
		this.args.add(numberOfStones);
	}
	
	public INT getNumberOfStones(){
		return (INT)this.args.get(0);
	}
	
}
