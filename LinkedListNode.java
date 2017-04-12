/**
 * This class creates a node for LinkedList class
 * 
 * Ching2 Huang
 */
public class LinkedListNode<T> {

	private T data;
	private LinkedListNode<T> next;

	/**
	 * Constructor to create a node
	 * 
	 * @param data
	 */
	public LinkedListNode(T data) {
		this.data = data;
		next = null;
	}

	/**
	 * Set the data stored at this node.
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Get the data stored at this node.
	 */
	public T getData() {
		if (data == null) {
			return null;
		} else {
			return data;
		}
	}

	/**
	 * Set the next pointer to passed node.
	 */
	public void setNext(LinkedListNode<T> node) {
		this.next = node;
	}

	/**
	 * Get (pointer to) next node.
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}

	/**
	 * Returns a String representation of this node.
	 */
	public String toString() {
		if (data == null) {
			return "";
		} else {
			return data.toString();
		}
	}
}
