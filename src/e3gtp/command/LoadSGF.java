package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.INT;
import e3gtp.entity.STRING;

public class LoadSGF extends Command{

	public static final String name = "loadsgf";
	
	public LoadSGF(STRING filename, INT moveNumber){
		super(name);
		this.args.add(filename);
		this.args.add(moveNumber);
	}
	
	public LoadSGF(int id, STRING filename, INT moveNumber){
		super(id, name);
		this.args.add(filename);
		this.args.add(moveNumber);
	}
	
	public STRING getFileName(){
		return (STRING)this.args.get(0);
	}
	
	public INT getMoveNumber(){
		return (INT)this.args.get(1);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
