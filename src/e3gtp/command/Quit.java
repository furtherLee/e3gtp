package e3gtp.command;

public class Quit extends Command{

	public static final String name = "quit";
	
	public Quit(){
		super(name);
	}
	
	public Quit(int id){
		super(id, name);
	}

}
