package m4;

public class DishNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private String opcio;
	
	private static final long serialVersionUID = 1L;

	public DishNotFoundException(String opcio) {
		super();
		this.opcio = opcio;
    
    }
	public String getMessage() {
		return "el plat " + opcio + " no existeix.";
	}
}
