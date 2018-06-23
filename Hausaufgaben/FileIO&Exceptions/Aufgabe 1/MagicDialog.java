import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MagicDialog extends JDialog{

	private JButton btn = new JButton("increase");
	private int cnt = 0;
	private JLabel number;
	
	public MagicDialog(int value) {
		cnt = value;
		number = new JLabel(String.valueOf(cnt));
		setLayout(new FlowLayout());

		add(number);
		add(btn);
		
		setSize(300, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public JButton getBtn() {
		return btn;
	}
	
	public int getNumber() {
		return cnt;
	}
	
	public void increase() {
		cnt++;
		number.setText(String.valueOf(cnt));
	}
}
