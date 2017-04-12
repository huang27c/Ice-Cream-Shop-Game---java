import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * This class maintains a queue of ice cream cone orders
 * 
 * @author Ching2 Huang
 *
 */
public class IceCreamLine extends Box {

	// order is the queue list to store the data
	private QueueLL<IceCreamCone> order;

	/**
	 * constructor initializes the order and use BoxLayOut
	 */
	public IceCreamLine() {
		// use boxLayout vertically
		super(BoxLayout.Y_AXIS);
		// setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		order = new QueueLL<IceCreamCone>();
	}

	/**
	 * add a random cone
	 */
	public void addCone() {
		// every time the method is called, create a new cone
		IceCreamCone aCone = new IceCreamCone();
		// randomize the scoops and flavor
		aCone.randomCone();
		// add the cone to the panel
		add(aCone);
		// add the data to the queue list
		order.enqueue(aCone);

		// added a component
		revalidate();
		// repaint now that it's changed
		repaint();
	}

	/**
	 * remove a cone from the queue list
	 */
	public void removeCone() {
		// if the order exists, remove it from the order
		if (order.peek() != null) {
			order.dequeue();
			// remove the first component
			remove(0);
		}
	}

	/**
	 * see the first order
	 * 
	 * @return the first order's ice cream
	 */
	public IceCreamCone iceCream() {
		return order.peek();
	}

	/**
	 * check whether there's order
	 * 
	 * @return true when the queue is empty
	 */
	public boolean emptyLine() {
		return order.isEmpty();
	}

	/**
	 * check if there are four orders then
	 * @return true when there are 4 orders
	 */
	public boolean gameOver() {
		//check the size of the list
		if(order.getSize() == 4){
			//when there are four orders, end the game
			return true;
		}
		//otherwise, keep playing
		return false;
	}
}
