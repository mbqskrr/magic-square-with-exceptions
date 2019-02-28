package customExceptions;

@SuppressWarnings("serial")
public class NotOddException extends Exception{

	private int order;
	
	public NotOddException(int number) {
		super("El orden de la matrix no es impar");
		order = number;
		isOdd(number);
		
	}
	
	public boolean isOdd(int order) {
		boolean odd = true;
		
		if (order%2 == 1) {
			odd = true;
		} else {
			odd = false;
		}
		
		return odd;
	}
	
	public int getOrder() {
		return order;
	}
	
}
