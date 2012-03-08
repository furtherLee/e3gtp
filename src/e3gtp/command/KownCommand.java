package e3gtp.command;

import e3gtp.entity.STRING;

public class KownCommand extends Command{

	public static final String name = "known_command";
	
	public KownCommand(){
		super(name);
	}
	
	public KownCommand(int id, STRING string){
		super(id, name);
		this.args.add(string);
	}
	
}
