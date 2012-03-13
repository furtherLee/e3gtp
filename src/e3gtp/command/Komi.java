package e3gtp.command;

import e3gtp.connection.Response;
import e3gtp.entity.FLOAT;

public class Komi extends Command{
	
	public static final String name = "komi";
	
	public Komi(FLOAT new_komi){
		super(name);
		this.args.add(new_komi);
	}
	
	public Komi(int id, FLOAT new_komi){
		super(id, name);
		this.args.add(new_komi);
	}
	
	public FLOAT getNewKomi(){
		return (FLOAT)this.args.get(0);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
	
	
}
