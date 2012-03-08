package e3gtp.command;

import java.util.LinkedList;
import java.util.List;

import e3gtp.connection.Connection;
import e3gtp.entity.Entity;

public class Command {

	protected String name;
	
	protected Integer id;
	
	protected List<Entity> args;
	
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
		return id != null;
	}
	
	public void send(Connection conn){
		conn.send(this.format());
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		if (this.hasId())
			sb.append(id + " ");
		
		sb.append(getName() + " ");
		
		for(Entity entity: args)
			sb.append(entity.toString());
		
		return sb.toString();
	}
}