package e3gtp.command;

import java.util.LinkedList;
import java.util.List;

import e3gtp.entity.Entity;
import e3gtp.entity.VERTEX;

public class SetFreeHandicap extends Command{
	
	public static final String name = "set_free_handicap";
	
	public SetFreeHandicap(List<VERTEX> vertices){
		super(name);
		init(vertices);
	}
	
	public SetFreeHandicap(int id, List<VERTEX> vertices){
		super(id, name);
		init(vertices);
	}
	
	private void init(List<VERTEX> vertices){
		for(VERTEX vertex: vertices)
			this.args.add(vertex);
	}
	
	public List<VERTEX> getVertices(){
		List<VERTEX> vertices = new LinkedList<VERTEX>();
		
		for(Entity entity: this.args)
			vertices.add((VERTEX)entity);
		
		return vertices;
	}
	
}
