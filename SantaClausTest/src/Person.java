

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;

	public Person(String first, String last) {
		firstName = first;
		lastName = last;

	}

	public Person(String fullName) {
		String[] parts = fullName.split("\\s+");
		firstName = parts[0];
		lastName = parts[1];
	}

	public String getFirst() {
		return firstName;
	}

	public String getLast() {
		return lastName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int compareTo(Person o) {
		return lastName.compareTo(o.getLast());
	}

}
