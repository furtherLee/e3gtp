package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.COLOR;

public class GenMove extends Command{
	
	public static final String name = "genmove";
	
	public GenMove(COLOR color){
		super(name);
		this.args.add(color);
	}
	
	public GenMove(int id, COLOR color){
		super(id, name);
		this.args.add(color);
	}
	
	public COLOR getCOLOR(){
		return (COLOR)this.args.get(0);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
