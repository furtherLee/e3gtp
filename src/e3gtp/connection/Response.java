package e3gtp.connection;

public class Response {
	
	Integer id;
	
	String response;

	public Response(Integer id, String response){
		this.id = id;
		this.response = response;
	}
	
	public Response(String response){
		id = null;
		this.response = response;
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		if (id != null)
			sb.append(id + " ");
		sb.append(response + "\n");
		return sb.toString();
	}
}
