package mx.edu.ilce.infrestructura.exceptions;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 3948631048773499693L;

	public String[] parameters;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, String... parameters) {
		super(message);
		this.parameters = parameters;
	}

	public BusinessException(String message, Throwable cause, String... parameters) {
		super(message, cause);
	}

	public String[] getParameters() {
		return parameters;
	}
	
}
