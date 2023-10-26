class Name implements Comparable<Name> {
	private String firstName;
	private String lastName;
	private AList<String> gifts;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gifts = new AList<>();
	}

	public void addGift(String gift) {
		gifts.add(gift);
	}

	public String[] getGifts() {
		String[] giftArray = new String[gifts.size()];
		for (int i = 0; i < gifts.size(); i++) {
			giftArray[i] = gifts.get(i);
		}
		return giftArray;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public int compareTo(Name other) {
		// Compare names based on last name and then first name
		int lastNamesComparison = this.lastName.compareTo(other.lastName);
		if (lastNamesComparison != 0) {
			return lastNamesComparison;
		}
		return this.firstName.compareTo(other.firstName);
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	// Other methods for the Name class can be added as needed.
}
