import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This class is combine everything to complete the game
 * 
 * @author Ching2 Huang
 *
 */
public class IceCreamShop extends JPanel implements ActionListener {

	private IceCreamLine line;// the order line
	private IceCreamLineManager manager;// manger of the line
	private IceCreamMaker maker; // the making space
	private int score = 0; // the score
	private int wrongCounter = 0; // keeping track the number of wrong serves
	private int serveCounter; // count how many ice creams are served
	private int level = 1; // game start with level 1
	// the label for the score, level, wrong orders
	private JLabel scoreLabel, levelLabel, wrongLabel;
	private JButton serve; // the serve button
	private Timer gameTimer; // timer for create a new cone
	private static int DEFAULT_ORDER_RATE = 4000;// default create an order rate
	private int orderRate; // create an order rate

	/**
	 * Constructor add the information, serve button, making space, and the line
	 * to panel
	 */
	public IceCreamShop() {
		// create a new manager and maker
		manager = new IceCreamLineManager();
		maker = new IceCreamMaker();
		// the line is the line from the iceCreamLineManager class
		line = manager.getLine();
		// use borderLayout
		setLayout(new BorderLayout());
		// add info and serve button to the top of the panel
		add(northPanel(), BorderLayout.NORTH);
		// add the making space to the center of the panel
		add(maker, BorderLayout.CENTER);
		// add the line to the left of the panel
		add(manager, BorderLayout.WEST);
		setFocusable(true);
		orderRate = 4000; // start with 4 seconds
		setupTimer(); // start the timer
	}

	/**
	 * create a timer for showing a new order
	 */
	private void setupTimer() {
		gameTimer = new Timer(orderRate, this);
		gameTimer.setInitialDelay(DEFAULT_ORDER_RATE);
		// set the initial drop rate to default value
		gameTimer.start(); // start the animation
	}

	/**
	 * create actions for serve button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if there's order in the line
		if (e.getSource().equals(serve)) {
			// check the serves and start a new round
			checkAndRemove();
		} else if (e.getSource().equals(gameTimer)) {
			// add a new order to the line
			manager.addNewOrder();
		}
		// if the line is too long or there are three wrong orders
		if (line.gameOver() || wrongCounter == 3) {
			// exit the game
			System.exit(0);
		}
		// update the level
		levelLabel.setText("Level: " + level);
		// update the number of wrong orders
		wrongLabel.setText("Wrong Order: " + wrongCounter);
		// added a component
		validate();
		// repaint now that it's changed
		repaint();
	}

	/**
	 * check whether the player is serving correctly
	 * 
	 * @return true when the serve is correct
	 */
	private boolean serve() {
		// the cone in the line
		IceCreamCone lineCone = manager.getIceCream();
		// the cone the player made
		IceCreamCone makerCone = maker.getIceCream();

		// get two flavor list from each cone
		StackLL<String> lineList = lineCone.getFlavor();
		StackLL<String> makerList = makerCone.getFlavor();

		// if they have the same flavor, remove the flavor from each list
		while (makerList.peek() == lineList.peek()) {
			makerList.pop();
			lineList.pop();
			// if one the list is not empty, that means the flavors are
			// different
			if (makerList.isEmpty() && lineList.isEmpty()) {
				return true;
			}
		}
		// otherwise, return false
		return false;
	}

	/**
	 * create labels for the information and create a panel to contain all the
	 * information of the game
	 * 
	 * @return a panel with info
	 */
	private JPanel infoPanel() {
		// create JLable for all info
		String info1 = "Make ice cream cones to match the next order (at the top).";
		String info2 = "Every correct order served earns you 10 points.";
		String info3 = "Make the wrong cone and you'll lose 5 points.";
		String info4 = "Three wrong serves would lose the game";

		// create panels for each label
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		// create panel to contain everything
		JPanel panel = new JPanel();
		// use gridlayout to contain elements
		panel.setLayout(new GridLayout(8, 1));
		// add everything in panel
		panel.add(panel1.add(new JLabel(info1)));
		panel.add(panel2.add(new JLabel(info2 + info3)));
		panel.add(panel4.add(new JLabel(info4)));
		panel.add(panel3.add(new JLabel()));
		panel.add(panel4.add(scoreLabel = new JLabel("score: " + score)));
		panel.add(panel5.add(levelLabel = new JLabel("Level: " + level)));
		panel.add(panel3.add(wrongLabel = new JLabel("Wrong Order: "
				+ wrongCounter)));
		panel.add(panel4.add(new JLabel()));

		return panel;
	}

	/**
	 * create a serve button and add it to the panel with info
	 * 
	 * @return a panel with info and serve button
	 */
	private JPanel northPanel() {
		// create a panel to contain everything
		JPanel panel = new JPanel();
		// use borderLayout
		panel.setLayout(new BorderLayout());
		// add the information to the north
		panel.add(infoPanel(), BorderLayout.NORTH);
		// create a serve button
		serve = new JButton("Serve the next order");
		serve.addActionListener(this); // tell the button what to do
		panel.add(serve, BorderLayout.CENTER); // add button to the center

		return panel;
	}

	/**
	 * create levels for this game. every 5 serves would increase the level and
	 * the speed
	 */
	private void level() {
		switch (serveCounter) {
		case 5: // serve 5 orders
			level++; // level: 2
			orderRate -= 1000; // speed: 3000
			break;
		case 10: // serve 10 orders
			level++; // level: 3
			orderRate -= 1000; // speed: 2000
			break;
		case 15: // serve 15 orders
			level++; // level: 4
			orderRate -= 500; // speed: 1500
			break;
		case 20: // serve 20 orders
			level++; // level: 5
			orderRate -= 500; // speed: 1000
		case 25: // serve 25 orders
			level++; // level: 6
			orderRate -= 500; // speed: 500
		}
		gameTimer.setDelay(orderRate);
	}

	/**
	 * check the serves. remove the scoops in the maker space and cone in the
	 * line
	 */
	private void checkAndRemove() {
		// if there's order in the line
		if (!manager.emptyLine()) {
			// if the player serve the order correct, plus ten points
			// otherwise, minus 5 points
			// count the total serves of the player to update the level
			if (serve()) {
				serveCounter++;
				score += 10;
			} else {
				serveCounter++;
				// count the wrong serves
				wrongCounter++;
				score -= 5;
			}
			// remove the cone in the line
			line.removeCone();
			// remove the ice cream in the maker
			maker.nextCone();
			// update the score
			scoreLabel.setText("score: " + score);
			// update the level
			level();
		}
	}
}
