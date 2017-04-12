import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * This class shows the game
 * 
 * @author Ching2 Huang
 *
 */

public class IceCreamApp {

	/**
	 * main method to show the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// the frame
		frame();
	}

	/**
	 * create a frame for the game
	 * 
	 * @return the frame
	 */
	private static JFrame frame() {
		//create a frame
		JFrame frame = new JFrame("Ice Cream Shop");
		frame.setSize(600, 650); //set the size for the frame

		frame.setResizable(false); // unable to resize the frame
		frame.setLocationRelativeTo(null);
		// default to the middle of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// shut down the game when the window is closed
		
		frame.setLayout(new BorderLayout());//use borderLayout
		frame.add(new IceCreamShop()); //add the game to the frame

		frame.setVisible(true);// make the frame visible

		return frame;
	}
}