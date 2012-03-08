package e3gtp.command;

public class Name extends Command{
	
	public static final String name = "name";
	
	public Name(){
		super(name);
	}
	
	public Name(int id){
		super(id, name);
	}
	
}
