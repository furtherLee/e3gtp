package e3gtp.command;

import e3gtp.connection.Response;

public class Version extends Command{
	
	public static final String name = "version";
	
	public Version(){
		super(name);
	}
	
	public Version(int id){
		super(id, name);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
