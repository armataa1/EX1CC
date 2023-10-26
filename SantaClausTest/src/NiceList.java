interface NiceList {
	void addNicePerson(String firstName, String lastName, String[] gifts);

	void addGift(String firstName, String lastName, String gift);

	void makeNiceToNaughty(String firstName, String lastName);

	void makeNaughtyToNice(String firstName, String lastName);

	void printNiceList();

	void printNaughtyList();
}