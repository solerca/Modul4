package m4;

public class AnswerNotValidException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerNotValidException() {
		super();
	}
	
	public String getMessage() {
		return "la resposta no és vàlida";
	}
}
