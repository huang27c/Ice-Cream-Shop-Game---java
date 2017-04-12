import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * this is a view class for the IceCreamLine.
 * 
 * @author Ching2 Huang
 *
 */

public class IceCreamLineManager extends JPanel implements ActionListener {

	// button to add a cone
	private JButton add;
	private IceCreamLine line; // the line of ice cream order

	/**
	 * constructor initializes iceCreamLine and add components to the panel
	 */
	public IceCreamLineManager() {
		line = new IceCreamLine();

		// use border layout for this panel
		setLayout(new BorderLayout());
		add(butPanel(), BorderLayout.SOUTH); // add button to the top of the
												// panel
		add(line, BorderLayout.CENTER); // add the ice cream line to the center
	}

	/**
	 * create add button and add it to a panel
	 * 
	 * @return panel that contains add button
	 */
	private JPanel butPanel() {
		// create add cone buttons
		add = new JButton("Add a random order");
		add.addActionListener(this); // add action to the button

		// create a panel for the button
		JPanel panel = new JPanel();
		panel.add(add); // add button to the panel

		// return the panel
		return panel;
	}

	/**
	 * Create action for add button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// add a cone
		line.addCone();

		if (line.gameOver()) {
			System.exit(0);
		}

		// added a component
		validate();
		// repaint now that it's changed
		repaint();
	}

	/**
	 * get the line of order
	 * 
	 * @return the IceCreamLine in this class
	 */
	public IceCreamLine getLine() {
		return line;
	}

	/**
	 * get the first order's ice cream
	 * 
	 * @return the list of the cone
	 */
	public IceCreamCone getIceCream() {
		return line.iceCream();
	}

	/**
	 * check if there's a line
	 * 
	 * @return true when the line is empty
	 */
	public boolean emptyLine() {
		return line.emptyLine();
	}

	/**
	 * add a new cone to the order
	 */
	public void addNewOrder() {
		// add a cone
		line.addCone();
	}
}