package e3gtp.exception;

public class SyntaxException extends RuntimeException{
	private static final long serialVersionUID = 5768516401047296629L;

	public SyntaxException(String error){
		super(error);
	}
}
