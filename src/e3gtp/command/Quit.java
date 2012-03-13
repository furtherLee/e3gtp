package e3gtp.command;

import e3gtp.connection.Response;

public class Quit extends Command{

	public static final String name = "quit";
	
	public Quit(){
		super(name);
	}
	
	public Quit(int id){
		super(id, name);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
