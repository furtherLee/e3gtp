package e3gtp.entity;

import java.util.LinkedList;
import java.util.List;

public class LIST extends Entity{
	private final List<Entity> list;
	
	public LIST(List<Entity> list){
		this.list = list;
	}
	
	public LIST(){
		this.list = new LinkedList<Entity>();
	}
	
	public void add(Entity entity){
		this.list.add(entity);
	}
	
	public List<Entity> getCollection(){
		return java.util.Collections.unmodifiableList(this.list);
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		for(Entity entity: list)
			sb.append(entity.format() + " ");
		return sb.toString();
	}
}
