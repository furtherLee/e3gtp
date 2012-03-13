package e3gtp.command;

import e3gtp.connection.*;
import e3gtp.entity.INT;

public class FixedHandicap extends Command{

	public static final String name = "fixed_handicap";
	
	public FixedHandicap(INT numberOfStones){
		super(name);
		this.args.add(numberOfStones);
	}
	
	public FixedHandicap(int id, INT numberOfStones){
		super(id, name);
		this.args.add(numberOfStones);
	}
	
	public INT getNumberOfStones(){
		return (INT)this.args.get(0);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
