package e3gtp.command;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import e3gtp.exception.SyntaxException;
import e3gtp.entity.*;

public class CommandFactory {
	
	public static final List<String> CommandSupported = new LinkedList<String>();
	
	static{
		CommandSupported.add(BoardSize.name);
		CommandSupported.add(ClearBoard.name);
		CommandSupported.add(FixedHandicap.name);
		CommandSupported.add(GenMove.name);
		CommandSupported.add(Komi.name);
		CommandSupported.add(KownCommand.name);
		CommandSupported.add(ListCommands.name);
		CommandSupported.add(LoadSGF.name);
		CommandSupported.add(Name.name);
		CommandSupported.add(PlaceFreeHandicap.name);
		CommandSupported.add(Play.name);
		CommandSupported.add(ProtocolVersion.name);
		CommandSupported.add(Quit.name);
		CommandSupported.add(RegGenMove.name);
		CommandSupported.add(SetFreeHandicap.name);
		CommandSupported.add(Version.name);
	}
	
	private static CommandFactory instance;
	
	public static synchronized CommandFactory getInstance(){
		if (instance == null)
			instance = new CommandFactory();
		return instance;
	}
	
	private CommandFactory(){
	}
	
	public Command parseCommand(String str){
		Integer id = -1;
		
		int offset = 0;
		
		str = str.trim();
		
		String[] params = str.split(" ");
		
		if (isInteger(params[0]))
			id = Integer.parseInt(params[offset++]);
		
		String commandName = params[offset++];

		String[] args = Arrays.copyOfRange(params, offset, params.length);
		
		if(commandName.equals(BoardSize.name))
			return buildBoardSize(id, args);
		else if(commandName.equals(ClearBoard.name))
			return buildClearBoard(id, args);
		else if(commandName.equals(FixedHandicap.name))
			return buildFixedHandicap(id, args);
		else if(commandName.equals(GenMove.name))
			return buildGenMove(id, args);
		else if(commandName.equals(Komi.name))
			return buildKomi(id, args);
		else if(commandName.equals(KownCommand.name))
			return buildKownCommand(id, args);
		else if(commandName.equals(ListCommands.name))
			return buildListCommands(id, args);
		else if(commandName.equals(LoadSGF.name))
			return buildLoadSGF(id, args);
		else if(commandName.equals(Name.name))
			return buildName(id, args);
		else if(commandName.equals(PlaceFreeHandicap.name))
			return buildPlaceFreeHandicap(id, args);
		else if(commandName.equals(Play.name))
			return buildPlay(id, args);
		else if(commandName.equals(ProtocolVersion.name))
			return buildProtocolVersion(id, args);
		else if(commandName.equals(Quit.name))
			return buildQuit(id, args);
		else if(commandName.equals(RegGenMove.name))
			return buildRegGenMove(id, args);
		else if(commandName.equals(SetFreeHandicap.name))
			return buildSetFreeHandicap(id, args);
		else if(commandName.equals(Version.name))
			return buildVersion(id, args);
		else 
			throw new SyntaxException(commandName + " is not supported.");
		
	}
	
	private Command buildVersion(Integer id, String[] args) {
		assertEmpty(args);
		return new Version(id);
	}

	private Command buildSetFreeHandicap(Integer id, String[] args) {
		assertNoLessThan(args, 1);
		isComment(args[0], true);
		
		List<VERTEX> vertices = new LinkedList<VERTEX>();
		
		for (String str: args){
			if (isComment(str))
				break;
			vertices.add(parseVertex(str));
		}
		
		return new SetFreeHandicap(id, vertices);
	}

