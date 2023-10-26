class LList<T> implements List<T> {
	private LinkedChainBase<T> chainBase;

	public LList() {
		chainBase = new LinkedChainBase<>();
	}

	@Override
	public void add(T item) {
		chainBase.add(item);
	}

	@Override
	public void remove(int index) {
		chainBase.remove(index);
	}

	@Override
	public T get(int index) {
		return chainBase.get(index);
	}

	@Override
	public int size() {
		return chainBase.size();
	}
}