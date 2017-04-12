/**
 * This is class to modify the queue data
 * 
 * @author Ching2 Huang
 *
 * @param <T> take in any type
 */
public class QueueLL<T> implements Queue<T> {

	//the list to store the stack
	private LinkedList<T> list = new LinkedList<T>();;
	
	/**
	 * Tests if the queue is empty.
	 * 
	 * @return true iff the queue is empty
	 **/
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 * 
	 * @return the peeked data
	 **/
	@Override
	public T peek() {
		return list.getLast();
	}

	/**
	 * Removes the front element of the queue and returns it.
	 * 
	 * @return the dequeued data
	 **/
	@Override
	public T dequeue() {
		// get the data of the queue
		T data = list.getLast();
		// delete the data
		list.deleteLast();
		// return the deleted data
		return data;
	}

	/**
	 * Adds an element to the end of the queue.
	 **/
	@Override
	public void enqueue(T data) {
		list.insertFirst(data);
	}
	
	/**
	 * Returns a String representation of the queue.
	 * 
	 * @return stack as String
	 */
	public String toString(){
		return list.toString();
	}
	
	/**
	 * get the number of orders
	 * @return the size of orders
	 */
	public int getSize(){
		return list.size();
	}
	
}
