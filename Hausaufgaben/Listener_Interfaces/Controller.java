import javax.swing.event.ChangeEvent;
import java.awt.Color;
import javax.swing.event.ChangeListener;

public class Controller {
	
	public Controller(Slider Slider) {
		
		//Listener der Textfelder.
		Slider.getBlueValue().addActionListener(l -> {
			try {
				int val = Integer.valueOf(Slider.getBlueValue().getText());
				if (val >= 0 && val <= 255) {
					Slider.update(Color.BLUE, val);					
				}
				else 
				{
					Slider.update(Color.BLUE, Slider.getBlueSlider().getValue());													
				}
			} catch (NumberFormatException e) {
				Slider.update(Color.BLUE, Slider.getBlueSlider().getValue());													
			}
		});
		
		Slider.getGreenValue().addActionListener(l -> {
			try {
				int val = Integer.valueOf(Slider.getGreenValue().getText());
				if (val >= 0 && val <= 255) {
					Slider.update(Color.GREEN, val);					
				}
				else 
				{
					Slider.update(Color.GREEN, Slider.getGreenSlider().getValue());													
				}
			} catch (NumberFormatException e) {
				Slider.update(Color.GREEN, Slider.getGreenSlider().getValue());													
			}
		});

		Slider.getRedValue().addActionListener(l -> {
			try {
				int val = Integer.valueOf(Slider.getRedValue().getText());
				if (val >= 0 && val <= 255) {
					Slider.update(Color.RED, val);					
				}
				else 
				{
					Slider.update(Color.RED, Slider.getRedSlider().getValue());													
				}
			} catch (NumberFormatException e) {
				Slider.update(Color.RED, Slider.getRedSlider().getValue());													
			}
		});
		
		
		//Listener der Slider.
		Slider.getBlueSlider().addChangeListener(l -> {
			Slider.update(Color.BLUE, Slider.getBlueSlider().getValue());
		});

		Slider.getGreenSlider().addChangeListener(l -> {
			Slider.update(Color.GREEN, Slider.getGreenSlider().getValue());
		});

		Slider.getRedSlider().addChangeListener(l -> {
			Slider.update(Color.RED, Slider.getRedSlider().getValue());
		});

	}
	
	//Main, zum Ausführen des Programms.
	public static void main(String[] args) {
		new Controller(new Slider());
	}
}
