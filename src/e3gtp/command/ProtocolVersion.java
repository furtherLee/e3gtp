package e3gtp.command;

import e3gtp.connection.Response;

public class ProtocolVersion extends Command{
	
	public static final String name = "protocol_version";

	public ProtocolVersion(){
		super(name);
	}
	
	public ProtocolVersion(int id){
		super(id, name);
	}
	
	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
