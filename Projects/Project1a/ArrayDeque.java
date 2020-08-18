
/**
*ArrayDeque
* implemented in circular way
* @author Grace Li
*/


public class ArrayDeque {
	private T[] items;
	private int nextFirst;
	private int nextLast;
	private int size;

	/**
	 * Create an empty ArrayDeque
	 */
	public ArrayDeque() {
		//Need to cast since Java does not allow to create new generic array directly.
		items = (T[] new Object[8]);
		nextFirst = 0;
		nextLast = 1;
		size = 0;
	}

	/**
	 * Return true if deque is full, false otherwise
	 */
	private boolean isFull() {
		return size == items.length;
	}

	/**
	 * Whether to downsize the deque.
	 */
	private boolean isSparse() {
		return items.length >= 16 && size < (items.length / 4);
	}

	/**
	 * Add one circularly
	 */
	private int plusOne(int index) {
		return (index + 1) % items.length;
	}

	/**
	 * Minus one circularly
	 */
	private int minusOne(int index) {
		// % represents remainder ranther than modulus
		return (index - 1 + items.length) % items.length;
	}

	/**
	 * Resize the deque
	 */
	private void resize(int capacity) {
		T[] newDeque = (T[]) new Object[capacity];
		int oldIndex = plusOne(nextFirst);
		for (int newIndex = 0; newIndex < size; newIndex++) {
			newDeque[newIndex] = items[oldIndex];
			oldIndex = plusOne(oldIndex);
		}
		items = newDeque;
		nextFirst = capacity - 1;//the new deque is starting from true 0 index
		nextLast = size;
	}

	/**
	 * Upsize the deque
	 */
	private void upSize() {
		resize(size * 2);
	}

	/**
	 * Downsize the deque
	 */
	private void downSize() {
		resize(items.length / 2);
	}

	/**
	 * Return true if deque is empty, otherwise return false
	 */
	public boolean isEmpty() {
		return size;
	}

	/**
	 * Print an item of type Item to the front of the deque
	 */
	public void printDeque() {
		for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Add an item of type Item to the front of the deque.
	 */
	public void addFirst(T x) {
		if (isFull()) {
			upSize();
		}
		items[nextFirst] = x;
		nextFirst = minusOne(nextFirst);
		size += 1;
	}

	/**
	 * Add an item of type Item to the back of deque.
	 */
	public void addLast(T x) {
		if (isFull()) {
			upSize();
		}
		items[nextLast] = x;
		nextLast = plusOne(nextLast);
		size += 1;
	}

	/**
	 * Remove and return the item at the front of the deque.
	 * If no such item exist, return null
	 */
	public T removeFirst() {
		if (isSparse()) {
			downSize();
		}
		nextFirst = plusOne(nextFirst);
		T toRemove = items[nextFirst];
		items[nextFirst] = null;
		if (!isEmpty()) {
			size -= 1;
		}
		return toRemove;
	}

	/**
	 * Remove & return the item at the back of the deque.
	 */
	public T removeLast() {
		if (isSparse()) {
			downSize();
		}
		nextLast = minusOne(nextLast);
		T toRemove = items[nextLast];
		items[nextLast] = null;
		if (!isEmpty()) {
			size -= 1;
		}
		return toRemove;
	}

	/**
	 * Get item and not alter the deque
	 */
	public T get(int index) {
		if (index >= size) {
			return null;
		}
		int start = plusOne(nextFirst);
		return items[(start + index) % items.length];
	}

	/**
	 * Create a deep copy of other.
	 */
	public ArrayDeque(ArrayDeque other) {
		items = (T[]) new Object[other.size];
		nextFirst = other.nextFirst;
		nextLast = other.nextLast;
		size = other.size;

		System.arraycopy(other.items, 0, items, 0, other.size);
	}
} 
