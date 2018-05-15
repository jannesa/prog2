package timer;

public class ClockController {

	public ClockController(ClockView view) {
		ClockThread thread = new ClockThread();

		view.getStartBtn().addActionListener(l -> {
		});
		
		view.getStopBtn().addActionListener(l -> {
		});
		
		thread.addObserver(view);
	}

	public static void main(String[] args) {
		new ClockController(new ClockView());
	}
}
