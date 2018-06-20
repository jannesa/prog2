package Rectangle;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyController {
	private Rectangle rect = new Rectangle(200, 300, 300, 300);
	
	boolean lr = true ;
	
	public MyController(MyFrame view) {
		view.getPanel().setRect(rect);
		
		Timer timer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(lr){					
					rect.x -= 10;					
					if(rect.x <0){
						lr = false ;
					}
				}
				
				else if(!lr) {
					rect.x += 10;
					if(rect.x > 700){
						lr = true ;
					}
				}
				view.getPanel().repaint();
			}
		});
		
		timer.start();
	}
	
}
