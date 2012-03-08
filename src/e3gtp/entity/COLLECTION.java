package e3gtp.entity;

import java.util.LinkedList;
import java.util.List;

public class COLLECTION extends Entity{
	private final List<Entity> collection;
	
	public COLLECTION(List<Entity> collection){
		this.collection = collection;
	}
	
	public COLLECTION(){
		this.collection = new LinkedList<Entity>();
	}
	
	public void add(Entity entity){
		this.collection.add(entity);
	}
	
	public List<Entity> getCollection(){
		return java.util.Collections.unmodifiableList(this.collection);
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(Entity entity: collection)
			sb.append(entity.format() + " ");
		sb.append("}");
		return sb.toString();
	}
}
