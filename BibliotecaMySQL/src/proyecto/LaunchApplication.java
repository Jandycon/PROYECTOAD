package proyecto;

import java.awt.EventQueue;

public class LaunchApplication {

	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
