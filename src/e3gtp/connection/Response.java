package e3gtp.connection;

public class Response {
	
	final boolean success;
	
	final Integer id;
	
	final String response;

	public Response(Integer id, String response, boolean success){
		this.id = id;
		this.response = response;
		this.success = success;
	}
	
	public Response(String response, boolean success){
		id = null;
		this.response = response;
		this.success = success;
	}
	
	public String format(){
		StringBuilder sb = new StringBuilder();
		if (success)
			sb.append("=");
		else
			sb.append("?");
		if (id != null && id >= 0)
			sb.append(id);
		sb.append(" ");
		sb.append(response + "\n\n");
		return sb.toString();
	}
}
