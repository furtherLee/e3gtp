package e3gtp.command;

import java.util.Arrays;

import e3gtp.exception.SyntaxException;
import e3gtp.command.*;
import e3gtp.entity.*;

public class CommandFactory {
	
	private static CommandFactory instance;
	
	public static synchronized CommandFactory getInstance(){
		if (instance == null)
			instance = new CommandFactory();
		return instance;
	}
	
	private CommandFactory(){
	}
	
	public Command parseCommand(String str){
		Integer id = null;
		
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
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildSetFreeHandicap(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildRegGenMove(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildQuit(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildPlay(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildProtocolVersion(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildPlaceFreeHandicap(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildName(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildLoadSGF(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildListCommands(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildKownCommand(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildKomi(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildGenMove(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildFixedHandicap(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildClearBoard(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	private Command buildBoardSize(Integer id, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BOOLEAN parseBoolean(String str){
		if(str.trim().equals("true"))
			return new BOOLEAN(true);
		else if(str.trim().equals("false"))
			return new BOOLEAN(false);
		else throw new SyntaxException(str + " is neither true nor false.");
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
