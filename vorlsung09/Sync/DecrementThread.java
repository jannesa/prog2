package Sync ;

public class DecrementThread extends Thread{
	
	private boolean isRunning = true;
	private ValueClass valueClass;
	
	public DecrementThread(ValueClass valueClass) {
		this.valueClass = valueClass;
	}
	
	@Override
	public void run() {
		super.run();
		 while(isRunning) {
			 valueClass.decrement();
		 }
		
	}

	public void stopThread() {
		isRunning = false;
	}
}
