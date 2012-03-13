package e3gtp.command;

import e3gtp.connection.Response;

public class Name extends Command{
	
	public static final String name = "name";
	
	public Name(){
		super(name);
	}
	
	public Name(int id){
		super(id, name);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
