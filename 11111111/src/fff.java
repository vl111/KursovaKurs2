
public class fff {

	public static String s = "dasdsa";

	
	public static String toUpp(){
		   return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	public static void main(String[] args) {
		System.out.println(toUpp());
	}

}
