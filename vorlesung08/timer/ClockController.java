package timer;

public class ClockController {

	public ClockController(ClockView view) {
		ClockThread thread = new ClockThread();

		view.getStartBtn().addActionListener(l -> {
			Thread t = new Thread(thread);
			t.start();
			thread.setRun(true);
			view.setStartBtnStop() ;
		});
		
		view.getStopBtn().addActionListener(l -> {
			thread.setRun(false);
			thread.reset();
			view.setStartBtnStart() ;
		});
		
		thread.addObserver(view);
	}

	public static void main(String[] args) {
		new ClockController(new ClockView());
	}
}
