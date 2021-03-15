package m4;

public class NotValidPriceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotValidPriceException(Exception e) {
        super();
        this.initCause(e);
    }
	
	public String getMessage() {
		return "format del preu incorrecte";
		
	}

}
