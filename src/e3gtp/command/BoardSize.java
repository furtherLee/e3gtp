package e3gtp.command;

public class BoardSize extends Command{

	public static final String name = "boardsize";
	
	public BoardSize(int size){
		super(name);
		this.args.add(new INT(size));
	}
	
	public BoardSize(int id, int size){
		
	}
	
	public int getSize(){
		return ;
	}
	
}
