package e3gtp.command;

import e3gtp.connection.Response;

public class ClearBoard extends Command{

	public static final String name = "clear_board";
	
	public ClearBoard(){
		super(name);
	}
	
	public ClearBoard(int id){
		super(id, name);
	}

	@Override
	public Response accept(CommandVisitor visitor) {
		return visitor.visit(this);
	}
}
