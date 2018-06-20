import java.awt.Color;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;




public class Slider extends JFrame{
	//Erstellen der Textfelder zur eingabe.
	private JTextField redInput = new JTextField("0");
	private JTextField greenInput = new JTextField("0");
	private JTextField blueInput = new JTextField("0");
	//Erstellen der Slider.
	private JSlider redSlider = new JSlider(0, 255, 0);
	private JSlider greenSlider = new JSlider(0, 255, 0);
	private JSlider blueSlider = new JSlider(0, 255, 0);
	//Erstellen der Label.
	private JLabel redText = new JLabel("Rot");
	private JLabel greenText = new JLabel("Grün");
	private JLabel blueText = new JLabel("Blau");
  
	//Erstellen des Output Panel, um die Farben anzuzeigen.
	private JPanel output = new JPanel();
  



	public Slider(){
		//Panel um alle Input-"Geräte" anzuzeigen.
	    JPanel InputPanel = new JPanel();
	    InputPanel.setBackground(Color.LIGHT_GRAY);
	    InputPanel.setLayout(new BoxLayout(InputPanel, 0));
	    
	    //Panel um Label anzuzeigen.
	    JPanel descriptionPanel = new JPanel();
	    descriptionPanel.setBackground(Color.LIGHT_GRAY);
	    descriptionPanel.setLayout(new BoxLayout(descriptionPanel, 1));
	    redText.setForeground(Color.RED);
	    redText.setBackground(Color.LIGHT_GRAY);
	    descriptionPanel.add(redText);
	    greenText.setForeground(Color.GREEN);
	    greenText.setBackground(Color.LIGHT_GRAY);
	    descriptionPanel.add(greenText);
	    blueText.setForeground(Color.BLUE);
	    blueText.setBackground(Color.LIGHT_GRAY);
	    descriptionPanel.add(blueText);
	    
	    //panel um Slider anzuzeigen.
	    JPanel sliderPanel = new JPanel();
	    sliderPanel.setLayout(new BoxLayout(sliderPanel, 1));
	    redSlider.setBackground(Color.LIGHT_GRAY);
	    redSlider.setForeground(Color.RED);
	    sliderPanel.add(redSlider);
	    greenSlider.setBackground(Color.LIGHT_GRAY);
	    sliderPanel.add(greenSlider);
	    blueSlider.setBackground(Color.LIGHT_GRAY);
	    sliderPanel.add(blueSlider);
	    
	    //Panel um Textfelder anzuzeigen.
	    JPanel ValuePanel = new JPanel();
	    ValuePanel.setLayout(new BoxLayout(ValuePanel, 1));
	    redInput.setBackground(Color.RED);
	    ValuePanel.add(redInput);
	    greenInput.setBackground(Color.GREEN);
	    ValuePanel.add(greenInput);
	    blueInput.setBackground(Color.BLUE);
	    ValuePanel.add(blueInput);
	    
	    //Unterpanel einem Hauptpanel hinzufügen. 
	    InputPanel.add(descriptionPanel);
	    InputPanel.add(sliderPanel);
	    InputPanel.add(ValuePanel);
	    
	    //Anordnugn der beiden Hauptpanel.
	    getContentPane().add(output, "Center");
	    getContentPane().add(InputPanel, "South");
	    
	    //Letzte Einstellungen. 
	    output.setBackground(Color.BLACK);
	    setTitle("Farbmischer");
	    setSize(300, 300);
	    setDefaultCloseOperation(3);
	    setVisible(true);
	}
  

	//Bei Änderung der Slider oder Textfelder wird hiermit die GUI aktualisiert.
	public void update(Color color, int value){
	    if (color == Color.BLUE) {
	    	blueSlider.setValue(value);
	    	blueInput.setText(String.valueOf(value));
	    }
	    else if (color == Color.GREEN) {
		    greenSlider.setValue(value);
		    greenInput.setText(String.valueOf(value));
	    }
	    else if (color == Color.RED) {
	    	redSlider.setValue(value);
	    	redInput.setText(String.valueOf(value));
	    }
	    output.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
	}
  

	
	public JTextField getRedValue(){
		return redInput;
	  }
	  
	public JTextField getGreenValue(){
		return greenInput;
	}
	  
	public JTextField getBlueValue(){
		return blueInput;
	}
	  
	public JSlider getRedSlider(){
		return redSlider;
	}
	  
	public JSlider getGreenSlider(){
		return greenSlider;
	}
	  
	public JSlider getBlueSlider(){
		return blueSlider;
	}
	  
	public JPanel getColorPanel(){
		return output;
	}
}
