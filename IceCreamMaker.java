import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class creates an ice cream , holds each action for each flavor buttons
 * 
 * @author Ching2 Huang
 *
 */
public class IceCreamMaker extends JPanel implements ActionListener {

	// the logic of the game
	private IceCreamCone cone;
	// the buttons to add or remove ice cream
	private JButton vanilla, strawberry, greenTea, caramel, eat;

	/**
	 * constructor add the game and button on the panel
	 */
	public IceCreamMaker() {
		// use a BorderLayout
		setLayout(new BorderLayout());
		//create a cone 
		cone = new IceCreamCone();
		// add the ice cream game to the center of the panel
		add(cone, BorderLayout.CENTER);
		// add the buttons on the top of the panel
		add(buttonPanel(), BorderLayout.NORTH);
		setFocusable(true);
	}

	/**
	 * create a panel to add all the buttons in it
	 * 
	 * return panel that contains all the buttons
	 */
	private JPanel buttonPanel() {
		// create the buttons for each flavor
		vanilla = button("vanilla", Color.WHITE);
		strawberry = button("strawberry", Color.PINK);
		greenTea = button("green tea", Color.GREEN);
		caramel = button("caramel", Color.ORANGE);

		// create a panel to contain 4 flavor buttons
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout()); // use flowlayout
		// add the buttons
		panel.add(vanilla);
		panel.add(strawberry);
		panel.add(greenTea);
		panel.add(caramel);

		// create a button for removing
		eat = new JButton("eat the scoop");
		eat.addActionListener(this); //add action to the button

		// create a bigger panel to contain all the buttons
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout(0, 0)); // use borderLayout
		bigPanel.add(panel, BorderLayout.NORTH); // add the flavor buttons to
													// the north
		bigPanel.add(eat, BorderLayout.CENTER); // add the remove button to the
												// center

		return bigPanel;
	}

	/**
	 * create a button and return a button
	 * 
	 * @param flavor
	 * @param color
	 * @return button
	 */
	private JButton button(String flavor, Color color) {
		// a button with a text on it
		JButton theButton = new JButton(flavor);
		theButton.setBackground(color); // the background color
		theButton.setBorderPainted(false); // don't paint the border
		theButton.setOpaque(true); // paint every pixel within it's bound
		theButton.addActionListener(this); // tell the buttons what to do
		return theButton;
	}

	/**
	 * tell each button what to do
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vanilla)) {// if vanilla button is clicked
			// add vanilla to the list
			cone.add("vanilla");
		} else if (e.getSource().equals(strawberry)) {// click strawberry button
			// add strawberry to the list
			cone.add("strawberry");
		} else if (e.getSource().equals(greenTea)) {// click green tea button
			//add green tea to the list
			cone.add("greenTea");
		} else if (e.getSource().equals(caramel)) { //click caramel button
			//add caramel to the list
			cone.add("caramel");
		} else if (e.getSource() == eat) {//click eat button
			//remove one scoop 
			cone.remove();
		}
		//repaint everything
		cone.repaint();
		cone.revalidate();
	}
	
	/**
	 * start a new cone
	 */
	public void nextCone(){
		//remove all the scoops
		cone.removeScoops();
	}
	
	/**
	 * get the ice cream from the maker/player
	 * @return the ice cream
	 */
	public IceCreamCone getIceCream(){
		return cone;
	}
}
