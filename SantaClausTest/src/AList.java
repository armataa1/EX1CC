import java.util.AbstractList;

class AList<T> extends AbstractList<T> {
	private Object[] array;
	private int size;

	public AList() {
		array = new Object[10];
		size = 0;
	}

	public AList(int capacity) {
		array = new Object[capacity];
		size = 0;
	}

	@Override
	public boolean add(T item) {
		if (size == array.length) {
			// Resize the array if it's full
			Object[] newArray = new Object[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}
		array[size++] = item;
		return true;
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		// Ensure capacity
		if (size == array.length) {
			Object[] newArray = new Object[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

		// Shift elements to make space for the new element
		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		// Insert the new element at the specified index
		array[index] = element;
		size++;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		T removedElement = (T) array[index];

		// Shift elements to fill the gap left by the removed element
		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;
		return removedElement;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		return (T) array[index];
	}

	@Override
	public int size() {
		return size;
	}

	// Custom indexOf method to find an item in the list
	@Override
	public int indexOf(Object item) {
		for (int i = 0; i < size; i++) {
			if (item.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}
}
