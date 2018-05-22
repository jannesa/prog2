package Sync;

public class ValueClass {
	private Integer value = 0;
	
	
	public void inkrement() {
		synchronized (value) {
			value++;
			System.out.println("inkrement: " + value);
			
		}
	}
	
	public void decrement() {
		synchronized (value) {
			value--;
			System.out.println("dekrement: " + value);
			
		}
	}
	

}
