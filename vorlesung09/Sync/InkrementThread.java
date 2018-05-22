package Sync ;

public class InkrementThread extends Thread{
	
	private boolean isRunning = true;
	private ValueClass valueClass;
	
	public InkrementThread(ValueClass valueClass) {
		this.valueClass = valueClass;
	}
	
	@Override
	public void run() {
		super.run();
		 while(isRunning) {
			 valueClass.inkrement();
		 }
		
	}

	public void stopThread() {
		isRunning = false;
	}
}
