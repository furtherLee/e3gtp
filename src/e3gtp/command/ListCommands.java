package e3gtp.command;

import e3gtp.connection.Response;

public class ListCommands extends Command{

	public static final String name = "list_commands";
	
	public ListCommands(){
		super(name);
	}
	
	public ListCommands(int id){
		super(id, name);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
