package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.STRING;

public class KnownCommand extends Command{

	public static final String name = "known_command";
	
	public KnownCommand(STRING commandName){
		super(name);
		this.args.add(commandName);
	}
	
	public KnownCommand(int id, STRING commandName){
		super(id, name);
		this.args.add(commandName);
	}
	
	public STRING getCommandName(){
		return (STRING)this.args.get(0);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
