package Rectangle;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	private Rectangle rect = new Rectangle(200, 300, 300, 300);
	Random rand = new Random();
	
	int  rot ;
	int  grün ;
	int  blau ;
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if(rect.x >=700 || rect.x <=0){
			rot = rand.nextInt(255);
			grün = rand.nextInt(255);
			blau = rand.nextInt(255);
		}
		
		g.setColor(new Color(rot, grün, blau));
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
}
