package e3gtp.command;

import e3gtp.connection.Response;

public interface CommandVisitor {

	public Response visit(BoardSize boardSize);

	public Response visit(ClearBoard clearBoard);

	public Response visit(FixedHandicap fixedHandicap);

	public Response visit(GenMove genMove);

	public Response visit(Komi komi);

	public Response visit(KownCommand kownCommand);

	public Response visit(ListCommands listCommands);

	public Response visit(LoadSGF loadSGF);

	public Response visit(Name name);

	public Response visit(PlaceFreeHandicap placeFreeHandicap);

	public Response visit(Play play);

	public Response visit(ProtocolVersion protocolVersion);

	public Response visit(Quit quit);

	public Response visit(RegGenMove regGenMove);

	public Response visit(SetFreeHandicap setFreeHandicap);

	public Response visit(Version version);

}
