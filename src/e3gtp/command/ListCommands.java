package e3gtp.command;

public class ListCommands extends Command{

	public static final String name = "list_commands";
	
	public ListCommands(){
		super(name);
	}
	
	public ListCommands(int id){
		super(id, name);
	}
	
}