	private Command buildRegGenMove(Integer id, String[] args) {
		assertEmpty(args);
		assertNoLessThan(args, 2);
		COLOR color = parseColor(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new RegGenMove(id, color);
	}

	private Command buildQuit(Integer id, String[] args) {
		assertEmpty(args);
		return new Quit(id);
	}

	private Command buildPlay(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		MOVE move = parseMove(args[0] + " " + args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new Play(id, move);
	}

	private Command buildProtocolVersion(Integer id, String[] args) {
		assertEmpty(args);
		return new ProtocolVersion(id);
	}

	private Command buildPlaceFreeHandicap(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		INT num = parseInt(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new PlaceFreeHandicap(id, num);
	}

	private Command buildName(Integer id, String[] args) {
		assertEmpty(args);
		return new Name(id);
	}

	private Command buildLoadSGF(Integer id, String[] args) {
		assertNoLessThan(args, 3);
		STRING str = parseString(args[1]);
		INT num = parseInt(args[2]);
		if (args.length > 3)
			isComment(args[3], true);
		return new LoadSGF(id, str, num);
	}

	private Command buildListCommands(Integer id, String[] args) {
		assertEmpty(args);
		return new ListCommands(id);
	}

	private Command buildKownCommand(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		STRING str = parseString(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new KownCommand(id, str);
	}

	private Command buildKomi(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		FLOAT num = parseFloat(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new Komi(id, num);
	}

	private Command buildGenMove(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		COLOR color = parseColor(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new GenMove(id, color);
	}

	private Command buildFixedHandicap(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		INT num = parseInt(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new FixedHandicap(id, num);
	}

	private Command buildClearBoard(Integer id, String[] args) {
		assertEmpty(args);
		return new ClearBoard(id);
	}

	private Command buildBoardSize(Integer id, String[] args) {
		assertNoLessThan(args, 2);
		INT num = parseInt(args[1]);
		if (args.length > 2)
			isComment(args[2], true);
		return new BoardSize(id, num);
	}
	
	private void assertEmpty(String[] args){
		if (args.length != 0 && !args[0].trim().equals("#"))
			throw new SyntaxException(" No Parameters should be appanded here.");
	}
	
	private void assertNoLessThan(String[] args, int num){
		if (args.length < num)
			throw new SyntaxException(" Number of parameters less than " + num + ".");
	}

	private COLOR parseColor(String str){
		if(str.trim().equals("white") || str.trim().equals("w"))
			return new COLOR(COLOR.Type.WHITE);
		else if(str.trim().equals("black") || str.trim().equals("b"))
			return new COLOR(COLOR.Type.BLACK);
		else throw new SyntaxException(str + " is neither white nor black.");
	}
	
	private FLOAT parseFloat(String str){
		float value;
		try{
			value = Float.parseFloat(str.trim());
		}
		catch(NumberFormatException e){
			throw new SyntaxException(str + " is not a float.");
		}
		return new FLOAT(value);
	}
	
	private INT parseInt(String str){
		int value;
		try{
			value = Integer.parseInt(str.trim());
		}
		catch(NumberFormatException e){
			throw new SyntaxException(str + " is not a float.");
		}
		return new INT(value);
	}
	
	private MOVE parseMove(String str){
		str = str.trim();
		
		String[] params = str.split(" ");
		
		COLOR color = parseColor(params[0]);
		
		VERTEX vertex = parseVertex(params[1]);
		
		return new MOVE(color, vertex);
	}
	
	private VERTEX parseVertex(String str){
		str = str.trim();
		if(str.equals("pass"))
			return new VERTEX();
		String column = str.substring(0, 1);
		INT row = parseInt(str.substring(1, str.length()));
		return new VERTEX(column, row.getInt());
	}

	private STRING parseString(String str){
		return new STRING(str);
	}
	
	boolean isComment(String str, boolean interrupt){
		if (str.trim().startsWith("#")){
			if (interrupt)
				throw new SyntaxException("A Comment Appear incorrectly");
			return true;
		}
		return false;
	}
	
	
	
	boolean isComment(String str){
		return isComment(str, false);
	}
	
	private boolean isInteger(String str){
		try{
			Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
}
