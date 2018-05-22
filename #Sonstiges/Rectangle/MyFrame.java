package Rectangle;


import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public MyFrame() {

		add(panel);
		
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	public MyPanel getPanel() {
		return panel;
	}
	
	public static void main(String[] args) {
		new MyController(new MyFrame());
	}
}
