import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;
/**
 * this class is the model and view of the ice cream game model: add and remove
 * data view: paint the ice cream by accessing the data in the list
 * 
 * @author Ching2 Huang
 *
 */
public class IceCreamCone extends JComponent {

	// the list to store the value of ice creams
	private StackLL<String> flavorList = new StackLL<String>();

	// The size of the cone
	private static final int CONE_WIDTH = 15;
	private static final int CONE_HEIGHT = CONE_WIDTH * 4;
	// the size of the scoop
	private static final int SCOOP_SIZE = 40;
	// over lap distance
	private static final int OVERLAP = 10;

	/**
	 * add data to flavorList stack
	 * 
	 * @param flavor
	 */
	public void add(String flavor) {
		flavorList.push(flavor);
	}

	/**
	 * remove data from the flavorList stack
	 */
	public void remove() {
		flavorList.pop();
	}

	/**
	 * paint the cone and the ice cream
	 */
	public void paint(Graphics g) {
		// paint cone
		cone(g); 
				
		// update the data of the flavorList
		paintIceCream(flavorList, g);
	}
	
	/**
	 * remove all the ice cream scoops
	 */
	public void removeScoops() {
		// if there are scoop on the cone, then remove them
		while (flavorList.peek() != null) {
			flavorList.pop();
		}
	}

	/**
	 * paint the scoops of ice cream
	 * 
	 * @param flavorList
	 */
	private void paintIceCream(StackLL<String> list, Graphics g) {
		// temporary list to access the first added data in flavor list
		StackLL<String> tmp = new StackLL<String>();

		// while the list exist
		while (!list.isEmpty()) {
			// tmp stack add the last added ice cream in the flavor list
			tmp.push(list.pop());
		}

		// to keep track the number of scoop and reset the data
		int scoopNum = 1;

		// while tmp list exists, paint the scoop
		while (!tmp.isEmpty()) {
			// check what flavor to paint then paint the scoop
			// after painting, pop the data in the tmp list and push it back to
			// list
			// finally, update scoopNum
			switch (tmp.peek()) {
			case "vanilla":
				addScoop(g, Color.WHITE, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "strawberry":
				addScoop(g, Color.PINK, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "greenTea":
				addScoop(g, Color.GREEN, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "caramel":
				addScoop(g, Color.ORANGE, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			}
		}
	}

	/**
	 * create random number of scoops on the cone with random flavor ice cream
	 */
	public void randomCone() {
		// generate random number to decide flavor
		Random rand = new Random();
		int randomScoop = 1 + rand.nextInt(4);

		// loop through the number of scoops for each cone
		for (int i = 1; i <= randomScoop; i++) {
			randFlavor();
		}
	}

	/**
	 * add a random flavor scoop
	 * 
	 * @param g
	 */
	private void randFlavor() {
		// generate random number to decide flavor
		Random random = new Random();
		int randomFlavor = random.nextInt(4); // 0-3

		// check the number of randomFlavor
		switch (randomFlavor) {
		case 0:
			// vanilla
			add("vanilla");
			break;
		case 1:
			// strawberry
			add("strawberry");
			break;
		case 2:
			// greenTea
			add("greenTea");
			break;
		case 3:
			// caramel
			add("caramel");
			break;
		}
	}

	/**
	 * paint one fillOval for the scoop, pass in the color of the ice cream and
	 * the number of ice creams
	 *
	 * @param g
	 * @param color
	 * @param scoopNumber
	 */
	private void addScoop(Graphics g, Color color, int n) {
		// xLoc is the x location of the scoop
		// yLoc is the y location of the scoop. Increase by multiplying the
		// number of scoops
		int xLoc = this.getWidth() / 2 - SCOOP_SIZE / 2;
		int yLoc = this.getHeight() - CONE_HEIGHT - (SCOOP_SIZE - OVERLAP) * n;
		// be able to change color for each flavor
		g.setColor(color);
		// paint the scoop
		g.fillOval(xLoc, yLoc, SCOOP_SIZE, SCOOP_SIZE);
	}

	/**
	 * paint a cone for the ice cream
	 * 
	 * @param g
	 */
	private void cone(Graphics g) {
		// the color of the cone
		Color coneColor = new Color(250, 180, 90);
		g.setColor(coneColor);
		g.fillPolygon(new int[] { this.getWidth() / 2,
				this.getWidth() / 2 - CONE_WIDTH,
				this.getWidth() / 2 + CONE_WIDTH },
				new int[] { this.getHeight(), this.getHeight() - CONE_HEIGHT,
						this.getHeight() - CONE_HEIGHT }, 3);
	}

	/**
	 * convert the data to string
	 * @return the flavorList to string
	 */
	public String getList() {
		return flavorList.toString();
	}

	/**
	 * get the flavorList of this cone
	 * @return the list of data of this cone
	 */
	public StackLL<String> getFlavor() {
		return flavorList;
	}
}