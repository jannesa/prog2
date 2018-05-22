package sync;

public class ValueClass {
	
	private int value = 0 ;
	
	
	public synchronized void inkrement(){
		value ++ ;
		System.out.println("inkrement: " + value );
	}
	
	public synchronized void decrement() {
		value -- ;
		System.out.println("Dekrement: " + value);
	}
}
