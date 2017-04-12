/**
 * This class linked the nodes together to create a list
 * 
 * Ching2 Huang
 */
public class LinkedList<T> {

	private LinkedListNode<T> head;//the head of the list

	/**
	 * Constructor creates a empty list
	 */
	public LinkedList() {
		this.head = null;
	}

	/**
	 * Constructor creates a list and pass in head node
	 */
	public LinkedList(LinkedListNode<T> head) {
		this.head = head;
	}

	/**
	 * Get data stored in head node of list.
	 */
	public T getFirst() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}
	}

	/**
	 * Get the head node of the list.
	 */
	public LinkedListNode<T> getFirstNode() {
		return head;
	}

	/**
	 * Get data stored in last node of list.
	 */
	public T getLast() {
		// if the list doens't exist, return null
		if (isEmpty()) {
			return null;
		} else { // if the list exits
			// node is the head
			LinkedListNode<T> node = head;
			// while the nextNode is not the last value
			while (node.getNext() != null) {
				// keep looking for the next node until nextNode is last
				// node
				node = node.getNext();
			}
			// if nextNode's next node is null, nextNode is the last node
			// so return the value of last node
			return node.getData();
		}
	}

	/**
	 * Get the tail node of the list.
	 */
	public LinkedListNode<T> getLastNode() {
		// if the list doens't exist, return null
		if (isEmpty()) {
			return null;
		} else {// if the list exits
			// node is the head
			LinkedListNode<T> node = head;

			// while the node is not the last value
			while (node.getNext() != null) {
				// keep looking for the next node until nextNode is last
				// node
				node = node.getNext();
			}
			// if nextNode's next node is null, nextNode is the last node
			// so return the last node
			return node;
		}
	}

	/**
	 * Insert a new node with data at the head of the list.
	 */
	public void insertFirst(T data) {
		// create a new node to insert
		LinkedListNode<T> newNode = new LinkedListNode<T>(data);
		// set value for the new node
		newNode.setData(data);
		// if the list exists
		if (isEmpty() == false) {
			// set the newNode to connect with the head
			newNode.setNext(head);

			// newNode replace the head
			head = newNode;
		} else {
			// if the link doens't exist, set the newNode as the head of the
			// list
			head = newNode;
		}
	}

	/**
	 * Insert a new node with data after currentNode
	 */
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		// if the list has at lease one node
		if (isEmpty() == false) {
			// create a new node to insert
			LinkedListNode<T> newNode = new LinkedListNode<T>(data);

			// get the original next node of the current node
			LinkedListNode<T> nextNode = currentNode.getNext();

			// set newNode as the next node of currentNode
			currentNode.setNext(newNode);
			// set the original next node as the next node of newNode
			newNode.setNext(nextNode);
		}
	}

	/**
	 * Insert a new node with data at the end of the list.
	 */
	public void insertLast(T data) {
		// if the list exits
		if (!isEmpty()) {
			// create a new node to insert
			LinkedListNode<T> newNode = new LinkedListNode<T>(data);

			// get the last node of the list
			LinkedListNode<T> lastNode = getLastNode();

			// set newNode as the last node of the list
			lastNode.setNext(newNode);
		}
	}

	/**
	 * Remove the first node
	 */
	public void deleteFirst() {
		// if the list exists
		if (isEmpty() == false) {
			// set head to the next node of the original head
			head = head.getNext();
		}
	}

	/**
	 * Remove the last node
	 */
	public void deleteLast() {
		// if the list exists
		if (!isEmpty()) {

			// head is the only node
			if (head.getNext() == null) {
				head = null;
				return;
			}

			// node is the head
			LinkedListNode<T> node = head;

			// lastNode is the last node of the list
			LinkedListNode<T> lastNode = getLastNode();

			// while the next node of the node is not the lastNode
			while (node.getNext() != lastNode) {
				// keep looking for the next node
				node = node.getNext();
			}
			// if the next node is the lastNode, set the node as the last
			// node of the list
			node.setNext(null);
		}
	}

	/**
	 * Remove node following currentNode If no node exists (i.e., currentNode is
	 * the tail), do nothing
	 */
	public void deleteNext(LinkedListNode<T> currentNode) {
		// check if currentNode and the node next to currentNode exist
		if (currentNode != null && currentNode.getNext() != null) {
			// delete the middle node
			currentNode.setNext(currentNode.getNext().getNext());
		}
	}

	/**
	 * Return the number of nodes in this list.
	 */
	public int size() {
		// the size of the list
		int size = 0;

		// node is the head
		LinkedListNode<T> node = head;

		while (node != null) {
			// increase one more node
			size++;

			// update the node
			node = node.getNext();
		}
		// return the total size of the list
		return size;
	}

	/**
	 * Check if list is empty.
	 * 
	 * @return true if list contains no items.
	 */
	public boolean isEmpty() {
		// if the head doesn't exist, this is an empty list
		return head == null;
	}

	/**
	 * Return a String representation of the list.
	 */
	public String toString() {
		if (isEmpty() == false) {
			String arrow = " -> ";
			LinkedListNode<T> nextNode = head;
			String listString = head.toString();
			while (nextNode.getNext() != null) {
				nextNode = nextNode.getNext();
				listString = listString + arrow + nextNode.toString();
			}
			return listString;
		} else {
			return "empty";
		}
	}
}