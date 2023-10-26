class LinkedChainBase<T> {
	private int size;
	private Node<T> firstNode;

	public LinkedChainBase() {
		size = 0;
		firstNode = null;
	}

	public void add(T item) {
		Node<T> newNode = new Node<>(item, firstNode);
		firstNode = newNode;
		size++;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node<T> current = firstNode;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (index == 0) {
			firstNode = firstNode.getNext();
		} else {
			Node<T> current = firstNode;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());
		}
		size--;
	}

	public int size() {
		return size;
	}
}