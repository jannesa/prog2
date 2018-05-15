package timer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockView extends JFrame implements Observer {


	private JButton startBtn = new JButton("Start");
	private JButton stopBtn = new JButton("Stop");
	private JLabel valueLabel = new JLabel("0");

	public ClockView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(new BorderLayout(0, 0));
		
		JPanel timePanel = new JPanel();
		add(timePanel);
		timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		timePanel.add(valueLabel);
		
		JLabel secLabel = new JLabel("s");
		timePanel.add(secLabel);
		
		JPanel btnPanel = new JPanel();
		add(btnPanel, BorderLayout.SOUTH);
		
		btnPanel.add(startBtn);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		btnPanel.add(horizontalStrut);
		
		btnPanel.add(stopBtn);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public JButton getStartBtn() {
		return startBtn;
	}
	
	public JButton getStopBtn() {
		return stopBtn;
	}
	
	

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Integer) {
			valueLabel.setText(String.valueOf((Integer)arg));
			setVisible(true);
		}
	}
}
