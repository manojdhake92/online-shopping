package md.spring.onlineshopping.controller.exception;

public class NoProductFoundException extends Exception {
	
	private String message;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoProductFoundException() {
		
	}
	
	public String getMessage() {
		return message;
	}


	public NoProductFoundException(String message){
		this.message = message;
	}
	
	
	
}
