package timer;

public class ClockController {

	public ClockController(ClockView view) {
		ClockThread thread = new ClockThread();

		view.getStartBtn().addActionListener(l -> {
			thread.reset();
			Thread t = new Thread(thread);
			t.run();
		});
		
		view.getStopBtn().addActionListener(l -> {
			try {
				thread.stop() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		thread.addObserver(view);
	}

	public static void main(String[] args) {
		new ClockController(new ClockView());
	}
}
