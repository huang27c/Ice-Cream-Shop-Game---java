/**
 * The Stack interface encapsulates the ADT for a stack data structure.
 */
public interface Stack<T> {

	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push(T data);

	/**
	 * Removes the top of the stack and returns it.
	 * 
	 * @return the popped data
	 */
	public T pop();

	/**
	 * Gets the element at the top of the stack without removing it.
	 * 
	 * @return the peeked data
	 */
	public T peek();

	/**
	 * Tests if the stack is empty.
	 * 
	 * @return true iff the stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns a String representation of the stack.
	 * 
	 * @return stack as String
	 */
	public String toString();
}
