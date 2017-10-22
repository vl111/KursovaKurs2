package bankSystem;

public class IdAlreadyExistsExeption extends Exception {

	private static final long serialVersionUID = -6964631209751135286L;

	public IdAlreadyExistsExeption() {
		super();
	}

	public IdAlreadyExistsExeption(String arg0) {
		super(arg0);
	}

	public IdAlreadyExistsExeption(Throwable arg0) {
		super(arg0);
	}

	public IdAlreadyExistsExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
