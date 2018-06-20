package timer;

import java.util.Observable;

public class ClockThread extends Observable implements Runnable {
	
	int count = 0 ;
	boolean run = true ;
	
	
	public void setRun(boolean run){
		this.run = run ;
	}
	
	
	public void reset(){
		count = 0 ;
		run = false ;
		setChanged();
		notifyObservers(count);
	}
	

	
	@Override
	public void run() {

		while(run){
			count ++ ;
			setChanged();
			notifyObservers(count);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void start() {
		// TODO Auto-generated method stub
		
	}
	


}
