package e3gtp.command;

public class ProtocolVersion extends Command{
	
	public static final String name = "protocol_version";

	public ProtocolVersion(){
		super(name);
	}
	
	public ProtocolVersion(int id){
		super(id, name);
	}
	
}
