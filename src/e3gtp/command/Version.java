package e3gtp.command;

public class Version extends Command{
	
	public static final String name = "version";
	
	public Version(){
		super(name);
	}
	
	public Version(int id){
		super(id, name);
	}
	
}
