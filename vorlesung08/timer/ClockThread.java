package timer;

import java.util.Observable;

public class ClockThread extends Observable implements Runnable {
	
	int count = 0 ;
	boolean run = true ;
	
	
	
	
	@Override
	public void run() {

		while(run){

			
			try {
				count ++ ;
				setChanged();
				notifyObservers(count);

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


		}
	}
	
	public void reset() {
		count = 0;
	}
	
	public void stop() throws InterruptedException {
		Thread.sleep(1000);
		setChanged();
		notifyObservers(count);
	}

}
