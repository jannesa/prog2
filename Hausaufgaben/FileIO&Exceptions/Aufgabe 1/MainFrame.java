import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JButton magicBtn = new JButton();
	private JButton strengthBtn = new JButton();
	private JLabel magicVal = new JLabel("0");
	private JLabel strengthVal = new JLabel("0");
	
	
	public MainFrame() {

		ImageIcon img1 = new ImageIcon("Z:\\eclipse\\Temp\\images\\figure.png");
		ImageIcon img2 = new ImageIcon("Z:\\eclipse\\Temp\\images\\images.jpg");
		ImageIcon img3 = new ImageIcon("Z:\\eclipse\\Temp\\images\\images3.jpg");
		JLabel label = new JLabel();
		label.setIcon(img1);
		magicBtn.setIcon(img2);
		strengthBtn.setIcon(img3);

		Box box = new Box(BoxLayout.X_AXIS);
		box.add(Box.createHorizontalStrut(10));
		box.add(new Label("Magic"));
		box.add(magicVal);
		box.add(Box.createHorizontalStrut(10));
		box.add(magicBtn);
		box.add(Box.createHorizontalStrut(10));
		box.add(new Label("Strength"));
		box.add(strengthVal);
		box.add(Box.createHorizontalStrut(10));
		box.add(strengthBtn);
		box.add(Box.createHorizontalStrut(10));
		
		add(label);
		add(box, BorderLayout.SOUTH);

		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public JButton getMagicBtn() {
		return magicBtn;
	}
	
	public JButton getStrengthBtn() {
		return strengthBtn;
	}
	
	public void setMagicVal (int value) {
		magicVal.setText(String.valueOf(value));
	}
	
	public void setStrengthVal (int value) {
		strengthVal.setText(String.valueOf(value));
	}
}
