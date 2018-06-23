import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller {
	
	
	public Controller(MainFrame view) {
		view.getMagicBtn().addActionListener(l -> {
			MagicDialog dialog = new MagicDialog(0);
			dialog.getBtn().addActionListener(e -> {
				System.out.println("open dialog");
				dialog.increase();
			});
			
			dialog.addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosed(WindowEvent arg0) {
					view.setMagicVal(dialog.getNumber());
				}
				
			});
			
		});
		
		
		
		
		view.getStrengthBtn().addActionListener(l -> {
			StrengthDialog dialog = new StrengthDialog(0);
			dialog.getBtn().addActionListener(e -> {
				System.out.println("open dialog");
				dialog.increase();
			});
			
			dialog.addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosed(WindowEvent arg0) {
					view.setStrengthVal(dialog.getNumber());
				}
				
			});
			
		});
		
		
		
	}

	
	public static void main(String[] args) {
		new Controller(new MainFrame());
	}
}
