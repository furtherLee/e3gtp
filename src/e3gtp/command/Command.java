package e3gtp.command;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import e3gtp.connection.*;
import e3gtp.entity.Entity;

public abstract class Command {

	protected final String name;
	
	protected final Integer id;
	
	protected final List<Entity> args;
	
	protected Command(String name){
		this.name = name;
		this.id = null;
		this.args = new LinkedList<Entity>();
	}
	
	protected Command(Integer id, String name){
		this.id = id;
		this.name = name;
		this.args = new LinkedList<Entity>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean hasId(){
		return id != null && id >= 0;
	}
	
	public void send(Connection conn) throws IOException{
		conn.send(this.format());
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		if (this.hasId())
			sb.append(id + " ");
		
		sb.append(getName() + " ");
		
		for(Entity entity: args)
			sb.append(entity.format());
		
		return sb.toString();
	}

	public Integer getId(){
		return id;
	}
	
	abstract public Response accept(CommandVisitor visitor);
	
}
