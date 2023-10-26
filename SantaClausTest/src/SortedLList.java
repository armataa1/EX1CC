class SortedLList<T extends Comparable<T>> implements List<T> {
	private SortedAList<T> sortedList;

	public SortedLList() {
		sortedList = new SortedAList<>();
	}

	@Override
	public void add(T item) {
		sortedList.add(item);
	}

	@Override
	public void remove(int index) {
		sortedList.remove(index);
	}

	@Override
	public T get(int index) {
		return sortedList.get(index);
	}

	@Override
	public int size() {
		return sortedList.size();
	}
}
