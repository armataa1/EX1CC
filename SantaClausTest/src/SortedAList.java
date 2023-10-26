class SortedAList<T extends Comparable<T>> implements List<T> {
	private T[] array;
	private int size;

	public SortedAList() {
		array = (T[]) new Comparable[10];
		size = 0;
	}

	@Override
	public void add(T item) {
		if (size == array.length) {
			// Resize the array if it's full
			T[] newArray = (T[]) new Comparable[array.length * 2];
			System.arraycopy(array, 0, newArray, 0, array.length);
			array = newArray;
		}

		int index = 0;
		while (index < size && item.compareTo(array[index]) > 0) {
			index++;
		}

		for (int i = size; i > index; i--) {
			array[i] = array[i - 1];
		}

		array[index] = item;
		size++;
	}

	@Override
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		for (int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}

		size--;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		return array[index];
	}

	@Override
	public int size() {
		return size;
	}
}
