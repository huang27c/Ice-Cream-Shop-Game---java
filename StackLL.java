/**
 * This is class to modify the stack data
 * 
 * @author Ching2 Huang
 *
 * @param <T> take in any type 
 */
public class StackLL<T> implements Stack<T> {

	// list stores the stack
	private LinkedList<T> list = new LinkedList<T>();

	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push(T data) {
		list.insertFirst(data);
	}

	/**
	 * Removes the top of the stack and returns it.
	 * 
	 * @return the popped data
	 */
	public T pop() {
		T data = list.getFirst();
		list.deleteFirst();
		return data;
	}

	/**
	 * Gets the element at the top of the stack without removing it.
	 * 
	 * @return the peeked data
	 */
	public T peek() {
		return list.getFirst();
	}

	/**
	 * Checking if the list exists
	 * 
	 * @return true if the list doesn't exist
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Returns a String representation of the stack.
	 * 
	 * @return stack as String
	 */
	public String toString() {
		return list.toString();
	}
}
