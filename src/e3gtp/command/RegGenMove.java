package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.COLOR;

public class RegGenMove extends Command{
	
	public static final String name = "reg_genmove";
	
	public RegGenMove(COLOR color){
		super(name);
		this.args.add(color);
	}
	
	public RegGenMove(int id, COLOR color){
		super(id, name);
		this.args.add(color);
	}
	
	public COLOR getColor(){
		return (COLOR)this.args.get(0);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
