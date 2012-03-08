package e3gtp.command;

public class CommandFactory {
	
	private static CommandFactory instance;
	
	public static synchronized CommandFactory getInstance(){
		if (instance == null)
			instance = new CommandFactory();
		return instance;
	}
	
	private CommandFactory(){
	}
	
	public Command parseCommand(String str){
		Command cmd = null;
		
		
		return cmd;
	}
	
}
