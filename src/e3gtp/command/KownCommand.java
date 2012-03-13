package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.STRING;

public class KownCommand extends Command{

	public static final String name = "known_command";
	
	public KownCommand(STRING commandName){
		super(name);
		this.args.add(commandName);
	}
	
	public KownCommand(int id, STRING commandName){
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
