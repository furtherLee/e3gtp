package e3gtp.command;

public class ClearBoard extends Command{

	public static final String name = "clear_board";
	
	public ClearBoard(){
		super(name);
	}
	
	public ClearBoard(int id){
		super(id, name);
	}
	
}
